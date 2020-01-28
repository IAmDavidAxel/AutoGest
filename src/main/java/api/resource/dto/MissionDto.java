package api.resource.dto;

public class MissionDto {
	private String orderNumber;
	private String location;
	private String vehiclePlateNumber;
	private String missionStartDate;
	private String missionEndDate;
	private String associatedDriverName;
	private String accompanantDriverName;
	private String missionDescription;
	private String meanOfTransport;

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

	public void setAccompanantDriverName(String accompanantDriverName) {
		this.accompanantDriverName = accompanantDriverName;
	}

	public String getAccompanantDriverName() {
		return accompanantDriverName;
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
}
