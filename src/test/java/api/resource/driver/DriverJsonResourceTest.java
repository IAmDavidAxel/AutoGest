package api.resource.driver;

import api.resource.dto.driver.DriverDto;
import application.service.user.driver.DriverService;
import application.service.user.manager.ManagerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DriverJsonResourceTest {

	private static final String A_NAME = "karim";

	private DriverJsonResource driverJsonResource;
	private DriverDto driverDto;


	@Mock
	private ManagerService managerService;
	@Mock
	private DriverService driverService;

	@Before
	public void setUp(){
		driverJsonResource = new DriverJsonResource(managerService,driverService);
	}

	@Test
	public void whenCreatingANewDriver_thenDelegateToManagerService()throws Exception{

		driverJsonResource.createDriver(driverDto);

		verify(managerService).createDriver(driverDto);
	}

	@Test
	public void whenFindingADriver_thenDelegateToDriverService()throws Exception{
		driverJsonResource.findDriverByName(A_NAME);

		verify(driverService).findDriverByName(A_NAME);
	}

	@Test
	public void whenAssociatingADriverToVehicle_thenDelegateToService()throws Exception{
		driverJsonResource.associateDriverToVehicle(driverDto);

		verify(managerService).associateDriverToVehicle(driverDto);
	}
}
