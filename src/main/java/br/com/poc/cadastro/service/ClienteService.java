package br.com.poc.cadastro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.poc.cadastro.exception.PocCadastroNegocioException;
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
		Cliente resultado = obterPorId(id);
		return clienteRepository.save(resultado);
	}
	
	public Cliente obter(Integer id) {
		return obterPorId(id);
	}
	
	public List<Cliente> pesquisar(Cliente dto) {
		return clienteRepository.pesquisar(notNull(dto.getNome()), 
										   notNull(dto.getCpf()));
	}
	
	public void excluir(Integer id) {
		clienteRepository.delete(obterPorId(id));
	}

	private String notNull(String valor) {
		return valor == null ? "" : valor;
	}
	
	private Cliente obterPorId(Integer id) {
		return clienteRepository.findById(id).orElseThrow(() -> new PocCadastroNegocioException("Item não encontrado"));
	}
	
}
