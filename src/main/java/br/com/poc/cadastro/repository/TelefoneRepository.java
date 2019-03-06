package br.com.poc.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.poc.cadastro.model.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Integer> {

}
