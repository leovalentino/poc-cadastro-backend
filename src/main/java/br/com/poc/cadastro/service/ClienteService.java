package br.com.poc.cadastro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.poc.cadastro.model.Cliente;
import br.com.poc.cadastro.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Cliente atualizar(Integer id) {
		Cliente resultado = clienteRepository.findById(id).orElse(new Cliente());
		return clienteRepository.save(resultado);
	}
	
	public Cliente obter(Integer id) {
		return clienteRepository.findById(id).orElse(new Cliente());
	}
	
	public List<Cliente> pesquisar(Cliente dto) {
		return clienteRepository.pesquisar(notNull(dto.getNome()), 
										   		 notNull(dto.getCpf()));
	}
	
	public void excluir(Integer id) {
		clienteRepository.delete(clienteRepository.findById(id).get());
	}

	private String notNull(String valor) {
		return valor == null ? "" : valor;
	}
	
}
