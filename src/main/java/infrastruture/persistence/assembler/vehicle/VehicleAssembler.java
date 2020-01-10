package infrastruture.persistence.assembler.vehicle;

import domain.vehicle.Vehicle;
import infrastruture.persistence.dto.vehicle.VehicleDto;

public class VehicleAssembler {
	public VehicleDto assemble(Vehicle vehicle) {

		VehicleDto vehicleDto = new VehicleDto();

		String color = vehicle.getColor();
		String plateNumber = vehicle.getPlateNumber();
		String model = vehicle.getModel();
		String type = vehicle.getVehicleType().toString();
		String id = vehicle.getIdValue();

		vehicleDto.setColor(color);
		vehicleDto.setPlateNumber(plateNumber);
		vehicleDto.setModel(model);
		vehicleDto.setType(type);
		vehicleDto.setId(id);

		return vehicleDto;
	}
}
