package api.resource.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MissionDto {

	@JsonProperty(value = "order_number", access = JsonProperty.Access.READ_WRITE)
	private String orderNumber;

	@JsonProperty(value = "mission_description", access = JsonProperty.Access.READ_WRITE)
	private String missionDescription;

	@JsonProperty(value = "driver_name")
	private String associatedDriverName;

	@JsonProperty(value = "plate_number", access = JsonProperty.Access.READ_WRITE)
	private String vehiclePlateNumber;

	@JsonProperty(value = "location", access = JsonProperty.Access.READ_WRITE)
	private String location;

	@JsonProperty(value = "mission_start_date", access = JsonProperty.Access.READ_WRITE)
	private String missionStartDate;

	@JsonProperty(value = "mission_end_date", access = JsonProperty.Access.READ_WRITE)
	private String missionEndDate;

	@JsonProperty(value = "driver_companion", access = JsonProperty.Access.READ_WRITE)
	private String accompanantDriverName;

	@JsonProperty(value = "mean_of_transport", access = JsonProperty.Access.READ_WRITE)
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
