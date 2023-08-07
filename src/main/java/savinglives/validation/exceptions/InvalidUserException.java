package savinglives.validation.exceptions;

public class InvalidUserException extends Exception {
	
	private static final long serialVersionUID = -18634831824752441L;

	public InvalidUserException(String msg) {
		super(msg);
	}
	
	public InvalidUserException (Throwable e) {
		super(e);
	}
	public InvalidUserException (String msg,Throwable e) {
		super(msg,e);
	}
	
}