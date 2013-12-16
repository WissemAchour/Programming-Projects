package com.mvc.portlets;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the enseignant database table.
 * 
 */
@Entity
public class Enseignant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_enseignant")
	private int idEnseignant;

	@Column(name="nom_enseignant")
	private String nomEnseignant;

	//bi-directional many-to-one association to Affectation
	@OneToMany(mappedBy="enseignant")
	private List<Affectation> affectations;

	public Enseignant() {
	}

	public int getIdEnseignant() {
		return this.idEnseignant;
	}

	public void setIdEnseignant(int idEnseignant) {
		this.idEnseignant = idEnseignant;
	}

	public String getNomEnseignant() {
		return this.nomEnseignant;
	}

	public void setNomEnseignant(String nomEnseignant) {
		this.nomEnseignant = nomEnseignant;
	}

	public List<Affectation> getAffectations() {
		return this.affectations;
	}

	public void setAffectations(List<Affectation> affectations) {
		this.affectations = affectations;
	}

	public Affectation addAffectation(Affectation affectation) {
		getAffectations().add(affectation);
		affectation.setEnseignant(this);

		return affectation;
	}

	public Affectation removeAffectation(Affectation affectation) {
		getAffectations().remove(affectation);
		affectation.setEnseignant(null);

		return affectation;
	}

}