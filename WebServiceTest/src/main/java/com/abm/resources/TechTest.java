package com.abm.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.abm.exceptions.InvalidCommandException;
import com.abm.exceptions.InvalidSiteIdException;
import com.abm.model.ResponseModel;

@Path("/readxml")
public class TechTest {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response readXml() throws InvalidCommandException, InvalidSiteIdException {
		XmlParserUtils xmlParserUtils = new XmlParserUtils();
		// Check if 'Command' attribute is equal to 'DEFAULT'
		if(!xmlParserUtils.isCommandDefault()) {
			throw new InvalidCommandException();
		}
		// Check if 'SiteID' element is equal to 'DUB'
		else if (!xmlParserUtils.isSiteIdDub()) {
			throw new InvalidSiteIdException();
		}
		
		ResponseModel message = new ResponseModel(0, "Document Structured Correctly");
		
		return Response.status(Status.OK).entity(message).build();
	}

}
