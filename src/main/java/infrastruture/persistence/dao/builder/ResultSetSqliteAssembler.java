package infrastruture.persistence.dao.builder;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultSetSqliteAssembler {

	public List<Map<String, Object>> assemble(ResultSet resultSet) throws SQLException {
		ArrayList<Map<String, Object>> results = new ArrayList<>();

		if (results != null) {
			Map<String, Object> row;
			while (resultSet.next()) {
				row = assembleRow(resultSet);
				results.add(row);
			}
		}

		return results;
	}

	private Map<String, Object> assembleRow(ResultSet resultSet) throws SQLException {
		ResultSetMetaData metadata = resultSet.getMetaData();
		int numberOfColumns = metadata.getColumnCount();

		Map<String, Object> row = new HashMap<>();
		String columnName;
		Object columnValue;
		for (int i = 1; i <= numberOfColumns; i++) {
			columnName = metadata.getColumnName(i);
			columnValue = resultSet.getObject(i);
			row.put(columnName, columnValue);
		}

		return row;
	}

}
