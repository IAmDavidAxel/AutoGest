package infrastruture.persistence.dto.mission;

public class MissionDto {
	private String orderNumber;
	private String location;
	private String vehiclePlateNumber;
	private String missionStartDate;
	private String missionEndDate;
	private String associatedDriverName;
	private String driverCompanion;
	private String missionDescription;
	private String meanOfTransport;
	private String missionId;

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public void setVehiclePlateNumber(String vehiclePlateNumber) {
		this.vehiclePlateNumber = vehiclePlateNumber;
	}

	public String getVehiclePlateNumber() {
		return vehiclePlateNumber;
	}

	public void setMissionStartDate(String missionStartDate) {
		this.missionStartDate = missionStartDate;
	}

	public String getMissionStartDate() {
		return missionStartDate;
	}

	public void setMissionEndDate(String missionEndDate) {
		this.missionEndDate = missionEndDate;
	}

	public String getMissionEndDate() {
		return missionEndDate;
	}

	public void setAssociatedDriverName(String associatedDriverName) {
		this.associatedDriverName = associatedDriverName;
	}

	public String getAssociatedDriverName() {
		return associatedDriverName;
	}

	public void setDriverCompanion(String driverCompanion) {
		this.driverCompanion = driverCompanion;
	}

	public String getDriverCompanion() {
		return driverCompanion;
	}

	public void setMissionDescription(String missionDescription) {
		this.missionDescription = missionDescription;
	}

	public String getMissionDescription() {
		return missionDescription;
	}

	public void setMeanOfTransport(String meanOfTransport) {
		this.meanOfTransport = meanOfTransport;
	}

	public String getMeanOfTransport() {
		return meanOfTransport;
	}

	public void setMissionId(String missionId) {
		this.missionId = missionId;
	}

	public String getMissionId() {
		return missionId;
	}
}
