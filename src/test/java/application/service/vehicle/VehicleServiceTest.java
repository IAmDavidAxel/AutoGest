package application.service.vehicle;

import domain.vehicle.Vehicle;
import domain.vehicle.VehicleRepository;
import infrastruture.persistence.dto.vehicle.VehicleDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class VehicleServiceTest {

	private static final String A_PLATE_NUMBER = "78 Du 79845";
	private VehicleService vehicleService;

	@Mock
	private VehicleRepository vehicleRepository;
	@Mock
	private VehicleFactory vehicleFactory;
	private VehicleDto vehicleDto;
	private Vehicle vehicle;


	@Before
	public void setUp() throws Exception {

		vehicleService = new VehicleService(vehicleFactory,vehicleRepository);
	}

	@Test
	public void whenFindingAVehicle_thenDelegateActualSearchToTheRepo()throws Exception{

		vehicleService.find(A_PLATE_NUMBER);

		verify(vehicleRepository).find(A_PLATE_NUMBER);
	}

	@Test
	public void whenFindingAVehicle_thenFatoryTransformToDtoForApi()throws Exception{
		willReturn(vehicle).given(vehicleRepository).find(A_PLATE_NUMBER);

		vehicleService.find(A_PLATE_NUMBER);

		verify(vehicleFactory).assemble(vehicle);

	}
}
