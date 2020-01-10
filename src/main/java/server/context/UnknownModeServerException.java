package server.context;

public class UnknownModeServerException extends RuntimeException {

	public UnknownModeServerException() {
		super("Unknown running mode.");
	}
}
