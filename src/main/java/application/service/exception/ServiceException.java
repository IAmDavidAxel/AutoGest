package application.service.exception;

@SuppressWarnings("serial")
public class ServiceException extends Exception {

	public ServiceException() {
	}

	public ServiceException(Throwable throwable) {
		super(throwable);
	}

	public ServiceException(String message) {
		super(message);
	}
}
