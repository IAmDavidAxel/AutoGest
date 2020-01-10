package utility.datamanager;

public class ApplicationConfiguration {

	/**
	 * Properties files
	 */
	public static final String PROPERTIES_FILE_NAME = "autogest.properties";

	/**
	 * Application general properties files
	 */
	public static String mode;
	public static int serverPort;

	/**
	 * Data Base configuration
	 */
	public static String sqliteDbName;
	public static String testSqliteDbName;
	public static String sqliteSchemaFileName;

	/**
	 * Google Maps Service configuration variables
	 *
	 */
	public static String mapsApiKey;

}
