package com.thu.api.resource;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.stereotype.Component;

import com.sun.jersey.api.spring.Autowire;
import com.sun.jersey.spi.resource.Singleton;
import com.thu.api.domain.IndividualServiceProvider;
import com.thu.api.domain.service.IndividualServiceProviderService;

/**
 * 
 * @author liushuai
 */
@Singleton
@Path("/isp")
@Component
@Autowire
public class IndividualServiceProviderResource {
	@Context
	private UriInfo uriInfo;
	private IndividualServiceProviderService individualServiceProviderService;

	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response create(IndividualServiceProvider individualServiceProvider) {
		Response response = null;
		individualServiceProviderService.create(individualServiceProvider);
		URI billUri = uriInfo.getAbsolutePathBuilder()
				.path(String.valueOf(individualServiceProvider.getId()))
				.build();
		response = Response.created(billUri).build();
		return response;
	}

	@GET
	@Produces({ "application/json" })
	@Path("/{id}")
	public IndividualServiceProvider get(@PathParam("id") Long id) {
		return individualServiceProviderService.load(id);
	}

	public void setIndividualServiceProviderService(
			IndividualServiceProviderService individualServiceProviderService) {
		this.individualServiceProviderService = individualServiceProviderService;
	}

}
