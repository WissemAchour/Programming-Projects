package com.mvc.portlets;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
public class Users implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String name;

	private String classe;

	public Users() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClasse() {
		return this.classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

}