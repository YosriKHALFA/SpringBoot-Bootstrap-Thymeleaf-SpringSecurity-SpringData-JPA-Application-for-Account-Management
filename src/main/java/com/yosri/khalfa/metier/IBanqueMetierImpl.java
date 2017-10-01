package com.yosri.khalfa.metier;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yosri.khalfa.dao.CompteRepository;
import com.yosri.khalfa.dao.OperationRepository;
import com.yosri.khalfa.entities.Compte;
import com.yosri.khalfa.entities.CompteCourant;
import com.yosri.khalfa.entities.Operation;
import com.yosri.khalfa.entities.Retrait;
import com.yosri.khalfa.entities.Versement;

@Service
@Transactional
public class IBanqueMetierImpl implements IBanqueMetier {

	@Autowired
	private CompteRepository compte;
	@Autowired
	private OperationRepository operation;

	@Override
	public Compte consulterCompte(String codeCpte) {
		Compte cp=	compte.findOne(codeCpte);
		if(cp==null) throw new  RuntimeException("Compte introuvable!!");
		return cp;
	}

	@Override
	public void verser(double mt, String cpte) {
		Compte cpt= consulterCompte(cpte);
		Versement ver=new Versement(new Date(), mt, cpt);
		operation.save(ver);
		cpt.setSolde(cpt.getSolde()+mt);
		compte.save(cpt);

	}

	@Override
	public void retirer(double mt, String cpte) {

		Compte cpt= consulterCompte(cpte);
		double facilitie=0;
		if(cpt instanceof CompteCourant )
			facilitie=((CompteCourant) cpt).getDecouvert();
		if(cpt.getSolde()+facilitie<mt)
			throw new RuntimeException("Solde Insuffisant !");

		Retrait ver=new Retrait(new Date(), mt, cpt);
		operation.save(ver);
		cpt.setSolde(cpt.getSolde()-mt);
		compte.save(cpt);

	}

	@Override
	public void virement(double mt, String cpte1, String cpte2) {
      if(cpte1.equals(cpte2)) throw new RuntimeException("Operation Invalide !");
		retirer(mt, cpte1);
		verser(mt, cpte2);
	}

	@Override
	public Page<Operation> consulterOperations(String codeCpte, int numPage, int taillePage) {
		return operation.listOpertaion(codeCpte, new PageRequest(numPage, taillePage));
	}

}
