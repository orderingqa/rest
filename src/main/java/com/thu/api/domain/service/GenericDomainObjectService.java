
package com.thu.api.domain.service;

import com.thu.api.domain.DomainObject;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author liushuai
 */

/**
 *
 * @author liushuai
 */
public interface GenericDomainObjectService<DO extends DomainObject<ID>, ID extends Serializable> {

    /**
     * Loads the <code>DomainObject</code> by id
     * 
     * @param id The <code>id</code>
     * @return The <code>DomainObject</code>
     * @throws EntityNotFoundException If the <code>DomainObject</code> is not found
     */
    DO load(ID id) throws EntityNotFoundException;
    
    /**
     * Finds a <code>DomainObject</code> by its id
     * 
     * @param id The <code>id</code>
     * @return The <code>DomainObject</code> instance or null if not found
     */
    DO findById(ID id);
    
    /**
     * Finds all <code>DomainObject</code>s
     * 
     * @return The <code>List</code> of <code>DomainObject</code> instances
     */
    List<DO> findAll();
    
    /**
     * Finds all <code>DomainObject</code> and uses pagination info to limit result size
     * 
     * @param firstResult The <code>firstResult</code>
     * @param maxResults The <code>maxResults</code>
     * @return A <code>List</code> of <code>DomainObject</code>s
     */
    List<DO> findAll(int firstResult, int maxResults);
    
    /**
     * Creates a new <code>DomainObject</code>
     * 
     * @param persistable The <code>DomainObject</code>
     */
    void create(DO persistable);
    
    /**
     * Creates multiple <code>DomainObject</code>s
     * 
     * @param domainObjects A <code>List</code> of <code>DomainObject</code>s
     */
    void create(Collection<DO> domainObjects);
    
    /**
     * Updates a <code>DomainObject</code>
     * 
     * @param domainObject The <code>DomainObject</code>
     * @throws EntityNotFoundException If the entity is not found
     */
    void update(DO domainObject) throws EntityNotFoundException;
    
    /**
     * Deletes a <code>DomainObject</code>
     * 
     * @param domainObject The <code>DomainObject</code>
     * @throws EntityNotFoundException If the entity is not found
     */
    void delete(DO domainObject) throws EntityNotFoundException;
    
    /**
     * Deletes an <code>DomainObject</code> by its <code>id</code>
     * 
     * @param id The <code>id</code>
     * @throws EntityNotFoundException If the entity is not found
     */
    void delete(ID id) throws EntityNotFoundException;
    
    /**
     * Deletes all <code>DomainObject</code> of this type
     */
    void deleteAll();
    
}