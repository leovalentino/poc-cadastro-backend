package br.com.poc.cadastro.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CLIENTE")
@NamedQuery(name = "Cliente.pesquisar", query = "SELECT c FROM Cliente c WHERE (:nome = '' or c.nome Like Concat('%' || :nome|| '%')) "
		+ "and (:cpf = '' or c.cpf = :cpf)")
public class Cliente extends PocCadastroEntidade {

	private static final long serialVersionUID = -3455002645176388120L;

	@Id
	@Column(name = "IDCLIENTE")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCliente;

	@NotNull(message = "Campo obrigatorio")
	@Size(min=3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
	@Column(name = "NOME", nullable = false)
	private String nome;

	@NotNull(message = "Campo obrigatorio")
	@Column(name = "CPF", nullable = false)
	private String cpf;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "idEndereco")
	private Endereco endereco;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<Email> emails;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<Telefone> telefones;

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Set<Email> getEmails() {
		return emails;
	}

	public void setEmails(Set<Email> emails) {
		this.emails = emails;
	}

	public Set<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}

}
