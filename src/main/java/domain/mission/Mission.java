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
	private String missionDescription;
	private String meanOfTransport;
	private String driverCompanion;

	public Mission(MissionId missionId, String location, String missionOrderNumber, LocalDate missionStartDate, LocalDate missionEndDate, Driver driver, Vehicle vehicle, String missionDescription, String meanOfTransport, String driverCompanion) {
		this.missionId = missionId;
		this.missionOrderNumber = missionOrderNumber;
		this.location = location;
		this.missionEndDate =missionEndDate;
		this.missionStartDate = missionStartDate;
		this.driverAssigned = driver;
		this.vehicle = vehicle;
		this.missionDescription = missionDescription;
		this.meanOfTransport = meanOfTransport;
		this.driverCompanion = driverCompanion;
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

	public String getMissionDescription() {
		return missionDescription;
	}

	public void setMissionDescription(String missionDescription) {
		this.missionDescription = missionDescription;
	}

	public String getMeanOfTransport() {
		return meanOfTransport;
	}


	public MissionId getMissionId() {
		return missionId;
	}

	public String getDriverCompanion() {
		return driverCompanion;
	}
}
