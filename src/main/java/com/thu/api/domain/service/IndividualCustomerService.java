/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.thu.api.domain.service;

import com.thu.api.domain.IndividualCustomer;

/**
 *
 * @author liushuai
 */
public interface IndividualCustomerService extends GenericDomainObjectService<IndividualCustomer, Long> {
	IndividualCustomer getIndividualCustomerByFacebookId(Long facebookId);
}
