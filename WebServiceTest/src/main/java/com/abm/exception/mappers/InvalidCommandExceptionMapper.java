package com.abm.exception.mappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.abm.exceptions.InvalidCommandException;
import com.abm.model.ResponseModel;

@Provider
public class InvalidCommandExceptionMapper implements ExceptionMapper<InvalidCommandException> {

	/**
	 * Response when 'Command' attribute <> 'DEFAULT'
	 */
	@Override
	public Response toResponse(InvalidCommandException exception) {
		ResponseModel errorMessage = new ResponseModel(-1, exception.getMessage());
		return Response.status(Status.OK).entity(errorMessage).build();
	}
	
}
