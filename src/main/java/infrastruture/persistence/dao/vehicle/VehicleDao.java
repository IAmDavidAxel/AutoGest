package infrastruture.persistence.dao.vehicle;

import infrastruture.persistence.dao.exception.DaoInternalException;
import infrastruture.persistence.dto.vehicle.VehicleDto;

public interface VehicleDao {
	void save(VehicleDto vehicleDto) throws DaoInternalException;
}
