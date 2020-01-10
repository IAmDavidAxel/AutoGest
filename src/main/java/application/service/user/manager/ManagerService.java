package application.service.user.manager;

import api.resource.dto.vehicle.VehicleDto;
import application.service.exception.PersistenceInternalServiceException;
import application.service.exception.ServiceException;
import application.service.vehicle.VehicleFactory;
import domain.vehicle.Vehicle;
import domain.vehicle.VehicleRepository;
import infrastruture.persistence.exception.PersistenseInternalException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ManagerService {

	private VehicleFactory vehicleFactory;
	private VehicleRepository vehicleRepository;

	public ManagerService(VehicleFactory vehicleFactory, VehicleRepository vehicleRepository) {

		this.vehicleFactory = vehicleFactory;
		this.vehicleRepository = vehicleRepository;
	}

	public void create(VehicleDto vehicleDto) throws ServiceException{

		Vehicle vehicle = createVehicleFromAssembler(vehicleDto);
		saveVehicle(vehicle);
	}

	private void saveVehicle(Vehicle vehicle) throws ServiceException {
		try {
			vehicleRepository.save(vehicle);
		} catch (PersistenseInternalException exception){
			Logger.getGlobal().log(Level.WARNING,exception.getMessage());
			throw new PersistenceInternalServiceException();
		}
	}

	private Vehicle createVehicleFromAssembler(VehicleDto vehicleDto) {
		return vehicleFactory.assemble(vehicleDto);
	}
}
