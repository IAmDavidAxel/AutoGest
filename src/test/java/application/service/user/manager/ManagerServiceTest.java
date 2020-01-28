package application.service.user.manager;

import api.resource.dto.MissionDto;
import api.resource.dto.driver.DriverDto;
import api.resource.dto.vehicle.VehicleDto;
import application.service.mission.MissionFactory;
import application.service.user.driver.DriverFactory;
import application.service.user.driver.UserId;
import application.service.vehicle.VehicleFactory;
import domain.mission.Mission;
import domain.mission.MissionRepository;
import domain.user.driver.Driver;
import domain.user.driver.DriverRepository;
import domain.vehicle.Vehicle;
import domain.vehicle.VehicleId;
import domain.vehicle.VehicleRepository;
import domain.vehicle.VehicleType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ManagerServiceTest {

	private static final String A_NAME = "Karim";
	private static final String A_PLATE_NUMBER = "78 du 2345";

	private static final String A_LAST_NAME = "Benzema";
	private static final String AN_ID_NUMBER = "B789456";
	private static final String A_DRIVER_LICENCE = "7895465";
	private static final String A_CELL_PHONE_NUMBER = "78984512";
	private static final String A_BIRTH_DATE = "30/11/1899";


	private static final String A_MODEL = "Mercedes";
	private static final VehicleType A_TYPE = VehicleType.CAR;
	private static final String A_COLOR = "blue";

	private static final String AN_ORDER_NUMBER = "2019-0001";
	private static final String A_LOCATION = "Gaoua";
	private static final String  A_START_DATE = "2020-11-05";
	private static final String AN_END_DATE = "2022-12-01";
	private static final String A_DRIVER_NAME = "Achille";
	private static final String A_COMPANION_NAME = "Moussa";
	private static final String A_DESCRIPTION = "mettre le feu";
	private static final String A_MEAN_OF_TRANSPORT = "car";



	private ManagerService managerService;
	private VehicleDto vehicleDto;

	private Vehicle vehicle;
	private VehicleId vehicleId;

	@Mock
	private VehicleFactory vehicleFactory;
	@Mock
	private VehicleRepository vehicleRepository;
	@Mock
	private DriverFactory driverFactory;
	@Mock
	private MissionFactory missionFactory;
	@Mock
	private DriverRepository driverRepository;
	@Mock
	private MissionRepository missionRepository;

	private DriverDto driverDto;
	private Driver driver;
	private MissionDto missionDto;
	private Mission mission;
	private UserId userId;
	private List<Driver> drivers;

	private void setUpDto(){
		driverDto = new DriverDto();

		driverDto.setFirstName(A_NAME);
		driverDto.setBirthDate(A_BIRTH_DATE);
		driverDto.setLastName(A_LAST_NAME);
		driverDto.setIdNumber(AN_ID_NUMBER);
		driverDto.setCellPhoneNumber(A_CELL_PHONE_NUMBER);
		driverDto.setDriverLicenceNumber(A_DRIVER_LICENCE);
	}

	private void setUpMissionDto(){
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
	public void setUp() throws Exception{
		drivers = new ArrayList<>();
		setUpDto();
		setUpMissionDto();
		userId = new UserId();
		driver = new Driver(userId,A_NAME,A_LAST_NAME,AN_ID_NUMBER,A_DRIVER_LICENCE,A_CELL_PHONE_NUMBER,A_BIRTH_DATE);
		vehicleId = new VehicleId(A_PLATE_NUMBER);
		vehicleDto = new VehicleDto();
		vehicle = new Vehicle(vehicleId,A_PLATE_NUMBER,A_MODEL,A_COLOR,A_TYPE);
		drivers.add(driver);
		managerService = new ManagerService(vehicleFactory,vehicleRepository,driverFactory,driverRepository,missionFactory,missionRepository);
	}

	@Test
	public void whenCreatingANewVehicle_thenDelegateToAssembler()throws Exception{
		managerService.create(vehicleDto);

		verify(vehicleFactory).assemble(vehicleDto);
	}

	@Test
	public void whenCreatingANewVehicle_thenDedicateSavingToTheRepo()throws Exception{
		willReturn(vehicle).given(vehicleFactory).assemble(vehicleDto);

		managerService.create(vehicleDto);

		verify(vehicleRepository).save(vehicle);
	}

	@Test
	public void whenCreatingANewDriver_thenDelegateCreationToAssembler()throws Exception{

		managerService.createDriver(driverDto);

		verify(driverFactory).assemble(driverDto);
	}

	@Test
	public void whenCreatingANewDriver_thenDelegateSavingToTheRepo()throws Exception{
		willReturn(driver).given(driverFactory).assemble(driverDto);

		managerService.createDriver(driverDto);

		verify(driverRepository).save(driver);

	}

	@Test
	public void whenCreatingANewMission_thenDelegateCreationToAssembler()throws Exception{
		willReturn(vehicle).given(vehicleRepository).find(A_PLATE_NUMBER);
		willReturn(driver).given(driverRepository).findDriverByName(A_DRIVER_NAME);

		managerService.createMission(missionDto);

		verify(missionFactory).create(missionDto, driver, vehicle);
	}

	@Test
	public void whenCreatingANewMission_thenDelegateSavingAssembler()throws Exception{
		willReturn(mission).given(missionFactory).create(missionDto, driver, vehicle);

		managerService.createMission(missionDto);

		verify(missionRepository).save(mission);
	}

	@Test
	public void whenAssociatingADriverToAVehicle_thenDelegateToRepositoryToFindDriver()throws Exception{

		managerService.associateDriverToVehicle(driverDto);

		verify(driverRepository).findDriverByName(A_NAME);
	}

	@Test
	public void whenTryingToFindAVehicleByPlateNumber_thenDelgateToRepo()throws Exception{
		managerService.createMission(missionDto);

		verify(vehicleRepository).find(A_PLATE_NUMBER);
	}

}
