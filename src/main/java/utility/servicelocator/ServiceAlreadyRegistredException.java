package utility.servicelocator;

public class ServiceAlreadyRegistredException extends RuntimeException{

	public ServiceAlreadyRegistredException(){
		super("the provided service is already registered");
	}
}
