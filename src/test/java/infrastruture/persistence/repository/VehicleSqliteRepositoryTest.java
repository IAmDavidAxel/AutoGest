package infrastruture.persistence.repository;

import domain.vehicle.Vehicle;
import domain.vehicle.VehicleId;
import domain.vehicle.VehicleType;
import infrastruture.persistence.assembler.vehicle.VehicleAssembler;
import infrastruture.persistence.dao.vehicle.VehicleDao;
import infrastruture.persistence.dto.vehicle.VehicleDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class VehicleSqliteRepositoryTest {

	private static final String A_PLATE_NUMBER = "89 DU 7895";
	private static final String A_MODEL = "Mercedes";
	private static final VehicleType A_TYPE = VehicleType.CAR;
	private static final String A_COLOR = "blue";

	private VehicleSqliteRepository vehicleSqliteRepository;

	@Mock
	private VehicleAssembler vehicleAssembler;
	@Mock
	private VehicleDao vehicleDao;
	private Vehicle vehicle;
	private VehicleDto vehicleDto;
	private VehicleId vehicleId;

	@Before
	public void setUp(){
		vehicleId = new VehicleId(A_PLATE_NUMBER);
		vehicle = new Vehicle(vehicleId,A_PLATE_NUMBER,A_MODEL,A_COLOR,A_TYPE);
		vehicleSqliteRepository = new VehicleSqliteRepository(vehicleAssembler,vehicleDao);
	}

	@Test
	public void whenSaving_thenDelegateTransformationToAssembler()throws Exception{
		vehicleSqliteRepository.save(vehicle);

		verify(vehicleAssembler).assemble(vehicle);
	}

	@Test
	public void whenSaving_thenDelegateToDAOForSavingInTheDatabase ()throws Exception{

		willReturn(vehicleDto).given(vehicleAssembler).assemble(vehicle);

		vehicleSqliteRepository.save(vehicle);

		verify(vehicleDao).save(vehicleDto);
	}
}
