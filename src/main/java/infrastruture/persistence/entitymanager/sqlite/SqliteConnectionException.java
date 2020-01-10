package infrastruture.persistence.entitymanager.sqlite;

public class SqliteConnectionException extends Exception {

	public SqliteConnectionException() {
		super("An internal persistence connection error occured.");
	}

}
