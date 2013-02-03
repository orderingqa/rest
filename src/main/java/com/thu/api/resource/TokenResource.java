package com.thu.api.resource;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sun.jersey.api.spring.Autowire;
import com.sun.jersey.spi.resource.Singleton;
import com.thu.api.domain.Token;


/**
 * 
 * @author liushuai
 */
@Singleton
@Path("/token")
@Component
@Autowire
public class TokenResource {
	@PersistenceContext
    protected EntityManager em;
	
	// adding transactional to ensure we can save to db. Else, all the saving will not impact real db.
	@GET
	@Produces({ "application/json" })
	@Path("/{id}")
	@Transactional(readOnly = false)
	public Token get(@PathParam("id") Long facebookId) {
		Token thuToken = em.find(Token.class, facebookId);
		if (thuToken != null) {
			// validate the expireTime, if not expire
			return thuToken;
			// if expire, goto else branch
		} else {
			Token token = new Token();
			token.setToken(UUID.randomUUID().toString());
			token.setFacebookId(facebookId); // facebook Id should be valid
			em.persist(token);
			return token;
		}
	}
}
