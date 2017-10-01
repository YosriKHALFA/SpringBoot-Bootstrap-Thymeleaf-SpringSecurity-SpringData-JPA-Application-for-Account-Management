package com.yosri.khalfa.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="CLIENTS")
public class Client implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CODE_CLI")
	private Long code;
	private String nom;
	private String email;
	@OneToMany(mappedBy="client",fetch=FetchType.LAZY)
	private Collection<Compte> comptes;

    
	
	public Client() {
		super();
	}

	public Client(String nom, String email, Collection<Compte> comptes) {
		super();
		this.nom = nom;
		this.email = email;
		this.comptes = comptes;
	}
	
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Collection<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}




}
