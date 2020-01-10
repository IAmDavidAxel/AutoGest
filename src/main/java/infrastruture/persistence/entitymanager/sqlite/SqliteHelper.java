package infrastruture.persistence.entitymanager.sqlite;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqliteHelper {

	public static void close(PreparedStatement preparedStatement) {
		if (preparedStatement != null) {
			try {
				if (!preparedStatement.isClosed()) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
			}
		}
	}

	public static void close(Statement statement) {
		if (statement != null) {
			try {
				if (!statement.isClosed()) {
					statement.close();
				}
			} catch (SQLException e) {
			}
		}
	}

	public static void close(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				if (!resultSet.isClosed()) {
					resultSet.close();
				}
			} catch (SQLException e) {
			}
		}
	}

}
