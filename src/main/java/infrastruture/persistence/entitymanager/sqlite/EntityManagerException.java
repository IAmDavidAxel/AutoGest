package infrastruture.persistence.entitymanager.sqlite;

public class EntityManagerException extends Exception {

	public EntityManagerException() {
		super("An internal persistence transaction error occured.");
	}

}
