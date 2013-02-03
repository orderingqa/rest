package com.thu.api.resource;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.sun.jersey.api.spring.Autowire;
import com.sun.jersey.spi.resource.Singleton;
import com.thu.api.domain.BusinessAddress;
import com.thu.api.domain.IndividualCustomer;
import com.thu.api.mock.MockISPServerObject;
import com.thu.api.result.FullSyncForISP;
import com.thu.api.result.ICISPUpdate;
import com.thu.api.result.ISPServerObject;
import com.thu.api.result.SimpleISPUpdate;

/**
 * 
 * @author liushuai
 */
@Singleton
@Path("/test")
@Component
@Autowire
public class ServerSideUpdate {

	protected final Logger logger = Logger.getLogger(getClass());
	
	@Context
    private UriInfo uriInfo;
	@Path("/downloadISPUpdate")
    @GET @Produces({"application/json" })
    public String downloadIspUpdateGet() {
    	return getJsonReturnFromFile("methodNotSupport.json");
    }
	
	@Path("/downloadISPUpdate")
	@POST @Consumes({MediaType.APPLICATION_JSON}) @Produces({"application/json" })
    public String downloadIspUpdatePostMock(ICISPUpdate icISPUpdate) {
		String token = uriInfo.getQueryParameters().getFirst("token");
		if ((token == null) || (token.length() == 0)) {
	        		getJsonReturnFromFile("invalidToken.json");
		}
		logger.debug("token: " + token);
		logger.debug("icId: " + icISPUpdate.getIcId());
		
		List<SimpleISPUpdate> ispUpdateList = icISPUpdate.getIspList();
		if (ispUpdateList != null) {
		    for (int i=0; i<ispUpdateList.size(); i++) { 
			    logger.debug("ispId:"+ispUpdateList.get(i).getIspId());
			    logger.debug("basic checksum:"+ispUpdateList.get(i).getBasic());
		    }
		} else {
			logger.debug("no isp list transferred from json");
		}
        return getJsonReturnFromFile("ispUpdate.json");
    }
	
	
	@Path("/downloadISPUpdateReal")
	@POST @Consumes({MediaType.APPLICATION_JSON}) @Produces({"application/json" })
    public FullSyncForISP downloadIspUpdatePost(ICISPUpdate icISPUpdate) {
		FullSyncForISP fsfi = new FullSyncForISP();
		String token = uriInfo.getQueryParameters().getFirst("token");
		if ((token == null) || (token.length() == 0)) {
			fsfi.setMsg("invalid token");
			fsfi.setMsgCode(1L);
			return fsfi;
//	        		getJsonReturnFromFile("invalidToken.json");
		}
		logger.debug("token: " + token);
//		logger.debug("icId: " + icISPUpdate.getIcId());
		
		List<SimpleISPUpdate> ispUpdateList = icISPUpdate.getIspList();
		// TODO design proper database based on mockup 1.29
	    // TODO do correct mapping for isps, write daos and test for persistent

		// TODO serverISPList = getISPById()
		// TODO commonISPList = findCommonIdFromTwoList(inputISPList.ids, serverISPList.ids)
		// TODO updatedISPList = getUpdateForISPs(commonISPList) checksum logic for java, prepare the output data, send json to client
		// TODO newISPList = serverISPList - commonISPList , prepare the output data, send json
		// TODO deleteISPList = inputISPList - commonISPList, prepare the output delete list, send json
        
        fsfi.setIcId(icISPUpdate.getIcId());
        fsfi.setMsg("");
        fsfi.setMsgCode(0L);
        fsfi.setVersion(0.2);
        List<ISPServerObject> newISPList = new ArrayList<ISPServerObject>();
        List<ISPServerObject> updateISPList = new ArrayList<ISPServerObject>();
        List<Long> deleteList = new ArrayList<Long>();
        fsfi.setAdd(newISPList);
        fsfi.setUpdate(updateISPList);
        fsfi.setDelete(deleteList);
        
		if (ispUpdateList != null) {
		    for (int i=0; i<ispUpdateList.size(); i++) {
		    	// TODO write a toString method for SimpleISPUpdate
//			    logger.debug("ispId:"+ispUpdateList.get(i).getIspId());
//			    logger.debug("basic checksum:"+ispUpdateList.get(i).getBasic());
		    	ISPServerObject iso = MockISPServerObject.getServerSideISP();
			    iso.setIspId(ispUpdateList.get(i).getIspId());
		    	newISPList.add(iso);
			    // TODO
			    // write checksum logic for java, and send to zhikai for same use
			    // write the output data format class
			    // call entity/dao class to generate the output data
		    }
		} else {
			logger.debug("no isp list transferred from json");
		}
		deleteList.add(1L);
		deleteList.add(2L);
		return fsfi;
//        return getJsonReturnFromFile("ispUpdate.json");
    }
	
	
	@Path("/downloadReviewUpdate")
	@GET @Produces({"application/json" })
    public String downloadReviewUpdateGet() {
    	if (logger.isDebugEnabled()) {
    	    logger.debug("ls test: " + uriInfo.getQueryParameters().getFirst("ic"));
        }
        return "{review:get}";
    }
	
	
	@Path("/ic_isps")
	@GET @Produces({"application/json" })
    public String saveISPGet() {
        return ISPSave();
    }
	
	@Path("/ic_isps")
	@POST @Consumes({MediaType.APPLICATION_JSON}) @Produces({"application/json" })
    public String ISPSave() {
        return getJsonReturnFromFile("success.json");
    }
	
	
	
	@Path("/isps/input")
	@GET @Produces({"application/json" })
    public String createISPGet() {
        return getJsonReturnFromFile("addISPInput.json");
    }
	
	
	@Path("/isps")
	@POST @Consumes({MediaType.APPLICATION_JSON}) @Produces({"application/json" })
    public String createISP() {
    	return getJsonReturnFromFile("newisp.json");
    }
	
	
//	@Path("/downloadISPUpdate/input")
//	@GET @Produces({"application/json" })
//    public String downloadISPUpdateInput() {
//        return getJsonReturnFromFile("ispUpdateInput.json");
//    }
	
	
	@Path("/isp/review/photos")
	@GET @Produces({"application/json" })
    public String photosOfReview() {
        return getJsonReturnFromFile("photosOfReview.json");
    }
	
	private String getJsonReturnFromFile(String fileName) {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
    	StringBuffer sb = new StringBuffer();
    	 try {
			BufferedReader in
			   = new BufferedReader(new InputStreamReader(is));
			String line = in.readLine(); 
			while (line != null) {
				sb.append(line);
				line = in.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return sb.toString();
	}

	
	
	
}
