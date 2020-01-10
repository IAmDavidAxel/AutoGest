package infrastruture.persistence.assembler.vehicle;

import domain.vehicle.Vehicle;
import domain.vehicle.VehicleId;
import domain.vehicle.VehicleType;
import infrastruture.persistence.dto.vehicle.VehicleDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class VehicleFactoryTest {

	private static final String A_PLATE_NUMBER = "89 DU 7895";
	private static final String A_MODEL = "Mercedes";
	private static final VehicleType A_TYPE = VehicleType.CAR;
	private static final String A_COLOR = "blue";

	private VehicleAssembler vehicleAssembler;
	private VehicleDto vehicleDto;
	private Vehicle vehicle;
	private VehicleId vehicleId;

	@Before
	public void setUp() throws Exception {
		vehicleId = new VehicleId(A_PLATE_NUMBER);
		vehicle = new Vehicle(vehicleId,A_PLATE_NUMBER,A_MODEL,A_COLOR,A_TYPE);
		vehicleAssembler = new VehicleAssembler();
	}

	@Test
	public void whenAssemblingForBD_thenAttributesAreEquals(){
		VehicleDto vehicleDto = vehicleAssembler.assemble(vehicle);

		String idFromVehicle = vehicle.getIdValue();

		String plateNumber = vehicleDto.getPlateNumber();
		String model = vehicleDto.getModel();
		String color = vehicleDto.getColor();
		String type = vehicleDto.getType();
		String id = vehicleDto.getId();


		assertEquals(A_PLATE_NUMBER,plateNumber);
		assertEquals(A_MODEL,model);
		assertEquals(A_TYPE.toString(),type);
		assertEquals(A_COLOR,color);
		assertEquals(idFromVehicle,id);


	}
}
