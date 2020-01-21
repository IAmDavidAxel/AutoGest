package server.context.resourcecontext;

import api.resource.mission.MissionJsonResource;
import api.resource.mission.MissionResource;
import application.service.mission.MissionFactory;
import application.service.user.driver.DriverFactory;
import application.service.user.driver.IdFactory;
import application.service.user.manager.ManagerService;
import application.service.vehicle.VehicleFactory;
import domain.mission.MissionRepository;
import domain.user.driver.DriverRepository;
import domain.vehicle.VehicleRepository;
import utility.servicelocator.ServiceLocator;

public class MissionResourceContext {

	public static MissionResource create (){

		IdFactory idFactory = new IdFactory();

		VehicleFactory vehicleFactory = new VehicleFactory();
		DriverFactory driverFactory = new DriverFactory(idFactory);
		MissionFactory missionFactory = new MissionFactory();

		VehicleRepository vehicleRepository = ServiceLocator.INSTANCE.resolve(VehicleRepository.class);
		DriverRepository driverRepository = ServiceLocator.INSTANCE.resolve(DriverRepository.class);
		MissionRepository missionRepository =ServiceLocator.INSTANCE.resolve(MissionRepository.class);


		ManagerService managerService = new ManagerService(vehicleFactory,vehicleRepository,driverFactory,driverRepository,missionFactory,missionRepository);

		return  new MissionJsonResource(managerService);
	}

}
