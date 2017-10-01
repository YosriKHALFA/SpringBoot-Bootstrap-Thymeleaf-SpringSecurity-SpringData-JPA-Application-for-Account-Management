package com.yosri.khalfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yosri.khalfa.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, String> {

}
