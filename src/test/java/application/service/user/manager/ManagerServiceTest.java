package application.service.user.manager;

import api.resource.dto.MissionDto;
import api.resource.dto.driver.DriverDto;
import api.resource.dto.vehicle.VehicleDto;
import application.service.mission.MissionFactory;
import application.service.user.driver.DriverFactory;
import application.service.vehicle.VehicleFactory;
import domain.mission.Mission;
import domain.mission.MissionRepository;
import domain.user.driver.Driver;
import domain.user.driver.DriverRepository;
import domain.vehicle.Vehicle;
import domain.vehicle.VehicleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ManagerServiceTest {

	private static final String A_NAME = "Karim";
	private ManagerService managerService;
	private VehicleDto vehicleDto;

	private Vehicle vehicle;

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

	private void setUpDto(){
		driverDto = new DriverDto();

		driverDto.setFirstName(A_NAME);
	}

	@Before
	public void setUp(){
		setUpDto();
		vehicleDto = new VehicleDto();
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

		managerService.createMission(missionDto);

		verify(missionFactory).create(missionDto);
	}

	@Test
	public void whenCreatingANewMission_thenDelegateSavingAssembler()throws Exception{
		willReturn(mission).given(missionFactory).create(missionDto);

		managerService.createMission(missionDto);

		verify(missionRepository).save(mission);
	}

	@Test
	public void whenAssociatingADriverToAVehicle_thenDelegateToRepositoryToFindDriver()throws Exception{

		managerService.associateDriverToVehicle(driverDto);

		verify(driverRepository).findDriverByName(A_NAME);
	}

}
