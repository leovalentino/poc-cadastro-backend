package br.com.poc.cadastro.client;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import br.com.poc.cadastro.dto.EnderecoDTO;

@Service
public class ViaCEPClient {

	public EnderecoDTO buscaEnderecoPor(@PathVariable("cep") String cep) {
		RestTemplate restTemplate = new RestTemplate();
		EnderecoDTO enderecoDTO = restTemplate.getForObject("https://viacep.com.br/ws/{cep}/json", EnderecoDTO.class, cep);
		return enderecoDTO;
	}
	
}
