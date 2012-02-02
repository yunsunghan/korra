package com.ks.code.core.exception;

@SuppressWarnings("serial")
public class IdNotFoundException extends Exception {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public IdNotFoundException(String msg) {
		super("존재하지 않은 Key 입니다.");
		this.msg = msg;
	}
}
