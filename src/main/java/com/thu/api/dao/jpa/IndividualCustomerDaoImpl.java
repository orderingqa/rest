
package com.thu.api.dao.jpa;

import java.util.List;

import org.apache.log4j.Logger;

import com.thu.api.dao.IndividualCustomerDao;
import com.thu.api.domain.IndividualCustomer;

/**
 *
 * @author liushuai
 */
public class IndividualCustomerDaoImpl extends GenericDaoImpl<IndividualCustomer, Long> implements IndividualCustomerDao  {

	protected String findByFacebookIdQuery = null;
	
    /** {@inheritDoc} */
    public IndividualCustomer findByFacebookId(Long facebookId) {
        if (logger.isDebugEnabled()) {
            logger.debug("findById called for facebook id: " + facebookId);
        }
        findByFacebookIdQuery = "from " + getEntityName(type) + " where facebookId = " + facebookId; 
        List<IndividualCustomer> ics = (List<IndividualCustomer>) em.createQuery(findByFacebookIdQuery).getResultList();
        if (ics != null && ics.size() > 0) {
        	return ics.get(0);
        }
        return null;
    }
}