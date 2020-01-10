package application.service.exception;

public class PersistenceInternalServiceException extends ServiceException {

	public PersistenceInternalServiceException(){

		super("Une erreur interne de persistence s'est produite ");
	}
}
