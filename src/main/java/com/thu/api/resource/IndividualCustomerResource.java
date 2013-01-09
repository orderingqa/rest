
package com.thu.api.resource;

import com.sun.jersey.api.spring.Autowire;
import com.sun.jersey.spi.resource.Singleton;
import com.thu.api.domain.IndividualCustomer;
import com.thu.api.domain.service.IndividualCustomerService;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.springframework.stereotype.Component;

/**
 *
 * @author liushuai
 */
@Singleton
@Path("/ic")
@Component
@Autowire
public class IndividualCustomerResource {

    @Context
    private UriInfo uriInfo;
    private IndividualCustomerService individualCustomerService;

//    @POST @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public Response create(IndividualCustomer individualCustomer) {
//        Response response = null;
//        individualCustomerService.create(individualCustomer);
//        URI billUri = uriInfo.getAbsolutePathBuilder().
//                path(String.valueOf(individualCustomer.getId())).
//                build();
//        response = Response.created(billUri).build();
//        return response;
//    }
    
    @POST @Consumes({MediaType.APPLICATION_JSON}) @Produces({"application/json" })
    public IndividualCustomer create(IndividualCustomer individualCustomer) {
    	IndividualCustomer ic = individualCustomerService.getIndividualCustomerByFacebookId(individualCustomer.getFacebookId());
    	if (ic == null) {
        	individualCustomerService.create(individualCustomer);
        	ic = individualCustomer;
        }
        return individualCustomerService.load(ic.getId());
    }
    
    @GET @Produces({ "application/json" })
    @Path("/{id}")
    public IndividualCustomer get(@PathParam("id") Long id) {
        return individualCustomerService.load(id);
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, IndividualCustomer individualCustomer) {
        Response response = null;
        individualCustomerService.update(individualCustomer);
        response = Response.noContent().build();
        return response;
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        individualCustomerService.delete(id);
    }

    public void setUserService(IndividualCustomerService individualCustomerService) {
        this.individualCustomerService = individualCustomerService;
    }

}
