package exceptions;

public class InvalidParamsException extends RuntimeException {

	private static final long serialVersionUID = -7032223839521406039L;

	public InvalidParamsException(String message) {
		super(message);
	}

}
