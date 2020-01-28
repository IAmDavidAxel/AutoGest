package domain.mission;

import domain.user.driver.Driver;
import domain.vehicle.Vehicle;

import java.time.LocalDate;

public class Mission {
	private  MissionId missionId;
	private String missionOrderNumber;
	private String location;
	private LocalDate missionStartDate;
	private LocalDate missionEndDate;
	private Driver driverAssigned;
	private Vehicle vehicle;

	public Mission(MissionId missionId, String location, String missionOrderNumber, LocalDate missionStartDate, LocalDate missionEndDate, Driver driver, Vehicle vehicle) {
		this.missionId = missionId;
		this.missionOrderNumber = missionOrderNumber;
		this.location = location;
		this.missionEndDate =missionEndDate;
		this.missionStartDate = missionStartDate;
		this.driverAssigned = driver;
		this.vehicle = vehicle;
	}

	public String getMissionOrderNumber() {
		return missionOrderNumber;
	}

	public String getLocation() {
		return location;
	}

	public LocalDate getMissionStartDate() {
		return missionStartDate;
	}


	public LocalDate getMissionEndDate() {
		return missionEndDate;
	}

	public Driver getDriverAssigned() {
		return driverAssigned;
	}


	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
}
