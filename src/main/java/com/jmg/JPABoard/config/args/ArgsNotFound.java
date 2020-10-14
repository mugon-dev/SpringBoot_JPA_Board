package com.jmg.JPABoard.config.args;

public class ArgsNotFound extends Exception {

	private String message;

	public  ArgsNotFound(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

}
