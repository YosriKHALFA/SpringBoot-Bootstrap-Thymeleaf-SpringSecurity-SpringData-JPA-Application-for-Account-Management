package com.yosri.khalfa.metier;

import org.springframework.data.domain.Page;

import com.yosri.khalfa.entities.Compte;
import com.yosri.khalfa.entities.Operation;

public interface IBanqueMetier {

	public Compte consulterCompte(String codeCpte);
	public void verser(double mt,String cpte);
	public void retirer(double mt,String cpte);
	public void virement(double mt,String cpte1,String cpte2);
	public Page<Operation> consulterOperations(String codeCpte,int position,int nbOperation);
	
	
	
	
}
