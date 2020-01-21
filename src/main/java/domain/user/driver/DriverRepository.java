package domain.user.driver;

import infrastruture.persistence.exception.ObjectNotFoundException;
import infrastruture.persistence.exception.PersistenseInternalException;

import java.util.List;

public interface DriverRepository {
	void save(Driver driver) throws PersistenseInternalException;

	List<Driver> findDriversByName(String name) throws PersistenseInternalException, ObjectNotFoundException;

	Driver findDriverByName(String name) throws PersistenseInternalException, ObjectNotFoundException;
}
