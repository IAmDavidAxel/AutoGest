package domain.user.driver;

import application.service.user.driver.UserId;
import domain.vehicle.Vehicle;
import domain.vehicle.VehicleId;
import domain.vehicle.VehicleType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DriverTest {

	private static final String A_FIRST_NAME = "karim";
	private static final String A_LAST_NAME = "Benzema";
	private static final String AN_ID_NUMBER = "B789456";
	private static final String A_DRIVER_LICENCE = "7895465";
	private static final String A_CELL_PHONE_NUMBER = "78984512";
	private static final String A_BIRTH_DATE = "30/11/1899";

	private static final String A_PLATE_NUMBER = "89 DU 7895";
	private static final String A_MODEL = "Mercedes";
	private static final VehicleType A_TYPE = VehicleType.CAR;
	private static final String A_COLOR = "blue";
	private static final String AN_ID = "78975-opo";

	private Driver driver;
	private UserId userId;
	private Vehicle vehicle;
	private VehicleId vehicleId;


	@Before
	public void setUp(){
		vehicleId = new VehicleId(A_PLATE_NUMBER);
		userId = new UserId();
		vehicle = new Vehicle(vehicleId,A_PLATE_NUMBER,A_MODEL,A_COLOR,A_TYPE);
		driver = new Driver(userId,A_FIRST_NAME,A_LAST_NAME,AN_ID_NUMBER,A_DRIVER_LICENCE,A_CELL_PHONE_NUMBER,A_BIRTH_DATE);



	}

	@Test
	public void whenInitialized_thenHasNoVehicleAssigned()throws Exception{

		Vehicle vehicle = driver.getVehicle();

		assertNull(vehicle);
	}

	@Test
	public void whenAssigned_thenVehiclePropertyIsNotNull()throws Exception{

		driver.assignVehicle(vehicle);

		Vehicle vehicle = driver.getVehicle();

		assertNotNull(vehicle);
	}

	@Test(expected = VehicleAlreadyAssignedException.class)
	public void whenAssigningAndThereIsAlreadyAssigned_thenThrowException()throws Exception{
		driver.assignVehicle(vehicle);

		driver.assignVehicle(vehicle);
	}

	@Test
	public void whenAssigningAVehicleIfAlreadyAssigned_thenReturnTrue() throws Exception{

		driver.assignVehicle(vehicle);

		boolean isAssigned = driver.isAssignedToVehicle();

		assertTrue(isAssigned);
	}

	@Test
	public void whenAssigningAVehicleNotAssigned_thenReturnFalse()throws Exception{

		boolean isAssigned = driver.isAssignedToVehicle();

		assertFalse(isAssigned);
	}

}
