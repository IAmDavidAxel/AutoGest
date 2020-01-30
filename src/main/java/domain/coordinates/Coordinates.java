package domain.coordinates;

import java.math.BigDecimal;

public class Coordinates {

	private BigDecimal latitude;
	private BigDecimal longitude;

	public Coordinates(BigDecimal latitude, BigDecimal longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}
}
