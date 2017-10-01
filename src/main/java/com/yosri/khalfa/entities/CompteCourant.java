package com.yosri.khalfa.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {
	private double decouvert;

	public CompteCourant(String codeCompte, Date dateCreation, double solde, Client client, double decouvert) {
		super(codeCompte, dateCreation, solde, client);
		this.decouvert = decouvert;
	}

	public CompteCourant() {
		super();
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}



}
