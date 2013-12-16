package com.mvc.portlets;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the matiere database table.
 * 
 */
@Entity
public class Matiere implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_matiere")
	private int idMatiere;

	@Column(name="nom_matiere")
	private String nomMatiere;

	//bi-directional many-to-one association to Affectation
	@OneToMany(mappedBy="matiere")
	private List<Affectation> affectations;

	public Matiere() {
	}

	public int getIdMatiere() {
		return this.idMatiere;
	}

	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}

	public String getNomMatiere() {
		return this.nomMatiere;
	}

	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}

	public List<Affectation> getAffectations() {
		return this.affectations;
	}

	public void setAffectations(List<Affectation> affectations) {
		this.affectations = affectations;
	}

	public Affectation addAffectation(Affectation affectation) {
		getAffectations().add(affectation);
		affectation.setMatiere(this);

		return affectation;
	}

	public Affectation removeAffectation(Affectation affectation) {
		getAffectations().remove(affectation);
		affectation.setMatiere(null);

		return affectation;
	}

}