package com.mvc.portlets;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the message database table.
 * 
 */
@Entity
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String val;

	public Message() {
	}

	public String getVal() {
		return this.val;
	}

	public void setVal(String txt) {
		this.val = txt;
	}

}