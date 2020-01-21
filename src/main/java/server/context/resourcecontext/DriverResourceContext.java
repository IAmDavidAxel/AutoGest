package server.context.resourcecontext;

import api.resource.driver.DriverJsonResource;
import api.resource.driver.DriverResource;
import application.service.mission.MissionFactory;
import application.service.user.driver.DriverFactory;
import application.service.user.driver.DriverService;
import application.service.user.driver.IdFactory;
import application.service.user.manager.ManagerService;
import application.service.vehicle.VehicleFactory;
import domain.mission.MissionRepository;
import domain.user.driver.DriverRepository;
import domain.vehicle.VehicleRepository;
import utility.servicelocator.ServiceLocator;

public class DriverResourceContext {

	public static DriverResource create(){



		IdFactory idFactory = new IdFactory();

		VehicleFactory vehicleFactory = new VehicleFactory();
		DriverFactory driverFactory = new DriverFactory(idFactory);
		MissionFactory missionFactory = new MissionFactory();

		VehicleRepository  vehicleRepository = ServiceLocator.INSTANCE.resolve(VehicleRepository.class);
		DriverRepository driverRepository = ServiceLocator.INSTANCE.resolve(DriverRepository.class);
		MissionRepository missionRepository = ServiceLocator.INSTANCE.resolve(MissionRepository.class);


		ManagerService managerService = new ManagerService(vehicleFactory,vehicleRepository,driverFactory,driverRepository, missionFactory, missionRepository);
		DriverService driverService = new DriverService(driverFactory,driverRepository);

		return new DriverJsonResource(managerService, driverService);
	}
}
