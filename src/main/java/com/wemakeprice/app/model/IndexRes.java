package com.wemakeprice.app.model;

public class IndexRes {
	
	
	private String quotient;
	private String remainder;
	
	public IndexRes(int line, String result) {
		if(result.length() >= line) {
			this.setQuotient(result.substring(0, line));
			this.setRemainder(result.substring(line, result.length()));
		}
		else {
			this.setQuotient("");
			this.setRemainder(result);
		}
	}
	
	public String getQuotient() {
		return quotient;
	}
	public void setQuotient(String quotient) {
		this.quotient = quotient;
	}
	public String getRemainder() {
		return remainder;
	}
	public void setRemainder(String remainder) {
		this.remainder = remainder;
	}
}
