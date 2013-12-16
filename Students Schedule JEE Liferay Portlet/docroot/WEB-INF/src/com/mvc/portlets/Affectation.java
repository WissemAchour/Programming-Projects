package com.mvc.portlets;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the affectation database table.
 * 
 */
@Entity
public class Affectation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to SousGroupe
	@ManyToOne
	@JoinColumn(name="id_sous_groupe")
	private SousGroupe sousGroupe;

	//bi-directional many-to-one association to Enseignant
	@ManyToOne
	@JoinColumn(name="id_enseignant")
	private Enseignant enseignant;

	//bi-directional many-to-one association to Seance
	@ManyToOne
	@JoinColumn(name="id_seance")
	private Seance seance;

	//bi-directional many-to-one association to Matiere
	@ManyToOne
	@JoinColumn(name="id_matiere")
	private Matiere matiere;

	//bi-directional many-to-one association to Salle
	@ManyToOne
	@JoinColumn(name="id_salle")
	private Salle salle;

	public Affectation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id2) {
		this.id = id2;
	}

	public SousGroupe getSousGroupe() {
		return this.sousGroupe;
	}

	public void setSousGroupe(SousGroupe sousGroupe) {
		this.sousGroupe = sousGroupe;
	}

	public Enseignant getEnseignant() {
		return this.enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public Seance getSeance() {
		return this.seance;
	}

	public void setSeance(Seance seance) {
		this.seance = seance;
	}

	public Matiere getMatiere() {
		return this.matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Salle getSalle() {
		return this.salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

}