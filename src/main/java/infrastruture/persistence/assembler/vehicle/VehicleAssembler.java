package infrastruture.persistence.assembler.vehicle;

import domain.vehicle.Vehicle;
import domain.vehicle.VehicleId;
import domain.vehicle.VehicleType;
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

	public Vehicle assemble(VehicleDto vehicleDto) {

		String idValue = vehicleDto.getId();


		String plateNumber = vehicleDto.getPlateNumber();
		String model = vehicleDto.getModel();
		String type = vehicleDto.getType();
		String color = vehicleDto.getColor();

		VehicleId vehicleId = new VehicleId(plateNumber);
		vehicleId.setId(idValue);

		VehicleType vehicleType = VehicleType.valueOf(type);

		return  new Vehicle(vehicleId,plateNumber,model,color,vehicleType);
	}
}
