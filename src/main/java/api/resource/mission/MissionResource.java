package api.resource.mission;

import api.resource.dto.MissionDto;
import application.service.exception.ServiceException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("mission")
public interface MissionResource {


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	Response createMission(MissionDto missionDto)  throws ServiceException;
}
