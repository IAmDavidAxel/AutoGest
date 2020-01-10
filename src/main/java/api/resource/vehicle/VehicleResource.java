package api.resource.vehicle;

import api.resource.dto.vehicle.VehicleDto;
import application.service.exception.ServiceException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("vehicle")
public interface VehicleResource {


	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	Response create(VehicleDto vehicleDto) throws ServiceException;
}
