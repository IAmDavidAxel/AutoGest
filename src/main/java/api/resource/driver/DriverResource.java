package api.resource.driver;


import api.resource.dto.driver.DriverDto;
import application.service.exception.ServiceException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("driver")
public interface DriverResource {

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	Response createDriver(DriverDto driverDto)  throws ServiceException;


	@Path("/{name}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	Response findDriverByName(@PathParam("name") String name) throws ServiceException;

	@Path("/associateDriverToVehicle")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	Response associateDriverToVehicle(DriverDto driverDto) throws ServiceException;
}
