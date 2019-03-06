package br.com.poc.cadastro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TELEFONE")
public class Telefone extends PocCadastroEntidade {

	private static final long serialVersionUID = 3873273935634719808L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CODTELEFONE")
	private Integer codTelefone;

	@Column(name = "TIPOTELEFONE")
	private TipoTelefoneEnum tipoTelefone;

	@Column(name = "NUMERO")
	private String numero;

	public Integer getCodTelefone() {
		return codTelefone;
	}

	public void setCodTelefone(Integer codTelefone) {
		this.codTelefone = codTelefone;
	}

	public TipoTelefoneEnum getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(TipoTelefoneEnum tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
