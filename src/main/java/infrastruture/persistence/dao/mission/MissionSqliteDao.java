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


	}
}
