package infrastruture.persistence.assembler.mission;

import application.service.user.driver.UserId;
import domain.mission.Mission;
import domain.mission.MissionId;
import domain.user.driver.Driver;
import domain.vehicle.Vehicle;
import domain.vehicle.VehicleId;
import domain.vehicle.VehicleType;
import infrastruture.persistence.dto.mission.MissionDto;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class MissionAssemblerTest {

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

	private MissionAssembler missionAssembler;
	private Mission mission;
	private MissionDto missionDto;
	private UserId userId;
	private VehicleId vehicleId;
	private MissionId missionId;
	private Driver driver;
	private Vehicle vehicle;
	private static final String driverCompanion = "albert";


	private void setUpDto(){

			missionDto = new MissionDto();

			missionDto.setOrderNumber(AN_ORDER_NUMBER);
			missionDto.setLocation(A_LOCATION);
			missionDto.setVehiclePlateNumber(A_PLATE_NUMBER);
			missionDto.setMissionStartDate(A_START_DATE);
			missionDto.setMissionEndDate(AN_END_DATE);
			missionDto.setAssociatedDriverName(A_DRIVER_NAME);
			missionDto.setDriverCompanion(A_COMPANION_NAME);
			missionDto.setMissionDescription(A_DESCRIPTION);
			missionDto.setMeanOfTransport(A_MEAN_OF_TRANSPORT);

	}

	@Before
	public void setUp() throws Exception {
		userId = new UserId();
		vehicleId = new VehicleId(A_PLATE_NUMBER);
		missionId = new MissionId();
		driver = new Driver(userId,A_DRIVER_NAME,A_LAST_NAME,AN_ID_NUMBER,A_DRIVER_LICENCE,A_CELL_PHONE_NUMBER,A_BIRTH_DATE);
		vehicle = new Vehicle(vehicleId,A_PLATE_NUMBER,A_MODEL,A_COLOR,A_TYPE);
		mission = new Mission(missionId,A_LOCATION,AN_ORDER_NUMBER, LocalDate.parse(A_START_DATE),LocalDate.parse(AN_END_DATE),driver,vehicle,A_DESCRIPTION,A_COMPANION_NAME, driverCompanion);
		setUpDto();
		missionAssembler = new MissionAssembler();

	}

	@Test
	public void givenAMission_whenAssemblingToDto_thenAllAttributesAreEquals(){

		MissionDto dtoFromAssembler = missionAssembler.assemble(mission);

		assertEquals(dtoFromAssembler.getAssociatedDriverName(),mission.getDriverAssigned().getFirstName());
	}


}
