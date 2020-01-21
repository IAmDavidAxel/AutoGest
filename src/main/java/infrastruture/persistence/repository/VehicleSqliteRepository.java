package infrastruture.persistence.repository;

import domain.vehicle.Vehicle;
import domain.vehicle.VehicleRepository;
import infrastruture.persistence.assembler.vehicle.VehicleAssembler;
import infrastruture.persistence.dao.exception.DaoEntityNotFoundException;
import infrastruture.persistence.dao.exception.DaoInternalException;
import infrastruture.persistence.dao.vehicle.VehicleDao;
import infrastruture.persistence.dto.vehicle.VehicleDto;
import infrastruture.persistence.exception.ObjectNotFoundException;
import infrastruture.persistence.exception.PersistenseInternalException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class VehicleSqliteRepository implements VehicleRepository {

	private VehicleAssembler vehicleAssembler;
	private VehicleDao vehicleDao;

	public VehicleSqliteRepository(VehicleAssembler vehicleAssembler, VehicleDao vehicleDao) {

		this.vehicleAssembler = vehicleAssembler;
		this.vehicleDao = vehicleDao;
	}

	@Override
	public void save(Vehicle vehicle) throws PersistenseInternalException {

		VehicleDto vehicleDto = createDtoFromAssembler(vehicle);
		saveVehicle(vehicleDto);

	}

	@Override
	public Vehicle find(String aPlateNumber) throws PersistenseInternalException, ObjectNotFoundException {

		VehicleDto vehicleDto = getVehicleByPlateNumber(aPlateNumber);

		Vehicle vehicle = createVehicleFromAssembler(vehicleDto);
		return vehicle;
	}

	private Vehicle createVehicleFromAssembler(VehicleDto vehicleDto) {
		return vehicleAssembler.assemble(vehicleDto);
	}

	private VehicleDto getVehicleByPlateNumber(String aPlateNumber) throws PersistenseInternalException, ObjectNotFoundException{
		try{
			return vehicleDao.find(aPlateNumber);
		}catch (DaoInternalException exception){
			Logger.getGlobal().log(Level.WARNING,exception.getMessage());
			throw new PersistenseInternalException();
		}catch (DaoEntityNotFoundException exception){
			Logger.getGlobal().log(Level.WARNING,exception.getMessage());
			throw new ObjectNotFoundException();
		}
	}

	private void saveVehicle(VehicleDto vehicleDto) throws PersistenseInternalException {
		try {
			vehicleDao.save(vehicleDto);
		} catch (DaoInternalException exception){
			Logger.getGlobal().log(Level.WARNING,exception.getMessage());
			throw  new PersistenseInternalException();
		}
	}

	private VehicleDto createDtoFromAssembler(Vehicle vehicle) {
		return vehicleAssembler.assemble(vehicle);
	}
}
