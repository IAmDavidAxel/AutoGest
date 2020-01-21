package api.resource.driver;

import api.resource.ResponseDto;
import api.resource.ResponseDtoBuilder;
import api.resource.dto.driver.DriverDto;
import application.service.exception.ServiceException;
import application.service.user.driver.DriverService;
import application.service.user.manager.ManagerService;
import utility.datamanager.MessageDataManager;

import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.List;

public class DriverJsonResource implements DriverResource{

	private ManagerService managerService;
	private DriverService driverService;

	public DriverJsonResource(ManagerService managerService, DriverService driverService) {
		this.managerService = managerService;
		this.driverService = driverService;
	}

	@Override
	public Response createDriver(DriverDto driverDto)  throws ServiceException {

		managerService.createDriver(driverDto);

		ResponseDto  responseDto = ResponseDtoBuilder.builder()
				.withStatus(MessageDataManager.SUCCESS_RESPONSE)
				.withMessage(MessageDataManager.DRIVER_CREATED)
				.getResponseDto();

		return Response.status(Response.Status.CREATED).entity(responseDto)
				.build();
	}



	@Override
	public Response findDriverByName(String name)  throws ServiceException{

		List<DriverDto> driverDtos = driverService.findDriverByName(name);

		ResponseDto responseDto = ResponseDtoBuilder.builder()
				.withStatus(MessageDataManager.SUCCESS_RESPONSE)
				.withPayload(driverDtos)
				.withMessage(MessageDataManager.SAVED_DRIVER)
				.getResponseDto();


		return  Response.status(Response.Status.OK).entity(new GenericEntity<List<DriverDto>>(driverDtos){}).build();
	}

	@Override
	public Response associateDriverToVehicle(DriverDto driverDto) throws ServiceException {

		managerService.associateDriverToVehicle(driverDto);
		return Response.status(Response.Status.ACCEPTED).build();
	}

}
