package application.service.mission;

import api.resource.dto.MissionDto;
import application.service.user.driver.UserId;
import domain.mission.Mission;
import domain.user.driver.Driver;
import domain.vehicle.Vehicle;
import domain.vehicle.VehicleId;
import domain.vehicle.VehicleType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MissionFactoryTest {

	private static final String AN_ORDER_NUMBER = "2019-0001";
	private static final String A_LOCATION = "Gaoua";
	private static final String A_PLATE_NUMBER = "89 pzopoz 78";
	private static final String  A_START_DATE = "2020-11-05";
	private static final String AN_END_DATE = "2022-12-01";
	private static final String A_DRIVER_NAME = "Achille";
	private static final String A_COMPANION_NAME = "Moussa";
	private static final String A_DESCRIPTION = "mettre le feu";
	private static final String A_MEAN_OF_TRANSPORT = "car";


	private static final String A_LAST_NAME = "Benzema";
	private static final String AN_ID_NUMBER = "B789456";
	private static final String A_DRIVER_LICENCE = "7895465";
	private static final String A_CELL_PHONE_NUMBER = "78984512";
	private static final String A_BIRTH_DATE = "30/11/1899";


	private static final String A_MODEL = "Mercedes";
	private static final VehicleType A_TYPE = VehicleType.CAR;
	private static final String A_COLOR = "blue";
	private static final String AN_ID = "78975-opo";

	private MissionFactory missionFactory;
	private MissionDto missionDto;
	private Driver driver;
	private Vehicle vehicle;
	private UserId userId;
	private VehicleId vehicleId;

	private void setUpDto(){
		missionDto = new MissionDto();

		missionDto.setOrderNumber(AN_ORDER_NUMBER);
		missionDto.setLocation(A_LOCATION);
		missionDto.setVehiclePlateNumber(A_PLATE_NUMBER);
		missionDto.setMissionStartDate(A_START_DATE);
		missionDto.setMissionEndDate(AN_END_DATE);
		missionDto.setAssociatedDriverName(A_DRIVER_NAME);
		missionDto.setAccompanantDriverName(A_COMPANION_NAME);
		missionDto.setMissionDescription(A_DESCRIPTION);
		missionDto.setMeanOfTransport(A_MEAN_OF_TRANSPORT);
	}


	@Before
	public void setUp() throws Exception {
		setUpDto();
		driver = new Driver(userId,A_DRIVER_NAME,A_LAST_NAME,AN_ID_NUMBER,A_DRIVER_LICENCE,A_CELL_PHONE_NUMBER,A_BIRTH_DATE);
		vehicle = new Vehicle(vehicleId,A_PLATE_NUMBER,A_MODEL,A_COLOR,A_TYPE);
		missionFactory = new MissionFactory();
	}

	@Test
	public void whenCreatingANewMissionObject_thenAllAttributesAreEqual(){

		Mission mission = missionFactory.create(missionDto, driver, vehicle);

		String missionOrderNumber = mission.getMissionOrderNumber();
		String location = mission.getLocation();
		LocalDate missionStartDate = mission.getMissionStartDate();
		LocalDate missionEndDate = mission.getMissionEndDate();
		Driver  driverAssignedToMission = mission.getDriverAssigned();
		Vehicle vehicleAssignedToDriverForMission = mission.getVehicle();

		String driverName = driverAssignedToMission.getFirstName();
		String vehiclePlateNumber = vehicleAssignedToDriverForMission.getPlateNumber();

		assertEquals(missionOrderNumber,AN_ORDER_NUMBER);
		assertEquals(location,A_LOCATION);
		assertEquals(missionStartDate.toString(),A_START_DATE);
		assertEquals(missionEndDate.toString(),AN_END_DATE);
		assertEquals(driverName,A_DRIVER_NAME);
		assertEquals(vehiclePlateNumber,A_PLATE_NUMBER);
	}


}
