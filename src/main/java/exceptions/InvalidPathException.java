package exceptions;

public class InvalidPathException extends RuntimeException {

	private static final long serialVersionUID = -7174402047229210819L;

	public InvalidPathException() {
		super();
	}

	public InvalidPathException(String message) {
		super(message);
	}

}
