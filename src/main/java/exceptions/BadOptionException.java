package exceptions;

/**
 * This exception is lunched when a command receive a bar option
 * 
 * @author marcelo
 *
 */
public class BadOptionException extends RuntimeException {

	private static final long serialVersionUID = -5525904357156149848L;

	private String badOption;

	public BadOptionException(String badOption) {
		super();
		this.badOption = badOption;
	}

	public String getBadOption() {
		return badOption;
	}

	public void setBadOption(String badOption) {
		this.badOption = badOption;
	}

}
