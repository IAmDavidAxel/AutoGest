package infrastruture.persistence.dao.builder;



import infrastruture.persistence.dao.exception.DaoEntityNotFoundException;
import infrastruture.persistence.dao.exception.DaoInternalException;
import infrastruture.persistence.entitymanager.sqlite.SqliteConnection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqliteBuilder {

	private StringBuilder query;
	private ArrayList<Object> arguments;
	private Action action;
	private SqliteConnection connection;

	public SqliteBuilder(SqliteConnection connection) {
		this.connection = connection;
		query = new StringBuilder();
		arguments = new ArrayList<>();
	}

	public SqliteBuilder SelectCount() {
		action = Action.SELECT;
		query.append("SELECT COUNT(*) AS row_count ");

		return this;
	}

	public SqliteBuilder Select(String... columns) {
		action = Action.SELECT;
		query.append("SELECT ");
		for (int i = 0; i < columns.length; i++) {
			query.append(columns[i]);
			query.append(", ");
		}
		query.deleteCharAt(query.length() - 2);

		return this;
	}

	public SqliteBuilder SelectAll() {
		action = Action.SELECT;
		query.append("SELECT * ");

		return this;
	}

	public SqliteBuilder Update(String table) {
		action = Action.UPDATE;
		query.append("UPDATE ");
		query.append(table);
		query.append(" SET ");

		return this;
	}

	public SqliteBuilder Delete() {
		action = Action.DELETE;
		query.append("DELETE ");

		return this;
	}

	public SqliteBuilder ReplaceInto(String table) {
		action = Action.REPLACE;
		query.append("REPLACE INTO ");
		query.append(table);
		query.append(" ");

		return this;
	}

	public SqliteBuilder Columns(String... columns) {
		query.append("(");
		for (int i = 0; i < columns.length; i++) {
			query.append(columns[i]);
			query.append(", ");
		}
		query.setCharAt(query.length() - 2, ')');

		return this;
	}

	public SqliteBuilder Values(Object... values) {
		if (action == Action.UPDATE) {
			query.append("= (");
		} else {
			query.append("VALUES (");
		}

		for (int i = 0; i < values.length; i++) {
			query.append("?, ");
			arguments.add(values[i]);
		}
		query.setCharAt(query.length() - 2, ')');

		return this;
	}

	public SqliteBuilder From(String table) {
		query.append("FROM ");
		query.append(table);
		query.append(" ");

		return this;
	}

	public SqliteBuilder InnerJoin(String table) {
		query.append("INNER JOIN ");
		query.append(table);
		query.append(" ");

		return this;
	}

	public SqliteBuilder On(String columnName, String operator, String secondColumnName) {
		query.append("ON ");
		query.append(columnName);
		query.append(" ");
		query.append(operator);
		query.append(" ");
		query.append(secondColumnName);
		query.append(" ");

		return this;
	}

	public SqliteBuilder Where(String columnName, String operator, Object value) {
		query.append("WHERE ");
		query.append(columnName);
		query.append(" ");
		query.append(operator);
		query.append(" ? ");
		arguments.add(value);

		return this;
	}

	public int FetchCount() throws DaoInternalException {
		query.append(";");
		List<Map<String, Object>> results = executeQuery();
		int count = (int) results.get(0).get("row_count");

		return count;
	}

	public Map<String, Object> FetchOne() throws DaoInternalException, DaoEntityNotFoundException {
		query.append(";");
		List<Map<String, Object>> results = executeQuery();

		if (results.isEmpty()) {
			throw new DaoEntityNotFoundException();
		}

		return results.get(0);
	}

	public List<Map<String, Object>> FetchAll() throws DaoInternalException, DaoEntityNotFoundException {
		query.append(";");
		List<Map<String, Object>> results = executeQuery();

		if (results.isEmpty()) {
			throw new DaoEntityNotFoundException();
		}

		return results;
	}

	public void Execute() throws DaoInternalException {
		query.append(";");
		executeQuery();
	}

	private List<Map<String, Object>> executeQuery() throws DaoInternalException {
		try {
			PreparedStatementFactory statementFactory = new PreparedStatementFactory(connection);
			StatementSqlite statement = statementFactory.createStatement(query.toString(), arguments, action);
			List<Map<String, Object>> results = statement.execute();

			return results;
		} catch (SQLException exception) {
			Logger.getGlobal().log(Level.WARNING, exception.getMessage());
			throw new DaoInternalException();
		}
	}

}
