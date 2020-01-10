package server.context;

import api.resource.vehicle.VehicleResource;
import application.service.vehicle.VehicleFactory;
import domain.vehicle.VehicleRepository;
import infrastruture.persistence.assembler.vehicle.VehicleAssembler;
import infrastruture.persistence.dao.vehicle.VehicleDao;
import infrastruture.persistence.dao.vehicle.VehicleSqliteDao;
import infrastruture.persistence.entitymanager.sqlite.SqliteConnection;
import infrastruture.persistence.entitymanager.sqlite.SqliteEntityManager;
import infrastruture.persistence.repository.VehicleSqliteRepository;
import server.context.resourcecontext.VehicleResourceContext;
import utility.datamanager.ApplicationConfiguration;
import utility.servicelocator.ServiceLocator;

public class DevelopemntContext extends Context {

	 private  String databaseName;

	 public DevelopemntContext(){
	 	this.databaseName= ApplicationConfiguration.sqliteDbName;
	 }

	 public DevelopemntContext(String databaseName){
	 	this.databaseName = databaseName;
	 }

	@Override
	public void registerServices() {


		/**
		 * Register persistence infrastructure services
		 */
		VehicleAssembler vehicleAssembler = new VehicleAssembler();

		SqliteConnection connection = new SqliteConnection(databaseName);

		VehicleDao vehicleDao = new VehicleSqliteDao(connection);

		SqliteEntityManager entityManager = new SqliteEntityManager(connection);

		VehicleSqliteRepository vehicleRepository = new VehicleSqliteRepository(vehicleAssembler,vehicleDao);

		ServiceLocator.INSTANCE.register(VehicleRepository.class,vehicleRepository);


	}

	@Override
	public void initializeResource() {

		VehicleResource vehicleResource = VehicleResourceContext.create();

		this.resourcesContext.add(vehicleResource);
	}
}
