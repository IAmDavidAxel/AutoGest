package infrastruture.persistence.repository;

import domain.vehicle.Vehicle;
import domain.vehicle.VehicleRepository;
import infrastruture.persistence.assembler.vehicle.VehicleAssembler;
import infrastruture.persistence.dao.exception.DaoInternalException;
import infrastruture.persistence.dao.vehicle.VehicleDao;
import infrastruture.persistence.dto.vehicle.VehicleDto;
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
