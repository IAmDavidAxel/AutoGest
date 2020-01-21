package application.service.user.manager;

import api.resource.dto.MissionDto;
import api.resource.dto.driver.DriverDto;
import api.resource.dto.vehicle.VehicleDto;
import application.service.exception.DriverNotFoundServiceException;
import application.service.exception.PersistenceInternalServiceException;
import application.service.exception.ServiceException;
import application.service.mission.MissionFactory;
import application.service.user.driver.DriverFactory;
import application.service.vehicle.VehicleFactory;
import domain.mission.Mission;
import domain.mission.MissionRepository;
import domain.user.driver.Driver;
import domain.user.driver.DriverRepository;
import domain.vehicle.Vehicle;
import domain.vehicle.VehicleRepository;
import infrastruture.persistence.exception.ObjectNotFoundException;
import infrastruture.persistence.exception.PersistenseInternalException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ManagerService {

	private VehicleFactory vehicleFactory;
	private VehicleRepository vehicleRepository;
	private DriverFactory driverFactory;
	private DriverRepository driverRepository;
	private MissionFactory missionFactory;
	private MissionRepository missionRepository;

	public ManagerService(VehicleFactory vehicleFactory, VehicleRepository vehicleRepository, DriverFactory driverFactory, DriverRepository driverRepository, MissionFactory missionFactory, MissionRepository missionRepository) {

		this.vehicleFactory = vehicleFactory;
		this.vehicleRepository = vehicleRepository;
		this.driverFactory = driverFactory;
		this.driverRepository = driverRepository;
		this.missionFactory = missionFactory;
		this.missionRepository = missionRepository;
	}

	public void create(VehicleDto vehicleDto) throws ServiceException{

		Vehicle vehicle = createVehicleFromAssembler(vehicleDto);
		saveVehicle(vehicle);
	}

	public void createDriver(DriverDto driverDto) throws ServiceException{

		Driver driver = createDriverFromFactory(driverDto);
		saveDriver(driver);

	}

	private void saveDriver(Driver driver) throws ServiceException{
		try{
			driverRepository.save(driver);
		}catch (PersistenseInternalException exception){
			Logger.getGlobal().log(Level.WARNING, exception.getMessage());
			throw  new PersistenceInternalServiceException();
		}
	}

	private Driver createDriverFromFactory(DriverDto driverDto) {
		return driverFactory.assemble(driverDto);
	}

	private void saveVehicle(Vehicle vehicle) throws ServiceException {
		try {
			vehicleRepository.save(vehicle);
		} catch (PersistenseInternalException exception){
			Logger.getGlobal().log(Level.WARNING,exception.getMessage());
			throw new PersistenceInternalServiceException();
		}
	}

	private Vehicle createVehicleFromAssembler(VehicleDto vehicleDto) {
		return vehicleFactory.assemble(vehicleDto);
	}


	public void createMission(MissionDto missionDto) throws ServiceException {

		Mission mission  = createMissionFromFactory(missionDto);
		saveMission(mission);
	}

	private void saveMission(Mission mission) throws ServiceException {
		try{
			missionRepository.save(mission);
		}catch (PersistenseInternalException exception){
			Logger.getGlobal().log(Level.WARNING,exception.getMessage());
			throw  new PersistenceInternalServiceException();
		}
	}

	private Mission createMissionFromFactory(MissionDto missionDto) {
		return missionFactory.create(missionDto);
	}

	public void associateDriverToVehicle(DriverDto driverDto) throws ServiceException{

		String name = driverDto.getFirstName();

		Driver driver = findByDriverByName(name);

	}

	private Driver findByDriverByName(String name) throws ServiceException {

		try{
			return driverRepository.findDriverByName(name);
		}catch (PersistenseInternalException exception){
			Logger.getGlobal().log(Level.WARNING,exception.getMessage());
			throw  new PersistenceInternalServiceException();
		}catch (ObjectNotFoundException exception){
			Logger.getGlobal().log(Level.WARNING,exception.getMessage());
			throw  new DriverNotFoundServiceException();
		}
	}
}
