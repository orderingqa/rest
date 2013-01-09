
package com.thu.api.dao.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.thu.api.dao.GenericDao;
import com.thu.api.domain.*;

/**
 *
 * @author liushuai
 */
@Repository
public abstract class GenericDaoImpl<DO extends DomainObject, ID extends Serializable>
        implements GenericDao<DO, ID> {

    protected final Logger logger = Logger.getLogger(getClass());
    
    @PersistenceContext
    protected EntityManager em;
    protected final Class<DO> type;
    protected String findAllQuery;

    /**
     * Constructs a new GenericDaoImpl. The constructor acesses the generic type
     * and saves a reference to be used when calling JPA methods
     */
    public GenericDaoImpl() {
        type = (Class<DO>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
        // set default find all query
        findAllQuery = "from " + getEntityName(type);
        if (logger.isDebugEnabled()) {
            logger.debug("creating dao for type: " + type);
        }
    }

    /** {@inheritDoc} */
    public DO create(DO domainObject) {
        if (logger.isDebugEnabled()) {
            logger.debug("create called for domainObject: " + domainObject);
//            logger.debug("username = " + ((IndividualCustomer)domainObject).getUsername());
//            logger.debug("password = " + ((IndividualCustomer)domainObject).getPassword());
        }

        em.persist(domainObject);
        return domainObject;
    }

    /** {@inheritDoc} */
    public DO load(ID id) throws EntityNotFoundException {
        if (logger.isDebugEnabled()) {
            logger.debug("load called for id: " + id);
        }
        DO domainObject = findById(id);
        if (domainObject == null) {
            throw new EntityNotFoundException(
                    "could not find " + getEntityName(type) + " with id: " + id);
        }
        return domainObject;
    }

    /** {@inheritDoc} */
    public DO findById(ID id) {
        if (logger.isDebugEnabled()) {
            logger.debug("findById called for id: " + id);
        }
        return em.find(type, id);
    }

    /** {@inheritDoc} */
    public DO update(DO domainObject) throws EntityNotFoundException {
        if (logger.isDebugEnabled()) {
            logger.debug("update called for domainObject: " + domainObject);
        }
        // attempt to load by ID to confirm that the domainObject is persistent
        load((ID)domainObject.getId());
        return em.merge(domainObject);
    }

    /** {@inheritDoc} */
    public void delete(DO domainObject) throws EntityNotFoundException {
        if (logger.isDebugEnabled()) {
            logger.debug("delete called for domainObject: " + domainObject);
        }
        em.remove(domainObject);
        em.flush();
    }

    /** {@inheritDoc} */
    public void delete(ID id) throws EntityNotFoundException {
        delete(load(id));
    }
    
    /** {@inheritDoc} */
    public void deleteAll() {
        em.createQuery("delete from " + getEntityName(type)).executeUpdate();
    }
    
    /** {@inheritDoc} */
    public List<DO> findAll() {
        if (logger.isDebugEnabled()) {
            logger.debug("findAll called");
        }
        return (List<DO>) em.createQuery(findAllQuery).getResultList();
    }
    
    /** {@inheritDoc} */
    public List<DO> findAll(int firstResult, int maxResults) {
        if (logger.isDebugEnabled()) {
            logger.debug("findAll called");
        }
        return (List<DO>) em.createQuery(findAllQuery)
                .setFirstResult(firstResult)
                .setMaxResults(maxResults)
                .getResultList();
    }

    protected final static String getEntityName(Class type) {
        Entity entity = (Entity) type.getAnnotation(Entity.class);
        if (entity == null || entity.name() == null || entity.name().length() == 0) {
            return type.getSimpleName();
        } else {
            return entity.name();
        }
    }
    
}