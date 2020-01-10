package infrastruture.persistence.exception;

@SuppressWarnings("serial")
public class PersistenseInternalException extends Exception {

	public PersistenseInternalException(){
		super("Une erreur de persistence s'est produite");
	}
}
