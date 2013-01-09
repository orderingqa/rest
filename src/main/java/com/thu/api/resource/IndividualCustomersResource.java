
package com.thu.api.resource;

import com.sun.jersey.api.spring.Autowire;
import com.sun.jersey.spi.resource.Singleton;
import com.thu.api.domain.IndividualCustomer;
import com.thu.api.domain.service.IndividualCustomerService;
import com.thu.api.management.Monitored;

import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

/**
 *
 * @author liushuai
 */
@Singleton
@Path("/ics")
@Component
@Autowire
public class IndividualCustomersResource {
    
    private IndividualCustomerService individualCustomerService;
    
    @GET @Produces({"application/json" })
    @Monitored("Users Read All")
    public List<IndividualCustomer> readAll() {
        return individualCustomerService.findAll();
    }
    
    @DELETE
    public void deleteAll() {
        individualCustomerService.deleteAll();
    }

    public void setUserService(IndividualCustomerService individualCustomerService) {
        this.individualCustomerService = individualCustomerService;
    }

}
