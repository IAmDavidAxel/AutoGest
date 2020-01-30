//package infrastruture.webservice;
//
//import com.google.maps.GeolocationApi;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.runners.MockitoJUnitRunner;
//import server.PropertyConfiguration;
//import utility.datamanager.ApplicationConfiguration;
//
//import static org.junit.Assert.*;
//
//@RunWith(MockitoJUnitRunner.class)
//public class GoogleLocationFinderTest {
//
//	private static final int AN_HOME_MOBILE_COUNTRY_CODE = 613;
//	private static final int A_MOBILE_NETWORK_CODE = 1;
//	private static final String A_RADIO_TYPE = "LTE";
//	private static final String A_CARRIER = "Telmob";
//	private static final boolean AN_IP = false;
//
//	private GoogleLocationFinder googleLocationFinder;
//
//	@Mock
//	private GeolocationApi geolocationApi;
//
//	@BeforeClass
//	public static void setUpClass(){
//		initializingProperties();
//	}
//
//	@Before
//	public void setUp() throws Exception {
//		googleLocationFinder = new GoogleLocationFinder(geolocationApi);
//	}
//
//	@Test
//	public void whenAsking_then()throws Exception{
//		googleLocationFinder.findLocation(AN_HOME_MOBILE_COUNTRY_CODE,A_MOBILE_NETWORK_CODE,A_RADIO_TYPE,A_CARRIER,AN_IP);
//	}
//
//
//
//	private static void initializingProperties() {
//		PropertyConfiguration property = new PropertyConfiguration(ApplicationConfiguration.PROPERTIES_FILE_NAME);
//		property.initialize();
//		property.apply();
//	}
//}
