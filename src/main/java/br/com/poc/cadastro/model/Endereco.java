package br.com.poc.cadastro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties("cliente")
@Table(name = "ENDERECO")
public class Endereco extends PocCadastroEntidade {

	private static final long serialVersionUID = 2639369145715838617L;

	@Id
	@Column(name = "IDENDERECO")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idEndereco;

	@Column(name = "CEP", nullable = false)
	private String cep;

	@NotNull(message = "Campo obrigatorio")
	@Column(name = "LOGRADOURO", nullable = false)
	private String logradouro;

	@NotNull(message = "Campo obrigatorio")
	@Column(name = "COMPLEMENTO")
	private String complemento;

	@NotNull(message = "Campo obrigatorio")
	@Column(name = "BAIRRO", nullable = false)
	private String bairro;

	@NotNull(message = "Campo obrigatorio")
	@Column(name = "UF", nullable = false)
	private String uf;

	@NotNull(message = "Campo obrigatorio")
	@Column(name = "CIDADE", nullable = false)
	private String cidade;

	@OneToOne(mappedBy = "endereco")
	private Cliente cliente;

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
