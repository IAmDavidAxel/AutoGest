package infrastruture.persistence.assembler.driver;

import application.service.user.driver.UserId;
import domain.user.driver.Driver;
import infrastruture.persistence.dto.driver.DriverDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class DriverAssemblerTest {

	private static final String A_FIRST_NAME = "karim";
	private static final String A_LAST_NAME = "Benzema";
	private static final String AN_ID_NUMBER = "B789456";
	private static final String A_DRIVER_LICENCE = "7895465";
	private static final String A_CELL_PHONE_NUMBER = "78984512";
	private static final String A_BIRTH_DATE = "30/11/1899";

	private DriverAssembler driverAssembler;
	private Driver driver;
	private UserId userId;
	private DriverDto driverDto;
	private List<DriverDto> driverDtos;

	private void setUpDto(){
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
		setUpDto();
		driverDtos = new ArrayList<>();
		userId =new UserId();
		driver = new Driver(userId, A_FIRST_NAME,A_LAST_NAME,AN_ID_NUMBER,A_DRIVER_LICENCE,A_CELL_PHONE_NUMBER,A_BIRTH_DATE);

		driverAssembler = new DriverAssembler();
	}

	@Test
	public void whenAssemblingToSavingDto_thenAllAttributesAreEquals(){

		DriverDto driverDto = driverAssembler.assemble(driver);

		String userId = driverDto.getUserId();
		String firstName = driverDto.getFirstName();
		String lastName = driverDto.getLastName();
		String idNumber = driverDto.getIdNumber();
		String cellPhoneNumber = driverDto.getCellPhoneNumber();
		String birthDate = driverDto.getBirthDate();
		String driverLicenceNumber = driverDto.getDriverLicenceNumber();


		assertEquals(userId,driver.getUserId());
		assertEquals(firstName,A_FIRST_NAME);
		assertEquals(lastName,A_LAST_NAME);
		assertEquals(idNumber,AN_ID_NUMBER);
		assertEquals(cellPhoneNumber,A_CELL_PHONE_NUMBER);
		assertEquals(birthDate,A_BIRTH_DATE);
		assertEquals(driverLicenceNumber,A_DRIVER_LICENCE);
	}

	@Test
	public void whenAssembleDriverDtoToDomainObject_thenAttributesAreEquals(){

		Driver driverFromAssembler = driverAssembler.assemble(driverDto);

		assertEquals(driverFromAssembler.getBirthDate(),A_BIRTH_DATE);
		assertEquals(driverFromAssembler.getCellPhoneNumber(),A_CELL_PHONE_NUMBER);
		assertEquals(driverFromAssembler.getLastName(),A_LAST_NAME);
		assertEquals(driverFromAssembler.getFirstName(),A_FIRST_NAME);
		assertEquals(driverFromAssembler.getDriverLicenceNumber(),A_DRIVER_LICENCE);
	}

	@Test
	public void whenAssemblingToListOfDomainObject_thenTheListIsNotEmpty(){
		driverDtos.add(driverDto);

		List<Driver> drivers = driverAssembler.assembleToDomainList(driverDtos);

		assertTrue(drivers.size() > 0);

	}

	@Test
	public void whenAssemblingToListDomainObject_thenTheRetrieveObjectHasCorrectValues(){

		driverDtos.add(driverDto);

		List<Driver> drivers = driverAssembler.assembleToDomainList(driverDtos);

		Driver driver = drivers.get(0);

		String firstName = driver.getFirstName();

		assertEquals(firstName,A_FIRST_NAME);
	}

}
