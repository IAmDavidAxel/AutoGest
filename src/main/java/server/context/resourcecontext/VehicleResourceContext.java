package server.context.resourcecontext;

import api.resource.vehicle.VehicleJsonResource;
import api.resource.vehicle.VehicleResource;
import application.service.user.manager.ManagerService;
import application.service.vehicle.VehicleFactory;
import domain.vehicle.VehicleRepository;
import utility.servicelocator.ServiceLocator;

public class VehicleResourceContext {

	public  static VehicleResource create(){
		VehicleFactory vehicleFactory = new VehicleFactory();

		VehicleRepository vehicleRepository = ServiceLocator.INSTANCE.resolve(VehicleRepository.class);

		ManagerService managerService = new ManagerService(vehicleFactory,vehicleRepository);

		return new VehicleJsonResource(managerService);
	}
}
