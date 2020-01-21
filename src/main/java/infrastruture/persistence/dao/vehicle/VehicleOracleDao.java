package infrastruture.persistence.dao.vehicle;

import infrastruture.persistence.dao.exception.DaoEntityNotFoundException;
import infrastruture.persistence.dao.exception.DaoInternalException;
import infrastruture.persistence.dto.vehicle.VehicleDto;

public class VehicleOracleDao implements VehicleDao {
	@Override
	public void save(VehicleDto vehicleDto) throws DaoInternalException {

	}

	@Override
	public VehicleDto find(String aPlateNumber) throws DaoEntityNotFoundException, DaoInternalException {
		return null;
	}
}
