package domain.user.driver;

import application.service.user.driver.UserId;
import domain.vehicle.Vehicle;
import domain.vehicle.VehicleId;

public class Driver {
	private UserId userId;
	private String firstName;
	private String lastName;
	private String idNumber;
	private String driverLicenceNumber;
	private String cellPhoneNumber;
	private String birthDate;
	private Vehicle vehicle;


	public Driver(UserId userId, String firstName, String lastName, String idNumber, String driverLicenceNumber, String cellPhoneNumber, String birthDate) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = idNumber;
		this.driverLicenceNumber = driverLicenceNumber;
		this.cellPhoneNumber = cellPhoneNumber;
		this.birthDate = birthDate;
		this.vehicle =null;

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public String getDriverLicenceNumber() {
		return driverLicenceNumber;
	}

	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	public String getBirthDate() {
		return this.birthDate;
	}

	public String getUserId() {

		return userId.getIdValue();
	}

	public Vehicle getVehicle() {
		return vehicle;
	}


	public void assignVehicle(Vehicle vehicle) throws VehicleAlreadyAssignedException{

		if(isAssignedToVehicle()){
			throw  new VehicleAlreadyAssignedException();
		}else {
			this.vehicle = vehicle;
		}

	}

	public boolean isAssignedToVehicle() {
		return this.vehicle!=null;
	}
}
