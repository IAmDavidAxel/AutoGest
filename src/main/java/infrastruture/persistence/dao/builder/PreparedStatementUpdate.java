package infrastruture.persistence.dao.builder;



import infrastruture.persistence.entitymanager.sqlite.SqliteConnection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PreparedStatementUpdate extends PreparedStatementSqlite {

	public PreparedStatementUpdate(SqliteConnection connection, String query, ArrayList<Object> arguments) {
		super(connection, query, arguments);
	}

	public List<Map<String, Object>> execute() throws SQLException {
		statement.executeUpdate();
		closeStatement();

		return null;
	}

}
