
package com.thu.api.domain.service;

import com.thu.api.dao.IndividualCustomerDao;
import com.thu.api.domain.IndividualCustomer;

/**
 *
 * @author liushuai
 */
public class IndividualCustomerServiceImpl 
        extends GenericDomainObjectServiceImpl<IndividualCustomerDao, IndividualCustomer, Long> 
        implements IndividualCustomerService {

	public IndividualCustomer getIndividualCustomerByFacebookId(Long facebookId) {
		return dao.findByFacebookId(facebookId);
	}    
}