package domain.vehicle;

public class Vehicle {

	private VehicleId vehicleId;
	private String plateNumber;
	private String model;
	private String color;
	private VehicleType vehicleType;

	public Vehicle( VehicleId vehicleId,String plateNumber, String model, String color, VehicleType vehicleType) {
		this.vehicleId = vehicleId;
		this.plateNumber = plateNumber;
		this.model = model;
		this.color = color;
		this.vehicleType = vehicleType;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public String getModel() {
		return model;
	}


	public String getColor() {
		return color;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public String getIdValue() {

		return this.vehicleId.getId();
	}
}
