package infrastruture.persistence.assembler.driver;

import application.service.user.driver.UserId;
import com.sun.org.apache.bcel.internal.util.BCELifier;
import domain.user.driver.Driver;
import infrastruture.persistence.dto.driver.DriverDto;

import java.util.List;
import java.util.stream.Collectors;

public class DriverAssembler {

	public DriverDto assemble(Driver driver) {

		DriverDto driverDto = new DriverDto();

		driverDto.setUserId(driver.getUserId());
		driverDto.setBirthDate(driver.getBirthDate());
		driverDto.setCellPhoneNumber(driver.getCellPhoneNumber());
		driverDto.setFirstName(driver.getFirstName());
		driverDto.setLastName(driver.getLastName());
		driverDto.setIdNumber(driver.getIdNumber());
		driverDto.setDriverLicenceNumber(driver.getDriverLicenceNumber());

		return driverDto;
	}

	public List<Driver> assembleToDomainList(List<DriverDto> driverDtos) {
		return driverDtos.stream().map(this::assemble).collect(Collectors.toList());
	}

	public Driver assemble(DriverDto driverDto) {
		String userIdFromDto  =driverDto.getUserId();
		UserId userId = new UserId(userIdFromDto);

		String firstName = driverDto.getFirstName();
		String lastName = driverDto.getLastName();
		String birthDate = driverDto.getBirthDate();
		String idNumber = driverDto.getIdNumber();
		String driverLicenceNumber = driverDto.getDriverLicenceNumber();
		String cellPhoneNumber = driverDto.getCellPhoneNumber();

		return new Driver(userId,firstName,lastName,idNumber,driverLicenceNumber,cellPhoneNumber,birthDate);
	}
}
