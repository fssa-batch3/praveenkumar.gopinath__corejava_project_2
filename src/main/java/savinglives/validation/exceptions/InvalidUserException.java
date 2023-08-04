package savinglives.validation.exceptions;

public class InvalidUserException extends Exception {
	
	private static final long serialVersionUID = 8637911405840287143L;

	public InvalidUserException(String msg) {
		super(msg);
	}

	public InvalidUserException(Throwable e) {
		super(e);
	}
}