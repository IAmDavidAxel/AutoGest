package domain.mission;

import java.util.UUID;

public class MissionId {

	private String id;

	public MissionId(){

		this.id = generateFromString();
	}

	private String generateFromString() {

		return UUID.randomUUID().toString();

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
