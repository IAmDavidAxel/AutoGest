package application.service.exception;

@SuppressWarnings("serial")
public class VehicleNotFoundServiceException extends ServiceException {

	public VehicleNotFoundServiceException(){
		super("le vehicule recherché n'existe pas dans notre base ");
	}
}
