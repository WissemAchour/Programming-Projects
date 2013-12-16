package com.mvc.portlets;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the seance database table.
 * 
 */
@Entity
public class Seance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_seance")
	private int idSeance;

	private String heure;

	private String jour;

	//bi-directional many-to-one association to Affectation
	@OneToMany(mappedBy="seance")
	private List<Affectation> affectations;

	public Seance() {
	}

	public int getIdSeance() {
		return this.idSeance;
	}

	public void setIdSeance(int idSeance) {
		this.idSeance = idSeance;
	}

	public String getHeure() {
		return this.heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}

	public String getJour() {
		return this.jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public List<Affectation> getAffectations() {
		return this.affectations;
	}

	public void setAffectations(List<Affectation> affectations) {
		this.affectations = affectations;
	}

	public Affectation addAffectation(Affectation affectation) {
		getAffectations().add(affectation);
		affectation.setSeance(this);

		return affectation;
	}

	public Affectation removeAffectation(Affectation affectation) {
		getAffectations().remove(affectation);
		affectation.setSeance(null);

		return affectation;
	}

}