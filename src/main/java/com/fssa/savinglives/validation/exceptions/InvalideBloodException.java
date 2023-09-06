package com.fssa.savinglives.validation.exceptions;

public class InvalideBloodException extends Exception {
	/**
	 * 
	 */
 private static final long serialVersionUID = 1L;
	public InvalideBloodException(String msg) {
		super(msg);
	}

	public InvalideBloodException(Throwable e) {
		super(e);
	}

	public InvalideBloodException(String msg, Throwable e) {
		super(msg, e);
	}
}
