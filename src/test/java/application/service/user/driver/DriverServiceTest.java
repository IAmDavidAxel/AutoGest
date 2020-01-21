package application.service.user.driver;

import api.resource.dto.driver.DriverDto;
import domain.user.driver.Driver;
import domain.user.driver.DriverRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.willReturn;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DriverServiceTest {

	private static final String A_NAME = "Karim";

	private DriverService driverService;

	@Mock
	private DriverRepository driverRepository;
	@Mock
	private DriverFactory driverFactory;
	private List<Driver> drivers;
	private List<DriverDto> driverDtos;


	@Before
	public void setUp() throws Exception {
		drivers =new ArrayList<>();
		driverDtos = new ArrayList<>();
		driverService = new DriverService(driverFactory,driverRepository);
	}

	@Test
	public void whenFindingADriverByName_thenDelegateSearchToRepo()throws Exception{

		driverService.findDriverByName(A_NAME);

		verify(driverRepository).findDriversByName(A_NAME);
	}

	@Test
	public void whenFindingADriverByName_thenDelegateAssemblyToRepo()throws Exception{
		willReturn(drivers).given(driverRepository).findDriversByName(A_NAME);

		driverService.findDriverByName(A_NAME);

		verify(driverFactory).assembleList(drivers);
	}
}
