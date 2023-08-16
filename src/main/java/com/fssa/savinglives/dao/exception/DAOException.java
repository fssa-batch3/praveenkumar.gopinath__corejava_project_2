package com.fssa.savinglives.dao.exception;

public class DAOException extends Exception {
	private static final long serialVersionUID = 424307628927676856L;
	public DAOException(String msg) {
		super(msg);
	}

	public DAOException(Throwable e) {
		super(e);
	}

	public DAOException(String msg, Throwable e) {
		super(msg, e);
	}

}