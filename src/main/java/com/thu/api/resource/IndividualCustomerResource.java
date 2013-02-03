
package com.thu.api.resource;

import com.sun.jersey.api.spring.Autowire;
import com.sun.jersey.spi.resource.Singleton;
import com.thu.api.domain.IndividualCustomer;
import com.thu.api.domain.service.IndividualCustomerService;
import com.thu.api.utility.Authentication;

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

import org.apache.log4j.Logger;
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

	protected final Logger logger = Logger.getLogger(getClass());
	
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
    
    // create a new user by facebook id if not exists
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
    	// uriInfo is used for retrieving the parameters in the url query
    	String facebookId = uriInfo.getQueryParameters().getFirst("fb_id");
    	String ticket = uriInfo.getQueryParameters().getFirst("ticket");
    	// TODO the log4j configuration at log4j.properties like: log4j.logger.com.openmarket had issue
//    	if (logger.isDebugEnabled()) {
            logger.debug("facebookId: " + facebookId + " ticket: "+ticket);
//        }
    	Authentication auth = new Authentication();
    	// TODO this need a common module to ensure we handle at all the apis
    	if (facebookId!=null && ticket!=null && auth.isValidateTicket(ticket, new Long(facebookId))){
    		return individualCustomerService.load(id);
    	}
    	return null;
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
