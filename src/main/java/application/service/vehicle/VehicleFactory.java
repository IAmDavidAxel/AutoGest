package application.service.vehicle;

import api.resource.dto.vehicle.VehicleDto;
import domain.vehicle.Vehicle;
import domain.vehicle.VehicleId;
import domain.vehicle.VehicleType;

public class VehicleFactory {

	public Vehicle assemble(VehicleDto vehicleDto) {
		
		String model = vehicleDto.getModel();
		String plateNumber = vehicleDto.getPlateNumber();
		String color = vehicleDto.getColor();

		VehicleType vehicleType = vehicleDto.getType();

		VehicleId vehicleId= new VehicleId(plateNumber);

		return new Vehicle(vehicleId,plateNumber,model,color,vehicleType);
	}
}
