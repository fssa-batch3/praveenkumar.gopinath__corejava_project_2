package com.fssa.savinglives.validation.exceptions;

public class InvalideDonorRegisterException extends Exception  {
	
	private static final long serialVersionUID = -1L;
	
	public InvalideDonorRegisterException(String msg) {
		super(msg);
	}

	public InvalideDonorRegisterException(Throwable e) {
		super(e);
	}

	public InvalideDonorRegisterException(String msg, Throwable e) {
		super(msg, e);
	}

}
