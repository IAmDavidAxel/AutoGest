package infrastruture.persistence.dao.driver;

import infrastruture.persistence.dao.exception.DaoEntityNotFoundException;
import infrastruture.persistence.dao.exception.DaoInternalException;
import infrastruture.persistence.dto.driver.DriverDto;

import java.util.List;

public interface DriverDao {
	void save(DriverDto driverDto) throws DaoInternalException;

	List<DriverDto> findByName(String aName) throws DaoInternalException, DaoEntityNotFoundException;
}
