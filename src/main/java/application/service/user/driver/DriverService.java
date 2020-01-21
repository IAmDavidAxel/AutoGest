package application.service.user.driver;

import api.resource.dto.driver.DriverDto;
import application.service.exception.DriverNotFoundServiceException;
import application.service.exception.PersistenceInternalServiceException;
import application.service.exception.ServiceException;
import domain.user.driver.Driver;
import domain.user.driver.DriverRepository;
import infrastruture.persistence.exception.ObjectNotFoundException;
import infrastruture.persistence.exception.PersistenseInternalException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverService {

	private DriverFactory driverFactory;
	private DriverRepository driverRepository;

	public DriverService(DriverFactory driverFactory, DriverRepository driverRepository) {

		this.driverFactory = driverFactory;
		this.driverRepository = driverRepository;
	}

	public List<DriverDto> findDriverByName(String name) throws ServiceException {

		List<Driver> drivers = FindDriverBy(name);

		return createDriverDtos(drivers);
	}

	private List<DriverDto> createDriverDtos(List<Driver> drivers) {
		return driverFactory.assembleList(drivers);
	}

	private List<Driver> FindDriverBy(String name) throws ServiceException{

		try{
		 return driverRepository.findDriversByName(name);
		} catch (PersistenseInternalException  exception) {
			Logger.getGlobal().log(Level.WARNING, exception.getMessage());
			throw new PersistenceInternalServiceException();
		} catch (ObjectNotFoundException exception){
			Logger.getGlobal().log(Level.WARNING,exception.getMessage());
			throw new DriverNotFoundServiceException();
		}
	}
}
