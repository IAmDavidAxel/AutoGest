package application.service.user.driver;

import java.util.UUID;

public class UserId {

	private String idValue;

	public UserId() {
		generateId();
	}

	private void generateId() {
		idValue = UUID.randomUUID().toString();
	}

	public UserId(String idValue) {
		this.idValue = idValue;
	}

	public String getIdValue() {
		return idValue;
	}

	public void setIdValue(String idValue) {
		this.idValue = idValue;
	}
}
