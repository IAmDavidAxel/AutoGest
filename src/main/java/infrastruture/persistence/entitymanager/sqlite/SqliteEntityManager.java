package infrastruture.persistence.entitymanager.sqlite;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SqliteEntityManager {

	private SqliteConnection connection;

	public SqliteEntityManager(SqliteConnection sqliteConnection) {
		this.connection = sqliteConnection;
	}

	public void beginTransaction() throws EntityManagerException {
		try {
			connection.setAutoCommitTo(false);
		} catch (SqliteConnectionException exception) {
			Logger.getGlobal().log(Level.WARNING, exception.getMessage());
			throw new EntityManagerException();
		}
	}

	public void endTransaction() throws EntityManagerException {
		try {
			connection.commit();
		} catch (SqliteConnectionException exception) {
			Logger.getGlobal().log(Level.WARNING, exception.getMessage());
			throw new EntityManagerException();
		} finally {
			setAutoCommitOn();
		}
	}

	public void rollBack() {
		try {
			connection.rollBack();
		} catch (SqliteConnectionException exception) {
			Logger.getGlobal().log(Level.WARNING, exception.getMessage());
		} finally {
			setAutoCommitOn();
		}
	}

	private void setAutoCommitOn() {
		try {
			connection.setAutoCommitTo(true);
		} catch (SqliteConnectionException exception) {
			Logger.getGlobal().log(Level.WARNING, exception.getMessage());
		}
	}

}
