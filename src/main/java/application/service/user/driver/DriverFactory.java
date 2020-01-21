package application.service.user.driver;

import api.resource.dto.driver.DriverDto;
import domain.user.driver.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DriverFactory {

	private IdFactory idFactory;

	public DriverFactory(IdFactory idFactory) {

		this.idFactory = idFactory;
	}

	public Driver assemble(DriverDto driverDto) {

		String firstName = driverDto.getFirstName();
		String lastName = driverDto.getLastName();
		String cellPhoneNumber = driverDto.getCellPhoneNumber();
		String idNumber = driverDto.getIdNumber();
		String driverLicenceNumber = driverDto.getDriverLicenceNumber();
		String birthDate = driverDto.getBirthDate();

		UserId  userId = idFactory.createNewId();

		return new Driver(userId,firstName,lastName,idNumber,driverLicenceNumber,cellPhoneNumber,birthDate);
	}

	public List<DriverDto> assembleList(List<Driver> drivers) {
		return drivers.stream().map(this::assemble).collect(Collectors.toList());
	}

	public DriverDto assemble(Driver driver) {

		DriverDto driverDto = new DriverDto();

		driverDto.setLastName(driver.getLastName());
		driverDto.setFirstName(driver.getFirstName());
		driverDto.setDriverLicenceNumber(driver.getDriverLicenceNumber());
		driverDto.setCellPhoneNumber(driver.getCellPhoneNumber());
		driverDto.setIdNumber(driver.getIdNumber());
		driverDto.setBirthDate(driver.getBirthDate());

		return driverDto;
	}

}
