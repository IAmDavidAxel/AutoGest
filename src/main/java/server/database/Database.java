package server.database;

import infrastruture.persistence.entitymanager.sqlite.SqliteConnection;
import utility.datamanager.ApplicationConfiguration;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

	private String schema;
	private Connection connection;

	public void createDatabase(String databaseName){
		try{
			loadSchema();
			initialiseConnection(databaseName);
			executeSchema();
		}catch (IOException  |SQLException exception){
			Logger.getGlobal().log(Level.SEVERE,exception.getMessage());
		}
	}

	private void loadSchema() throws IOException {
		byte []  encodedFile = Files.readAllBytes(Paths.get(ApplicationConfiguration.sqliteSchemaFileName));
		schema= new String(encodedFile , StandardCharsets.UTF_8);

	}

	private void executeSchema() throws SQLException {
		Statement statement = connection.createStatement();
		statement.executeUpdate(schema);
		statement.close();
	}

	private void initialiseConnection(String databaseName) {
		SqliteConnection sqliteConnection = new SqliteConnection(databaseName);

		connection =sqliteConnection.getConnection();
	}

	public void deleteDatabase(String databaseName) throws IOException {
		closeConnection();
		Files.deleteIfExists(Paths.get(databaseName));
	}

	private void closeConnection() {
		try{
			connection.close();
		}catch (SQLException exception){
			Logger.getGlobal().log(Level.WARNING,exception.getMessage());
		}
	}

}
