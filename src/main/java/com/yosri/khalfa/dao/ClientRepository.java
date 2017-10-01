package com.yosri.khalfa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yosri.khalfa.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
