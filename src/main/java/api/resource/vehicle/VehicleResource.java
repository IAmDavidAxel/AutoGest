package api.resource.vehicle;

import api.resource.dto.vehicle.VehicleDto;
import application.service.exception.ServiceException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("vehicle")
public interface VehicleResource {


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	Response create(VehicleDto vehicleDto) throws ServiceException;

	@Path("/{plate_number}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	Response findVehicleByPlateNumber(@PathParam("plate_number") String aPlateNumber) throws ServiceException;

//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)

}
