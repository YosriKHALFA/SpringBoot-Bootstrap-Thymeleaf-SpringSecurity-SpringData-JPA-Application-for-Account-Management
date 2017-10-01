package com.yosri.khalfa.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue(value="R")
public class Retrait  extends Operation{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Retrait() {
		super();
	}

	
	public Retrait(Date dateOperation, double montant, Compte compte) {
		super(dateOperation, montant, compte);
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Retrait";
	}
}
