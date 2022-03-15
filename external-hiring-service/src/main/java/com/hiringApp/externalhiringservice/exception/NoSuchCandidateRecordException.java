package com.hiringApp.externalhiringservice.exception;

public class NoSuchCandidateRecordException extends RuntimeException{
String msg;
	
	

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchCandidateRecordException(String message) {
		this.msg=message;
	}
}
