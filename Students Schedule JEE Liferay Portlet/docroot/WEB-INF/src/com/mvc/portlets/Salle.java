package com.mvc.portlets;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the salle database table.
 * 
 */
@Entity
public class Salle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_salle")
	private int idSalle;

	@Column(name="nom_salle")
	private String nomSalle;

	//bi-directional many-to-one association to Affectation
	@OneToMany(mappedBy="salle")
	private List<Affectation> affectations;

	public Salle() {
	}

	public int getIdSalle() {
		return this.idSalle;
	}

	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}

	public String getNomSalle() {
		return this.nomSalle;
	}

	public void setNomSalle(String room1) {
		this.nomSalle = room1;
	}

	public List<Affectation> getAffectations() {
		return this.affectations;
	}

	public void setAffectations(List<Affectation> affectations) {
		this.affectations = affectations;
	}

	public Affectation addAffectation(Affectation affectation) {
		getAffectations().add(affectation);
		affectation.setSalle(this);

		return affectation;
	}

	public Affectation removeAffectation(Affectation affectation) {
		getAffectations().remove(affectation);
		affectation.setSalle(null);

		return affectation;
	}

}