package org.techhub.customeException;

public class StateException extends RuntimeException {
	private String massage;

	public StateException(String massage) {
		this.massage = massage;
	}

	public String getMassage() {
		return massage;
	}

}
