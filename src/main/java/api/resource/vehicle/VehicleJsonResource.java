package api.resource.vehicle;

import api.resource.ResponseDto;
import api.resource.ResponseDtoBuilder;
import api.resource.dto.vehicle.VehicleDto;
import application.service.exception.ServiceException;
import application.service.user.manager.ManagerService;
import application.service.vehicle.VehicleService;
import utility.datamanager.MessageDataManager;

import javax.ws.rs.core.Response;

public class VehicleJsonResource implements VehicleResource{
	private ManagerService managerService;
	private VehicleService vehicleService;

	public VehicleJsonResource(ManagerService managerService, VehicleService vehicleService) {

		this.managerService = managerService;
		this.vehicleService = vehicleService;
	}

	@Override
	public Response create(VehicleDto vehicleDto) throws ServiceException {

		managerService.create(vehicleDto);

		ResponseDto responseDto = ResponseDtoBuilder.builder()
				.withStatus(MessageDataManager.SUCCESS_RESPONSE)
				.withMessage(MessageDataManager.VEHICLE_CREATED).getResponseDto();

		return Response.status(Response.Status.CREATED).entity(responseDto).build();
	}

	@Override
	public Response findVehicleByPlateNumber(String aPlateNumber) throws ServiceException {

		VehicleDto vehicleDto = vehicleService.find(aPlateNumber);

		ResponseDto responseDto = ResponseDtoBuilder.builder()
				.withStatus(MessageDataManager.SUCCESS_RESPONSE)
				.withPayload(vehicleDto)
				.withMessage(MessageDataManager.RETRIEVED_VEHICLE)
				.getResponseDto();

		return Response.status(Response.Status.OK).entity(responseDto).build();

	}
}
