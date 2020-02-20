package com.abm.exception.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.abm.exceptions.InvalidSiteIdException;
import com.abm.model.ResponseModel;

@Provider
public class InvalidSiteIdExceptionMapper implements ExceptionMapper<InvalidSiteIdException> {

	/**
	 * Response when 'SiteID' element <> 'DUB'
	 */
	@Override
	public Response toResponse(InvalidSiteIdException exception) {
		ResponseModel errorMessage = new ResponseModel(-2, exception.getMessage());
		return Response.status(Status.OK).entity(errorMessage).build();
	}
	
}
