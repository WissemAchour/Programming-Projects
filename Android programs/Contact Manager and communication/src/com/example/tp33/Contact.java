package com.example.tp33;

public class Contact {

	
	private String nom;
	private String tel;
	private String email;
	
	public Contact(){
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact [nom=" + nom + ", tel=" + tel + ", email=" + email
				+ "]";
	}
	
	
	
	
}
