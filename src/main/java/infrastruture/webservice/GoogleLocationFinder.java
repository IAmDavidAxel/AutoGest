//package infrastruture.webservice;
//
//import com.google.maps.*;
//import com.google.maps.errors.ApiException;
//import domain.coordinates.Coordinates;
//
//import java.io.IOException;
//
//public class GoogleLocationFinder {
//
//
//	private GeoApiContext geoApiContext;
//
//	public GoogleLocationFinder(GeoApiContext geoApiContext){
//		this.geoApiContext = geoApiContext;
//	}
//
//
//	public Coordinates findLocation(int anHomeMobileCountryCode, int aMobileNetworkCode, String aRadioType, String aCarrier, boolean anIp) {
//		try{
//			GeolocationApiRequest request = buildLocationRequest(anHomeMobileCountryCode,aMobileNetworkCode,aRadioType,aCarrier,anIp);
//		}
//		return null;
//	}
//
////	private GeolocationApiRequest buildLocationRequest(int anHomeMobileCountryCode, int aMobileNetworkCode, String aRadioType, String aCarrier, boolean anIp) {
////
////		GeolocationApiRequest request = new GeolocationApiRequest(geoApiContext);
////
////		request.HomeMobileNetworkCode(aMobileNetworkCode)
////				.HomeMobileCountryCode(anHomeMobileCountryCode)
////				.Carrier(aCarrier)
////				.ConsiderIp(anIp);
////
////
////		return request;
////
////	}
//}
