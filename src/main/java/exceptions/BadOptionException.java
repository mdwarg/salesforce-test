package exceptions;

/**
 * This exception is lunched when a command receive a bar option
 * 
 * @author marcelo
 *
 */
public class BadOptionException extends RuntimeException {

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
