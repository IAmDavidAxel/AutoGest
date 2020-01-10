package domain.vehicle;

public enum VehicleType {

	CAR("VOITURE"),VAN("VAN");

	private String vehicleType;

	private VehicleType(String type){
		this.vehicleType = type;
	}


	@Override
	public String toString() {
		return super.toString();
	}
}
