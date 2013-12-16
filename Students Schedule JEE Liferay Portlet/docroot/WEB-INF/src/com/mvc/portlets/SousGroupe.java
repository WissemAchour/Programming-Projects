package com.mvc.portlets;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sous_groupe database table.
 * 
 */
@Entity
@Table(name="sous_groupe")
public class SousGroupe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_sous_groupe")
	private int idSousGroupe;

	@Column(name="nom_sous_groupe")
	private String nomSousGroupe;

	//bi-directional many-to-one association to Affectation
	@OneToMany(mappedBy="sousGroupe")
	private List<Affectation> affectations;

	public SousGroupe() {
	}

	public int getIdSousGroupe() {
		return this.idSousGroupe;
	}

	public void setIdSousGroupe(int idSousGroupe) {
		this.idSousGroupe = idSousGroupe;
	}

	public String getNomSousGroupe() {
		return this.nomSousGroupe;
	}

	public void setNomSousGroupe(String nomSousGroupe) {
		this.nomSousGroupe = nomSousGroupe;
	}

	public List<Affectation> getAffectations() {
		return this.affectations;
	}

	public void setAffectations(List<Affectation> affectations) {
		this.affectations = affectations;
	}

	public Affectation addAffectation(Affectation affectation) {
		getAffectations().add(affectation);
		affectation.setSousGroupe(this);

		return affectation;
	}

	public Affectation removeAffectation(Affectation affectation) {
		getAffectations().remove(affectation);
		affectation.setSousGroupe(null);

		return affectation;
	}

}