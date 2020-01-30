package infrastruture.persistence.dao.driver;

import infrastruture.persistence.dao.builder.SqliteBuilder;
import infrastruture.persistence.dao.exception.DaoEntityNotFoundException;
import infrastruture.persistence.dao.exception.DaoInternalException;
import infrastruture.persistence.dto.driver.DriverDto;
import infrastruture.persistence.entitymanager.sqlite.SqliteConnection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DriverSqliteDao implements DriverDao {

	private SqliteConnection sqliteConnection;

	public DriverSqliteDao(SqliteConnection sqliteConnection) {
		this.sqliteConnection = sqliteConnection;
	}

	@Override
	public void save(DriverDto driverDto) throws DaoInternalException {
		SqliteBuilder sqliteBuilder = new SqliteBuilder(sqliteConnection);

		sqliteBuilder.ReplaceInto("driver")
				.Columns("user_id","first_name","last_name","id_number","cell_phone_number","birth_date","driver_licence_number")
				.Values(driverDto.getUserId(),
						driverDto.getFirstName(),
						driverDto.getLastName(),
						driverDto.getIdNumber(),
						driverDto.getCellPhoneNumber(),
						driverDto.getBirthDate(),
						driverDto.getDriverLicenceNumber())
				.Execute();
	}

	@Override
	public DriverDto findByName(String name) throws DaoInternalException, DaoEntityNotFoundException {

		SqliteBuilder sqliteBuilder = new SqliteBuilder(sqliteConnection);

		Map<String,Object> results = sqliteBuilder.
				SelectAll()
				.From("driver")
				.Where("first_name" ,"=",name)
				.FetchOne();

		return createDriverDto(results);
	}

	@Override
	public List<DriverDto> findListByName(String aName) throws DaoInternalException, DaoEntityNotFoundException {
		SqliteBuilder sqliteBuilder = new SqliteBuilder(sqliteConnection);

		List<Map<String, Object>> results = sqliteBuilder
				.SelectAll()
				.From("driver")
				.Where("first_name","=", aName)
				.FetchAll();

		List<DriverDto> drivers = new ArrayList<>();
		for (Map<String, Object> result: results){
			DriverDto driverDto = createDriverDto(result);
			drivers.add(driverDto);
		}

		return drivers;
	}

	private DriverDto createDriverDto(Map<String, Object> result) {
		String userId = (String) result.get("user_id");
		String firstName = (String) result.get("first_name");
		String lastName = (String) result.get("last_name");
		String idNumber = (String) result.get("id_number");
		String cellPhoneNumber = (String) result.get("cell_phone_number");
		String birthDate = (String) result.get("birth_date");
		String driverLicenceNumber  = (String) result.get("driver_licence_number");

		DriverDto driverDto = new DriverDto();
		driverDto.setUserId(userId);
		driverDto.setFirstName(firstName);
		driverDto.setLastName(lastName);
		driverDto.setIdNumber(idNumber);
		driverDto.setCellPhoneNumber(cellPhoneNumber);
		driverDto.setBirthDate(birthDate);
		driverDto.setDriverLicenceNumber(driverLicenceNumber);

		return driverDto;
	}
}
