package infrastruture.persistence.dao.mission;

import infrastruture.persistence.dao.builder.SqliteBuilder;
import infrastruture.persistence.dao.exception.DaoInternalException;
import infrastruture.persistence.dto.mission.MissionDto;
import infrastruture.persistence.entitymanager.sqlite.SqliteConnection;

public class MissionSqliteDao implements MissionDao {

	private SqliteConnection sqliteConnection;

	public MissionSqliteDao(SqliteConnection connection){
		this.sqliteConnection = connection;
	}

	@Override
	public void save(MissionDto missionDto) throws DaoInternalException {
		SqliteBuilder sqliteBuilder = new SqliteBuilder(sqliteConnection);

		sqliteBuilder.ReplaceInto("mission")
				.Columns("mission_id","mission_order_number","driver_id","vehicle_id","transport_mean","mission_location","mission_start","mission_end","mission_object","accompany_with")
				.Values(missionDto.getMissionId(),
						missionDto.getOrderNumber(),
						missionDto.getAssociatedDriverName(),
						missionDto.getVehiclePlateNumber(),
						missionDto.getMeanOfTransport(),
						missionDto.getLocation(),
						missionDto.getMissionStartDate(),
						missionDto.getMissionEndDate(),
						missionDto.getMissionDescription(),
						missionDto.getDriverCompanion())
				.Execute();

	}
}
