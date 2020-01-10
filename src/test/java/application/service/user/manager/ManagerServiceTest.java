package application.service.user.manager;

import api.resource.dto.vehicle.VehicleDto;
import application.service.vehicle.VehicleFactory;
import domain.vehicle.Vehicle;
import domain.vehicle.VehicleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ManagerServiceTest {

	private ManagerService managerService;
	private VehicleDto vehicleDto;

	private Vehicle vehicle;

	@Mock
	private VehicleFactory vehicleFactory;
	@Mock
	private VehicleRepository vehicleRepository;

	@Before
	public void setUp(){
		vehicleDto = new VehicleDto();
		managerService = new ManagerService(vehicleFactory,vehicleRepository);
	}

	@Test
	public void whenCreatingANewVehicle_thenDelegateToAssembler()throws Exception{
		managerService.create(vehicleDto);

		verify(vehicleFactory).assemble(vehicleDto);
	}

	@Test
	public void whenCreatingANewVehicle_thenDedicateSavingToTheRepo()throws Exception{
		willReturn(vehicle).given(vehicleFactory).assemble(vehicleDto);

		managerService.create(vehicleDto);

		verify(vehicleRepository).save(vehicle);
	}

}
