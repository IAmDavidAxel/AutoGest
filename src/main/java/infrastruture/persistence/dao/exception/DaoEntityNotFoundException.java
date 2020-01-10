package infrastruture.persistence.dao.exception;

public class DaoEntityNotFoundException extends Exception {

	public DaoEntityNotFoundException(){
		super("L'entité que vous cherchez n'existe pas dans notre  base de données");
	}
}
