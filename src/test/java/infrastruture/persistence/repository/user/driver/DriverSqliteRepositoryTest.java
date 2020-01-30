package infrastruture.persistence.repository.user.driver;

import domain.user.driver.Driver;
import infrastruture.persistence.assembler.driver.DriverAssembler;
import infrastruture.persistence.dao.driver.DriverDao;
import infrastruture.persistence.dto.driver.DriverDto;
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
public class DriverSqliteRepositoryTest {

	private static final String A_NAME = "Karim";
	private static final String A_FIRST_NAME = "karim";
	private static final String A_LAST_NAME = "Benzema";
	private static final String AN_ID_NUMBER = "B789456";
	private static final String A_DRIVER_LICENCE = "7895465";
	private static final String A_CELL_PHONE_NUMBER = "78984512";
	private static final String A_BIRTH_DATE = "30/11/1899";

	private DriverSqliteRepository driverSqliteRepository;

	@Mock
	private DriverAssembler driverAssembler;
	@Mock
	private DriverDao driverDao;
	private Driver driver;
	private DriverDto driverDto;
	private List<DriverDto> driverDtos;

	private void setUpDriverDto(){
		driverDto = new DriverDto();

		driverDto.setFirstName(A_FIRST_NAME);
		driverDto.setLastName(A_LAST_NAME);
		driverDto.setIdNumber(AN_ID_NUMBER);
		driverDto.setDriverLicenceNumber(A_DRIVER_LICENCE);
		driverDto.setCellPhoneNumber(A_CELL_PHONE_NUMBER);
		driverDto.setBirthDate(A_BIRTH_DATE);
	}

	@Before
	public void setUp(){
		setUpDriverDto();
		driverDtos = new ArrayList<>();
		driverSqliteRepository = new DriverSqliteRepository(driverAssembler,driverDao);
	}

	@Test
	public void whenSaving_thenDelegateTransformationToTheAssembler()throws Exception{

		driverSqliteRepository.save(driver);

		verify(driverAssembler).assemble(driver);
	}

	@Test
	public void whenSaving_thenDelegateDaoForTheDBTalking()throws Exception{
		willReturn(driverDto).given(driverAssembler).assemble(driver);

		driverSqliteRepository.save(driver);

		verify(driverDao).save(driverDto);
	}

	@Test
	public void whenFindingDrivers_thenDelegateSearchToTheDao()throws Exception{

		driverSqliteRepository.findDriversByName(A_NAME);

		verify(driverDao).findListByName(A_NAME);

	}

	@Test
	public void whenFindingDrivers_thenDelegateCreationToDomainObject()throws Exception{
		willReturn(driverDtos).given(driverDao).findListByName(A_NAME);

		driverSqliteRepository.findDriversByName(A_NAME);

		verify(driverAssembler).assembleToDomainList(driverDtos);
	}

	@Test
	public void whenFindingDriver_thenDelegateCreationToDomain()throws Exception{
		willReturn(driverDto).given(driverDao).findByName(A_NAME);

		driverSqliteRepository.findDriverByName(A_NAME);

		verify(driverAssembler).assemble(driverDto);
	}


}
