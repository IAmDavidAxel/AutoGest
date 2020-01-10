package infrastruture.persistence.dao.builder;



import infrastruture.persistence.entitymanager.sqlite.SqliteConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PreparedStatementFetch extends PreparedStatementSqlite {

	private ResultSetSqliteAssembler resultSetSqliteAssembler;

	public PreparedStatementFetch(SqliteConnection connection, String query, ArrayList<Object> arguments, ResultSetSqliteAssembler resultSetSqliteAssembler) {
		super(connection, query, arguments);
		this.resultSetSqliteAssembler = resultSetSqliteAssembler;
	}

	public List<Map<String, Object>> execute() throws SQLException {
		ResultSet resultSet = statement.executeQuery();
		List<Map<String, Object>> results = resultSetSqliteAssembler.assemble(resultSet);
		close(resultSet);
		closeStatement();

		return results;
	}

}
