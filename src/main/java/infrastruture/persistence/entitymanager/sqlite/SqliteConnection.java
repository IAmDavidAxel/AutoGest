package infrastruture.persistence.entitymanager.sqlite;

import org.sqlite.SQLiteConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqliteConnection {

	private static final String SQLITE_DRIVER = "jdbc:sqlite:";

	private String databaseName;
	private Connection connection;

	public SqliteConnection(String databaseName) {
		this.databaseName = databaseName;
		initialiseConnection();
	}

	private void initialiseConnection() {
		SQLiteConfig config = new SQLiteConfig();
		config.enforceForeignKeys(true);
		String connectionUrl = buildUrl();

		try {
			connection = DriverManager.getConnection(connectionUrl, config.toProperties());
		} catch (SQLException exception) {
			Logger.getGlobal().log(Level.SEVERE, exception.getMessage());
		}
	}

	private String buildUrl() {
		return SQLITE_DRIVER + databaseName;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setAutoCommitTo(boolean isAtoCommitOn) throws SqliteConnectionException {
		try {
			connection.setAutoCommit(isAtoCommitOn);
		} catch (SQLException exception) {
			Logger.getGlobal().log(Level.WARNING, exception.getMessage());
			throw new SqliteConnectionException();
		}
	}

	public void commit() throws SqliteConnectionException {
		try {
			connection.commit();
		} catch (SQLException exception) {
			Logger.getGlobal().log(Level.WARNING, exception.getMessage());
			throw new SqliteConnectionException();
		}
	}

	public void rollBack() throws SqliteConnectionException {
		try {
			connection.rollback();
		} catch (SQLException exception) {
			Logger.getGlobal().log(Level.WARNING, exception.getMessage());
			throw new SqliteConnectionException();
		}
	}

}
