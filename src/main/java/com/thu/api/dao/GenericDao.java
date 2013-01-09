package com.thu.api.dao;

import com.thu.api.domain.DomainObject;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author liushuai
 */
public interface GenericDao<DO extends DomainObject, ID extends Serializable> {

    /**
     * Finds a <code>DomainObject</code> by its <code>id</code>
     * 
     * @param id The <code>id</code> of the <code>DomainObject</code>
     * @return The <code>DomainObject</code> or null if not found
     */
    DO findById(ID id);
    
    /**
     * Loads an <code>DomainObject</code> by its id
     * 
     * @param id The id
     * @return The <code>DomainObject</code>
     */
    DO load(ID id) throws EntityNotFoundException;

    /**
     * Finds all <code>DomainObject</code> instances of this type
     * 
     * @return A list of persistables
     */
    List<DO> findAll();
    
    /**
     * Finds all <code>DomainObject</code> instances of this type
     * 
     * @param firstResult The <code>firstResult</code>
     * @param maxResults The <code>maxResults</code>
     * @return A list of <code>DomainObject</code> instances
     */
    List<DO> findAll(int firstResult, int maxResults);

    /**
     * Creates a new <code>DomainObject</code>
     * 
     * @param domainObject The <code>DomainObject</code>
     * @return The <code>DomainObject</code>
     */
    DO create(DO domainObject);

    /**
     * Updates a <code>DomainObject</code>
     * 
     * @param domainObject The <code>DomainObject</code>
     * @return The <code>DomainObject</code>
     */
    DO update(DO domainObject) throws EntityNotFoundException;

    /**
     * Deletes the <code>DomainObject</code> associated with the <code>id</code>
     * 
     * @param id The <code>id</code>
     */
    void delete(ID id) throws EntityNotFoundException;

    /**
     * Delete the <code>DomainObject</code> passed
     * 
     * @param domainObject The <code>DomainObject</code>
     */
    void delete(DO domainObject) throws EntityNotFoundException;
    
    /**
     * Deletes all of the <code>DomainObject</code> instances
     */
    void deleteAll();
    
}