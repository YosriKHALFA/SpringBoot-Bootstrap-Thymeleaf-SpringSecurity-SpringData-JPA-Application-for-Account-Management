package com.yosri.khalfa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yosri.khalfa.entities.Compte;
import com.yosri.khalfa.entities.Operation;
import com.yosri.khalfa.metier.IBanqueMetier;

@Controller
public class BanqueController {


	@Autowired
	private IBanqueMetier metier;

	
	@RequestMapping("/")
	public String root() {
		return "redirect:/operations";
	}
	
	@RequestMapping(value = "/operations")
	public String index(Model model){
		return "comptes";
	}


	@RequestMapping(value = "/consulterCompte" )
	public String consulterCompte(Model model,String codeCompte,@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size){
		model.addAttribute("codeCompte", codeCompte);	
		try {
			Compte cpt=	metier.consulterCompte(codeCompte);
			 Page<Operation> listOperations=metier.consulterOperations(codeCompte, page, size);
			 model.addAttribute("listOperations", listOperations.getContent());
			 int [] pages =new int[listOperations.getTotalPages()];
			 model.addAttribute("pages", pages);	
			 model.addAttribute("compte", cpt);	
		}catch(Exception e) {
			model.addAttribute("exception", e);
		}
			
		return "comptes";
	}
	
	
	@RequestMapping(value = "/saveOperation" )
	public String saveOperation(Model model,String codeCompte,String typeOperation, String codeCompte2,double montant){
		try {
			if("VERS".equals(typeOperation)) {
				metier.verser(montant, codeCompte);
			}else if ("RETR".equals(typeOperation)) {
				metier.retirer(montant, codeCompte);
			}else if ("VIR".equals(typeOperation)) {
				metier.virement(montant, codeCompte, codeCompte2);
			}
		}catch(Exception e) {
			model.addAttribute("error", e);
			return "redirect:/consulterCompte?codeCompte="+codeCompte+"&error="+e.getMessage();
		}
			
		return "redirect:/consulterCompte?codeCompte="+codeCompte;
	}
	
	
	
	

}
