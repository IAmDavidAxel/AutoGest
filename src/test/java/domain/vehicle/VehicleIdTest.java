package domain.vehicle;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleIdTest {

	private static final String A_PLATE_NUMBER = "89 du mlop";
	private static final String ANOTHER_PLATE_NUMBER = "789 pop 78";

	private VehicleId vehicleId;


	@Before
	public void setUp(){
		vehicleId = new VehicleId(A_PLATE_NUMBER);
	}

	@Test
	public void whenInitializedTheIdIsNotNull()throws Exception{
		String plateNumber = vehicleId.getId();

		assertNotNull(plateNumber);

		System.out.println(plateNumber);
	}

	@Test
	public void givenAPlateNumber_whenHashingTwice_thenTheProducedHashAreEquals()throws Exception{

		String firstHash = vehicleId.getId();
		String secondHash = vehicleId.generateFromString(A_PLATE_NUMBER);

		assertEquals(firstHash, secondHash);
		System.out.println(firstHash+"  et  "+secondHash);
	}

	@Test
	public void givenTwoPlateNumber_whenHashing_thenTheyShouldBeDifferent() {

		String firstHash = vehicleId.generateFromString(A_PLATE_NUMBER);

		String secondHash = vehicleId.generateFromString(ANOTHER_PLATE_NUMBER);


		assertNotEquals(firstHash, secondHash);
		System.out.println(firstHash+"  et  "+ secondHash);
	}

}
