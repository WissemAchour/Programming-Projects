package com.mvc.portlets;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the affectation database table.
 * 
 */

public class AffectationPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_affectation")
	private int idAffectation;

	@Column(name="id_sous_groupe")
	private int idSousGroupe;

	@Column(name="id_enseignant")
	private int idEnseignant;

	@Column(name="id_seance")
	private int idSeance;

	@Column(name="id_matiere")
	private int idMatiere;

	@Column(name="id_salle")
	private int idSalle;

	public AffectationPK() {
	}
	public int getIdAffectation() {
		return this.idAffectation;
	}
	public void setIdAffectation(int idAffectation) {
		this.idAffectation = idAffectation;
	}
	public int getIdSousGroupe() {
		return this.idSousGroupe;
	}
	public void setIdSousGroupe(int idSousGroupe) {
		this.idSousGroupe = idSousGroupe;
	}
	public int getIdEnseignant() {
		return this.idEnseignant;
	}
	public void setIdEnseignant(int idEnseignant) {
		this.idEnseignant = idEnseignant;
	}
	public int getIdSeance() {
		return this.idSeance;
	}
	public void setIdSeance(int idSeance) {
		this.idSeance = idSeance;
	}
	public int getIdMatiere() {
		return this.idMatiere;
	}
	public void setIdMatiere(int idMatiere) {
		this.idMatiere = idMatiere;
	}
	public int getIdSalle() {
		return this.idSalle;
	}
	public void setIdSalle(int idSalle) {
		this.idSalle = idSalle;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AffectationPK)) {
			return false;
		}
		AffectationPK castOther = (AffectationPK)other;
		return 
			(this.idAffectation == castOther.idAffectation)
			&& (this.idSousGroupe == castOther.idSousGroupe)
			&& (this.idEnseignant == castOther.idEnseignant)
			&& (this.idSeance == castOther.idSeance)
			&& (this.idMatiere == castOther.idMatiere)
			&& (this.idSalle == castOther.idSalle);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idAffectation;
		hash = hash * prime + this.idSousGroupe;
		hash = hash * prime + this.idEnseignant;
		hash = hash * prime + this.idSeance;
		hash = hash * prime + this.idMatiere;
		hash = hash * prime + this.idSalle;
		
		return hash;
	}
}