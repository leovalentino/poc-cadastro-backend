package br.com.poc.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.poc.cadastro.model.Email;

public interface EmailRepository extends JpaRepository<Email, Integer> {

}
