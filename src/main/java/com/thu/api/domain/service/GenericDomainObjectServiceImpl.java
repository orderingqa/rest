
package com.thu.api.domain.service;

import com.thu.api.dao.GenericDao;
import com.thu.api.domain.DomainObject;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class GenericDomainObjectServiceImpl<DAO extends GenericDao<DO,ID>, DO extends DomainObject<ID>, ID extends Serializable> 
        implements GenericDomainObjectService<DO, ID> {

    protected final Logger logger = Logger.getLogger(getClass());

    protected DAO dao;
    
    /** {@inheritDoc} */
    public DO load(ID id) throws EntityNotFoundException {
        return dao.load(id);
    }
    
    /** {@inheritDoc} */
    public DO findById(ID id) {
        return dao.findById(id);
    }

    /** {@inheritDoc} */
    public List<DO> findAll() {
        return dao.findAll();
    }

    /** {@inheritDoc} */
    public List<DO> findAll(int firstResult, int maxResults) {
        return dao.findAll(firstResult, maxResults);
    }

    /** {@inheritDoc} */
    @Transactional(readOnly = false)
    public void create(DO domainObject) {
        dao.create(domainObject);
    }
    
    /** {@inheritDoc} */
    @Transactional(readOnly = false)
    public void create(Collection<DO> domainObjects) {
        for (DO domainObject : domainObjects) {
            dao.create(domainObject);
        }
    }

    /** {@inheritDoc} */
    @Transactional(readOnly = false)
    public void update(DO domainObjects) throws EntityNotFoundException {
        dao.update(domainObjects);
    }

    /** {@inheritDoc} */
    @Transactional(readOnly = false)
    public void delete(DO domainObject) throws EntityNotFoundException {
        dao.delete(domainObject);
    }

    /** {@inheritDoc} */
    @Transactional(readOnly = false)
    public void delete(ID id) throws EntityNotFoundException {
        dao.delete(id);
    }

    /** {@inheritDoc} */
    @Transactional(readOnly = false)
    public void deleteAll() {
        dao.deleteAll();
    }
    
    /**
     * Sets the dao
     * 
     * @param dao The <code>dao</code>
     */
    @Required
    public void setDao(DAO dao) {
        this.dao = dao;
    }

}