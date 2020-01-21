package application.service.user.driver;

import api.resource.dto.driver.DriverDto;
import domain.user.driver.Driver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DriverFactoryTest {

	private static final String A_FIRST_NAME = "karim";
	private static final String A_LAST_NAME = "Benzema";
	private static final String AN_ID_NUMBER = "B789456";
	private static final String A_DRIVER_LICENCE = "7895465";
	private static final String A_CELL_PHONE_NUMBER = "78984512";
	private static final String A_BIRTH_DATE = "30/11/1899";

	private DriverFactory driverFactory;


	private DriverDto driverDto;

	@Mock
	private IdFactory idFactory;
	private UserId userId;
	private List<Driver> drivers;
	private Driver driver;

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
		driver = new Driver(userId,A_FIRST_NAME,A_LAST_NAME,AN_ID_NUMBER,A_DRIVER_LICENCE,A_CELL_PHONE_NUMBER,A_BIRTH_DATE);
		setUpDriverDto();
		drivers = new ArrayList<>();
		userId = new UserId();
		driverFactory = new DriverFactory(idFactory);
		willReturn(userId).given(idFactory).createNewId();
	}

	@Test
	public void whenAssemblingToDomainObject_thenAllAttributesAreTheSame(){

		Driver driverFromAssembler = driverFactory.assemble(driverDto);

		String firstName = driverFromAssembler.getFirstName();
		String lastName = driverFromAssembler.getLastName();
		String  idNumber = driverFromAssembler.getIdNumber();
		String driverLicenceNumber = driverFromAssembler.getDriverLicenceNumber();
		String cellPhoneNumber = driverFromAssembler.getCellPhoneNumber();
		String birthDate = driverFromAssembler.getBirthDate();

		assertEquals(firstName ,A_FIRST_NAME);
		assertEquals(lastName,A_LAST_NAME);
		assertEquals(idNumber, AN_ID_NUMBER);
		assertEquals(driverLicenceNumber,A_DRIVER_LICENCE);
		assertEquals(cellPhoneNumber,A_CELL_PHONE_NUMBER);
		assertEquals(A_BIRTH_DATE,birthDate);
	}

	@Test
	public void whenAssemblingToDto_thenAllAttributesAreEqual(){

		DriverDto driverDto = driverFactory.assemble(driver);

		assertEquals(driverDto.getCellPhoneNumber(),A_CELL_PHONE_NUMBER);
	}

	@Test
	public void whenAssemblingToDtos_thenListIsNotEmpty(){
		drivers.add(driver);

		List<DriverDto> dtoList = driverFactory.assembleList(drivers);

		assertTrue(dtoList.size() > 0);
	}

	@Test
	public void whenAssemblingToDtos_thenTheDtoInsideTheListHasTheCorrectValues(){
		drivers.add(driver);

		List<DriverDto> dtoList = driverFactory.assembleList(drivers);

		DriverDto driverDto = dtoList.get(0);

		assertEquals(driverDto.getCellPhoneNumber(),A_CELL_PHONE_NUMBER);
	}
}
