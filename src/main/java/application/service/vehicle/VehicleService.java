package application.service.vehicle;

import api.resource.dto.vehicle.VehicleDto;
import application.service.exception.PersistenceInternalServiceException;
import application.service.exception.ServiceException;
import application.service.exception.VehicleNotFoundServiceException;
import domain.vehicle.Vehicle;
import domain.vehicle.VehicleRepository;
import infrastruture.persistence.exception.ObjectNotFoundException;
import infrastruture.persistence.exception.PersistenseInternalException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class VehicleService {


	private VehicleFactory vehicleFactory;
	private VehicleRepository vehicleRepository;

	public VehicleService(VehicleFactory vehicleFactory, VehicleRepository vehicleRepository) {

		this.vehicleFactory = vehicleFactory;
		this.vehicleRepository = vehicleRepository;
	}

	public VehicleDto find(String aPlateNumber) throws ServiceException {
		Vehicle  vehicle = findVehicleFromRepo(aPlateNumber);
		VehicleDto vehicleDto = createVehicleFromFactory(vehicle);

		return vehicleDto;
	}

	private VehicleDto createVehicleFromFactory(Vehicle vehicle) {
		return  vehicleFactory.assemble(vehicle);
	}

	private Vehicle findVehicleFromRepo(String aPlateNumber) throws ServiceException {
		try {
			return vehicleRepository.find(aPlateNumber);
		}catch (PersistenseInternalException exception){
			Logger.getGlobal().log(Level.WARNING,exception.getMessage());
			throw  new PersistenceInternalServiceException();
		}catch (ObjectNotFoundException exception){
			Logger.getGlobal().log(Level.WARNING,exception.getMessage());
			throw new VehicleNotFoundServiceException();
		}
	}
}
