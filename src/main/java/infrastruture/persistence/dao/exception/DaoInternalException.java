package infrastruture.persistence.dao.exception;

public class DaoInternalException extends Exception {

	public DaoInternalException(){
		super("Une Erreur interne a occuré");
	}
}
