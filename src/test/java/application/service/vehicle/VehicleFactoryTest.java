package application.service.vehicle;

import api.resource.dto.vehicle.VehicleDto;
import domain.vehicle.Vehicle;
import domain.vehicle.VehicleId;
import domain.vehicle.VehicleType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleFactoryTest {

	private static final String A_PLATE_NUMBER = "89 DU 7895";
	private static final String A_MODEL = "Mercedes";
	private static final VehicleType A_TYPE = VehicleType.CAR;
	private static final String A_COLOR = "blue";
	private static final String AN_ID = "78975-opo";

	private VehicleFactory vehicleFactory;
	private Vehicle vehicle;
	private VehicleDto vehicleDto;
	private VehicleId vehicleId;

	private void setUpDto(){
		vehicleDto = new VehicleDto();

		vehicleDto.setPlateNumber(A_PLATE_NUMBER);
		vehicleDto.setModel(A_MODEL);
		vehicleDto.setType(A_TYPE);
		vehicleDto.setColor(A_COLOR);
	}

	@Before
	public void setUp(){
		setUpDto();
		vehicleId = new VehicleId(AN_ID);
		vehicle = new Vehicle(vehicleId,A_PLATE_NUMBER,A_MODEL,A_COLOR,A_TYPE);
		vehicleFactory = new VehicleFactory();
	}

	@Test
	public void whenAssemblingDTOToDomainObjects_thenAllAttributesAreEquals(){

		Vehicle vehicleFromAssembler = vehicleFactory.assemble(vehicleDto);

		String plateNumber = vehicleFromAssembler.getPlateNumber();
		String model = vehicleFromAssembler.getModel();
		String color = vehicleFromAssembler.getColor();
		VehicleType vehicleType = vehicleFromAssembler.getVehicleType();

		assertEquals(plateNumber,vehicleDto.getPlateNumber());
		assertEquals(model,A_MODEL);
		assertEquals(A_TYPE,vehicleType);
		assertEquals(color,A_COLOR);
	}

	@Test
	public void whenAssemblingToDto_thenAllAttributesAreEquals(){

		VehicleDto dtoFromAssembler = vehicleFactory.assemble(vehicle);

		String plateNumber = dtoFromAssembler.getPlateNumber();
		String model = dtoFromAssembler.getModel();
		String color = dtoFromAssembler.getColor();
		VehicleType vehicleType = dtoFromAssembler.getType();

		assertEquals(plateNumber,A_PLATE_NUMBER);
		assertEquals(model,A_MODEL);
		assertEquals(color,A_COLOR);
		assertEquals(vehicleType,A_TYPE);
	}

}
