package api.resource.mission;

import api.resource.ResponseDto;
import api.resource.ResponseDtoBuilder;
import api.resource.dto.MissionDto;
import application.service.exception.ServiceException;
import application.service.user.manager.ManagerService;
import utility.datamanager.MessageDataManager;

import javax.ws.rs.core.Response;

public class MissionJsonResource implements MissionResource{


	private ManagerService managerService;

	public MissionJsonResource(ManagerService managerService) {

		this.managerService = managerService;
	}

	@Override
	public Response createMission(MissionDto missionDto)  throws ServiceException {

		managerService.createMission(missionDto);

		ResponseDto responseDto = ResponseDtoBuilder.builder()
				.withStatus(MessageDataManager.SUCCESS_RESPONSE)
				.withMessage(MessageDataManager.MISSION_CREATED)
				.getResponseDto();

		return Response.status(Response.Status.CREATED).entity(responseDto).build();
	}
}
