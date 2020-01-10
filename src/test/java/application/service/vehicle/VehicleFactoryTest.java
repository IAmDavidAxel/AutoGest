package application.service.vehicle;

import api.resource.dto.vehicle.VehicleDto;
import domain.vehicle.Vehicle;
import domain.vehicle.VehicleType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleFactoryTest {

	private static final String A_PLATE_NUMBER = "89 DU 7895";
	private static final String A_MODEL = "Mercedes";
	private static final VehicleType A_TYPE = VehicleType.CAR;
	private static final String A_COLOR = "blue";

	private VehicleFactory vehicleFactory;
	private Vehicle vehicle;
	private VehicleDto vehicleDto;

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

}
