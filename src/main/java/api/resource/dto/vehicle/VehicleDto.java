package api.resource.dto.vehicle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import domain.vehicle.VehicleType;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleDto {

	@JsonProperty(value = "plate_number")
	private String plateNumber;

	@JsonProperty(value = "model")
	private String model;

	@JsonProperty(value = "type")
	private VehicleType type;

	@JsonProperty(value = "color")
	private String color;

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}

	public VehicleType getType() {
		return type;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}
}
