package domain.vehicle;

import infrastruture.persistence.dao.exception.DaoInternalException;
import infrastruture.persistence.exception.PersistenseInternalException;

public interface VehicleRepository {
	void save(Vehicle vehicle) throws  PersistenseInternalException;
}
