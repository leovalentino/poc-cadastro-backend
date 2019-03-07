package br.com.poc.cadastro.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.poc.cadastro.client.ViaCEPClient;
import br.com.poc.cadastro.dto.EnderecoDTO;
import br.com.poc.cadastro.model.Cliente;
import br.com.poc.cadastro.model.Endereco;
import br.com.poc.cadastro.model.TipoTelefoneEnum;
import br.com.poc.cadastro.service.ClienteService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ViaCEPClient viaCepClient;
	
	@PostMapping("/cliente/salvar")
	public ResponseEntity<String> salvar(@Valid @RequestBody Cliente entidade) {
		clienteService.salvar(entidade);
		return ResponseEntity.ok("Item incluído com sucesso");
	}
	
	@GetMapping("/cliente/tipoTelefone") 
	public ResponseEntity<Object> getListaTipoTelefone() {
		return ResponseEntity.ok(TipoTelefoneEnum.values());
	}
	
	@PostMapping("/cliente/pesquisar")
	public ResponseEntity<List<Cliente>> pesquisar(@RequestBody Cliente cliente) {
		return ResponseEntity.ok(clienteService.pesquisar(cliente));
	}
	
	@GetMapping("/cliente/obter/{id}")
	public ResponseEntity<Cliente> obter(@PathVariable Integer id) {
		return ResponseEntity.ok(clienteService.obter(id));
	}
	
	@PutMapping("/cliente/atualizar")
	public ResponseEntity<String> atualizar(@Valid @RequestBody Cliente cliente) {
		clienteService.salvar(cliente);
		return ResponseEntity.ok("Item alterado com sucesso");
	}
	
	@DeleteMapping("/cliente/excluir/{id}")
	public ResponseEntity<String> excluir(@PathVariable Integer id) {
		clienteService.excluir(id);
		return ResponseEntity.ok("Item excluído com sucesso");
	}
	
	@GetMapping("/cliente/cep/{cep}")
	public ResponseEntity<Endereco> obterEnderecoPorCep(@PathVariable String cep) {
		EnderecoDTO enderecoDTO = this.viaCepClient.buscaEnderecoPor(cep);
		Endereco endereco = converterDTOParaEntitade(enderecoDTO);
		return ResponseEntity.ok(endereco);
		
	}

	private Endereco converterDTOParaEntitade(EnderecoDTO enderecoDTO) {
		Endereco endereco = new Endereco();
		BeanUtils.copyProperties(enderecoDTO, endereco);
		endereco.setCidade(enderecoDTO.getLocalidade());
		return endereco;
	}
	
}
