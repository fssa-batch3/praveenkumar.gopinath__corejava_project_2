package com.fssa.savinglives.validation.exceptions;

public class InvalidRequestException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6303953742446429291L;

	public InvalidRequestException(String msg) {
		super(msg);
	}

	public InvalidRequestException(Throwable e) {
		super(e);
	}

	public InvalidRequestException(String msg, Throwable e) {
		super(msg, e);
	}

}