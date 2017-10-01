package com.yosri.khalfa;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yosri.khalfa.dao.ClientRepository;
import com.yosri.khalfa.dao.CompteRepository;
import com.yosri.khalfa.dao.OperationRepository;
import com.yosri.khalfa.entities.Client;
import com.yosri.khalfa.entities.Compte;
import com.yosri.khalfa.entities.CompteCourant;
import com.yosri.khalfa.entities.CompteEpargne;
import com.yosri.khalfa.entities.Retrait;
import com.yosri.khalfa.entities.Versement;
import com.yosri.khalfa.metier.IBanqueMetier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootThymleafSecurityBootstrapJpaApplicationTests {

	@Autowired
	private ClientRepository client;
	@Autowired
	private CompteRepository compte;
	@Autowired
	private OperationRepository operation;
	
	@Autowired
	private IBanqueMetier banque;
	
	
	@Test
	public void contextLoads() {
		
	 Client C1=	client.save(new Client("yosri", "yosri.khalfa@gmail.com", null));
	 Client C2=	client.save(new Client("mohamed", "mohamed.tounsi@gmail.com", null));
		
	 Compte cp1=compte.save(new CompteCourant("C1", new Date(),100,C1, 5));
	 Compte cp2=compte.save(new CompteEpargne("C2", new Date(),100,C2, 100));
	
	operation.save(new Retrait(new Date(), 10,cp1));
	operation.save(new Versement(new Date(), 10,cp2));
	
	
	banque.verser(100000, "C1");
	banque.verser(100000, "C2");
	
	banque.virement(2000, "C1", "C2");
	
	
	}

}
