
package com.thu.api.dao;

import com.thu.api.domain.IndividualCustomer;

/**
 *
 * @author liushuai
 */
public interface IndividualCustomerDao extends GenericDao<IndividualCustomer, Long>{
	public IndividualCustomer findByFacebookId(Long facebookId);
}
