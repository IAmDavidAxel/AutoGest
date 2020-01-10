package api.resource;

import api.resource.dto.vehicle.VehicleDto;
import api.resource.vehicle.VehicleJsonResource;
import application.service.user.manager.ManagerService;
import application.service.vehicle.VehicleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class VehicleJsonResourceTest {

	private VehicleJsonResource vehicleJsonResource;
	private VehicleDto vehicleDto;

	@Mock
	private VehicleService vehicleService;
	@Mock
	private ManagerService managerService;

	@Before
	public void setUp(){
		vehicleJsonResource = new VehicleJsonResource(managerService);
	}

	@Test
	public void whenCreatingAVehicle_thenDelegateCreationToManagerService()throws Exception{

		vehicleJsonResource.create(vehicleDto);

		verify(managerService).create(vehicleDto);
	}
}
