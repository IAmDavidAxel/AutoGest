package infrastruture.persistence.repository.user.driver;

import domain.user.driver.Driver;
import domain.user.driver.DriverRepository;
import infrastruture.persistence.assembler.driver.DriverAssembler;
import infrastruture.persistence.dao.driver.DriverDao;
import infrastruture.persistence.dao.exception.DaoEntityNotFoundException;
import infrastruture.persistence.dao.exception.DaoInternalException;
import infrastruture.persistence.dto.driver.DriverDto;
import infrastruture.persistence.exception.ObjectNotFoundException;
import infrastruture.persistence.exception.PersistenseInternalException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverSqliteRepository implements DriverRepository {


	private DriverAssembler driverAssembler;
	private DriverDao driverDao;

	public DriverSqliteRepository(DriverAssembler driverAssembler, DriverDao driverDao) {

		this.driverAssembler = driverAssembler;
		this.driverDao = driverDao;
	}

	@Override
	public void save(Driver driver) throws PersistenseInternalException {

		DriverDto driverDto = createDriverDtoFromAssembler(driver);
		saveDriver(driverDto);
	}

	@Override
	public List<Driver> findDriversByName(String name) throws PersistenseInternalException, ObjectNotFoundException {
		try{
			List<DriverDto> driversDto = driverDao.findListByName(name);
			List<Driver> drivers = assembleDrivers(driversDto);

			return drivers;
		} catch (DaoInternalException exception){
			Logger.getGlobal().log(Level.WARNING,exception.getMessage());
			throw  new PersistenseInternalException();
		} catch (DaoEntityNotFoundException exception){
			Logger.getGlobal().log(Level.WARNING,exception.getMessage());
			throw new ObjectNotFoundException();
		}
	}

	@Override
	public Driver findDriverByName(String name) throws PersistenseInternalException, ObjectNotFoundException {

		DriverDto driverDto = getDriverFromDao(name);

		return driverAssembler.assemble(driverDto);
	}

	private DriverDto getDriverFromDao(String name) throws PersistenseInternalException,ObjectNotFoundException {
		try{
			return driverDao.findByName(name);
		}catch (DaoInternalException exception){
			Logger.getGlobal().log(Level.WARNING, exception.getMessage());
			throw new PersistenseInternalException();
		}catch (DaoEntityNotFoundException e){
			Logger.getGlobal().log(Level.WARNING,e.getMessage());
			throw  new ObjectNotFoundException();
		}
	}

	private List<Driver> assembleDrivers(List<DriverDto> driversDto) {
		return driverAssembler.assembleToDomainList(driversDto);
	}

	private void saveDriver(DriverDto driverDto) throws PersistenseInternalException{
		try{
			driverDao.save(driverDto);
		}catch (DaoInternalException exception){
			throw  new PersistenseInternalException();
		}
	}

	private DriverDto createDriverDtoFromAssembler(Driver driver) {
		return driverAssembler.assemble(driver);
	}
}
