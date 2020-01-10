package infrastruture.persistence.dao.builder;


import infrastruture.persistence.entitymanager.sqlite.SqliteConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class PreparedStatementSqlite implements StatementSqlite {

	protected Connection connection;
	protected PreparedStatement statement;

	public PreparedStatementSqlite(SqliteConnection connection, String query, ArrayList<Object> arguments) {
		this.connection = connection.getConnection();
		initializeStatement(query);
		setArguments(arguments);
	}

	@Override
	public abstract List<Map<String, Object>> execute() throws SQLException;

	private void initializeStatement(String query) {
		try {
			statement = connection.prepareStatement(query);
		} catch (SQLException exception) {
			Logger.getGlobal().log(Level.WARNING, exception.getMessage());
		}
	}

	private void setArguments(ArrayList<Object> arguments) {
		try {
			for (int i = 0; i < arguments.size(); i++) {
				statement.setObject(i + 1, arguments.get(i));
			}
		} catch (SQLException exception) {
			Logger.getGlobal().log(Level.WARNING, exception.getMessage());
		}
	}

	public void close(ResultSet resultSet) {
		try {
			resultSet.close();
		} catch (SQLException exception) {
			Logger.getGlobal().log(Level.FINEST, exception.getMessage());
		}
	}

	public void closeStatement() {
		try {
			statement.close();
		} catch (SQLException exception) {
			Logger.getGlobal().log(Level.FINEST, exception.getMessage());
		}
	}

}
