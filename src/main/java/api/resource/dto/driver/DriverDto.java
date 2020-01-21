package api.resource.dto.driver;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.glassfish.jersey.server.JSONP;

public class DriverDto {

	@JsonProperty(value = "first_name", access = JsonProperty.Access.READ_WRITE)
	private String firstName;

	@JsonProperty(value = "last_name", access = JsonProperty.Access.READ_WRITE)
	private String lastName;

	@JsonProperty(value = "id_number", access = JsonProperty.Access.READ_WRITE)
	private String idNumber;

	@JsonProperty(value = "cell_phone_number", access = JsonProperty.Access.READ_WRITE)
	private String cellPhoneNumber;

	@JsonProperty(value = "birth_date", access = JsonProperty.Access.READ_WRITE)
	private String birthDate;

	@JsonProperty(value = "driver_licence_number", access = JsonProperty.Access.READ_WRITE)
	private String driverLicenceNumber;



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setDriverLicenceNumber(String driverLicenceNumber) {
		this.driverLicenceNumber = driverLicenceNumber;
	}

	public String getDriverLicenceNumber() {
		return driverLicenceNumber;
	}

	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}

	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthDate() {
		return birthDate;
	}
}
