package com.yosri.khalfa.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {
	private double taux;

	public CompteEpargne() {
		super();
	}
	public CompteEpargne(String codeCompte, Date dateCreation, double solde, Client client, double taux) {
		super(codeCompte, dateCreation, solde, client);
		this.taux = taux;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

}
