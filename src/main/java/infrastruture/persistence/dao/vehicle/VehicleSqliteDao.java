package infrastruture.persistence.dao.vehicle;

import infrastruture.persistence.dao.builder.SqliteBuilder;
import infrastruture.persistence.dao.exception.DaoInternalException;
import infrastruture.persistence.dto.vehicle.VehicleDto;
import infrastruture.persistence.entitymanager.sqlite.SqliteConnection;

public class VehicleSqliteDao implements VehicleDao {

	private SqliteConnection sqliteConnection;

	public VehicleSqliteDao (SqliteConnection connection){
		this.sqliteConnection = connection;
	}

	@Override
	public void save(VehicleDto vehicleDto) throws DaoInternalException {
		SqliteBuilder sqliteBuilder = new SqliteBuilder(sqliteConnection);

		sqliteBuilder.ReplaceInto("vehicle")
				.Columns("vehicle_id","color","model","type","plate_number")
				.Values(vehicleDto.getId(),
						vehicleDto.getColor(),
						vehicleDto.getModel(),
						vehicleDto.getType(),
						vehicleDto.getPlateNumber())
				.Execute();

	}
}
