package server.context;

import api.resource.driver.DriverResource;
import api.resource.mission.MissionResource;
import api.resource.vehicle.VehicleResource;
import application.service.user.manager.ManagerService;
import application.service.vehicle.VehicleFactory;
import domain.mission.MissionRepository;
import domain.mission.MissionSqliteRepository;
import domain.user.driver.DriverRepository;
import domain.vehicle.VehicleRepository;
import infrastruture.persistence.assembler.driver.DriverAssembler;
import infrastruture.persistence.assembler.mission.MissionAssembler;
import infrastruture.persistence.assembler.vehicle.VehicleAssembler;
import infrastruture.persistence.dao.driver.DriverDao;
import infrastruture.persistence.dao.driver.DriverSqliteDao;
import infrastruture.persistence.dao.mission.MissionDao;
import infrastruture.persistence.dao.mission.MissionSqliteDao;
import infrastruture.persistence.dao.vehicle.VehicleDao;
import infrastruture.persistence.dao.vehicle.VehicleSqliteDao;
import infrastruture.persistence.entitymanager.sqlite.SqliteConnection;
import infrastruture.persistence.entitymanager.sqlite.SqliteEntityManager;
import infrastruture.persistence.repository.VehicleSqliteRepository;
import infrastruture.persistence.repository.user.driver.DriverSqliteRepository;
import server.context.resourcecontext.DriverResourceContext;
import server.context.resourcecontext.MissionResourceContext;
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
		DriverAssembler driverAssembler = new DriverAssembler();
		MissionAssembler missionAssembler = new MissionAssembler();


		SqliteConnection connection = new SqliteConnection(databaseName);

		VehicleDao vehicleDao = new VehicleSqliteDao(connection);
		DriverDao driverDao = new DriverSqliteDao(connection);
		MissionDao missionDao = new MissionSqliteDao(connection);

		SqliteEntityManager entityManager = new SqliteEntityManager(connection);

		VehicleSqliteRepository vehicleRepository = new VehicleSqliteRepository(vehicleAssembler,vehicleDao);
		DriverSqliteRepository driverRepository  = new DriverSqliteRepository(driverAssembler,driverDao);
		MissionRepository missionRepository = new MissionSqliteRepository(missionAssembler,missionDao);



		ServiceLocator.INSTANCE.register(VehicleRepository.class,vehicleRepository);
		ServiceLocator.INSTANCE.register(DriverRepository.class,driverRepository);
		ServiceLocator.INSTANCE.register(MissionRepository.class,missionRepository);


	}

	@Override
	public void initializeResource() {

		VehicleResource vehicleResource = VehicleResourceContext.create();
		DriverResource driverResource = DriverResourceContext.create();
		MissionResource missionResource = MissionResourceContext.create();


		this.resourcesContext.add(vehicleResource);
		this.resourcesContext.add(driverResource);
		this.resourcesContext.add(missionResource);
	}
}
