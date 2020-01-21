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
public class VehicleAssemblerTest {

	private static final String A_PLATE_NUMBER = "89DU7895";
	private static final String A_MODEL = "Mercedes";
	private static final VehicleType A_TYPE = VehicleType.CAR;
	private static final String A_COLOR = "blue";

	private VehicleAssembler vehicleAssembler;
	private VehicleDto vehicleDto;
	private Vehicle vehicle;
	private VehicleId vehicleId;

	private void setUpDto(){
		vehicleDto = new VehicleDto();

		vehicleId = new VehicleId(A_PLATE_NUMBER);

		vehicleDto.setId(vehicleId.getId());
		vehicleDto.setType(A_TYPE.toString());
		vehicleDto.setModel(A_MODEL);
		vehicleDto.setPlateNumber(A_PLATE_NUMBER);
		vehicleDto.setColor(A_COLOR);
	}

	@Before
	public void setUp() throws Exception {
		setUpDto();
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

	@Test
	public void whenAssemblingFromBDToUI_thenAllAttributesAreEquals(){

		Vehicle vehicle = vehicleAssembler.assemble(vehicleDto);

		String plateNumber = vehicle.getPlateNumber();
		String model = vehicle.getModel();
		VehicleType type = vehicle.getVehicleType();
		String id = vehicle.getIdValue();
		String color = vehicle.getColor();

		assertEquals(A_PLATE_NUMBER,plateNumber);
		assertEquals(A_MODEL,model);
		assertEquals(type,A_TYPE);
		assertEquals(id,vehicleDto.getId());
		assertEquals(color,A_COLOR);

	}
}
