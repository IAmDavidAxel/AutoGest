package api.resource.vehicle;

import api.resource.ResponseDto;
import api.resource.ResponseDtoBuilder;
import api.resource.dto.vehicle.VehicleDto;
import application.service.exception.ServiceException;
import application.service.user.manager.ManagerService;
import utility.datamanager.MessageDataManager;

import javax.ws.rs.core.Response;

public class VehicleJsonResource implements VehicleResource{
	private ManagerService managerService;

	public VehicleJsonResource(ManagerService managerService) {

		this.managerService = managerService;
	}

	@Override
	public Response create(VehicleDto vehicleDto) throws ServiceException {

		managerService.create(vehicleDto);

		ResponseDto responseDto = ResponseDtoBuilder.builder()
				.withStatus(MessageDataManager.SUCCESS_RESPONSE)
				.withMessage(MessageDataManager.VEHICLE_CREATED).getResponseDto();

		return Response.status(Response.Status.CREATED).entity(responseDto).build();
	}
}
