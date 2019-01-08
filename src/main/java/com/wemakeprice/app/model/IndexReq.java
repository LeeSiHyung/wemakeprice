package com.wemakeprice.app.model;

public class IndexReq {
	
	public final static String TEXT_TYPE = "0";
	public final static String HTML_TYPE = "1";
	
	private String url;
	private String type;
	private int line;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getLine() {
		return line;
	}
	public void setLine(int line) {
		this.line = line;
	}
	
}
