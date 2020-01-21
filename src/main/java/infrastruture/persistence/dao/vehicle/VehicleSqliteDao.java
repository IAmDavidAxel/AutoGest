package infrastruture.persistence.dao.vehicle;

import infrastruture.persistence.dao.builder.SqliteBuilder;
import infrastruture.persistence.dao.exception.DaoEntityNotFoundException;
import infrastruture.persistence.dao.exception.DaoInternalException;
import infrastruture.persistence.dto.vehicle.VehicleDto;
import infrastruture.persistence.entitymanager.sqlite.SqliteConnection;

import java.util.Map;

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

	@Override
	public VehicleDto find(String aPlateNumber) throws DaoEntityNotFoundException, DaoInternalException {

		SqliteBuilder sqliteBuilder = new SqliteBuilder(sqliteConnection);

		Map<String, Object> results = sqliteBuilder.SelectAll()
				.From("vehicle")
				.Where("plate_number","=",aPlateNumber)
				.FetchOne();
		return createVehicleDto(results);
	}

	private VehicleDto createVehicleDto(Map<String, Object> results) {

		String id = (String) results.get("vehicle_id");
		String plateNumber = (String) results.get("plate_number");
		String color = (String) results.get("color");
		String type = (String) results.get("type");

		VehicleDto vehicleDto = new VehicleDto();

		vehicleDto.setId(id);
		vehicleDto.setPlateNumber(plateNumber);
		vehicleDto.setColor(color);
		vehicleDto.setType(type);

		return vehicleDto;
	}
}
