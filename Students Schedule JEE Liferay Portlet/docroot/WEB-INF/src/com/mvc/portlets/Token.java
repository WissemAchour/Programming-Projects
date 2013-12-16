package com.mvc.portlets;

public class Token {
	private String value;
	private TokenType type;
	public Token(String value,TokenType type) {
		this.value=value;
		this.type=type;
	}
	public TokenType getType() {
		return type;
	}
	public String getValue() {
		return value;
	}
	//@Override
	/*public String toString() {
		return "Token [value=" + value + ", type=" + type + "]";
	}*/
	
	
}
