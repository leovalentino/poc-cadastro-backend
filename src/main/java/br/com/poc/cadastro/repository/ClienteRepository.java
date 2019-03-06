package br.com.poc.cadastro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.poc.cadastro.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	public List<Cliente> pesquisar(String nome, String cpf);
	
	public List<Cliente> findByNomeStartingWithOrCpf(String nome, String cpf);

}
