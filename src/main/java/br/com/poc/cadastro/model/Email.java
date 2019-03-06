package br.com.poc.cadastro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Email")
public class Email extends PocCadastroEntidade {

	private static final long serialVersionUID = -1489295067469921774L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CODEMAIL")
	private Integer codEmail;

	@Column(name = "ENDERECOEMAIL")
	private String enderecoEmail;

	public Integer getCodEmail() {
		return codEmail;
	}

	public void setCodEmail(Integer codEmail) {
		this.codEmail = codEmail;
	}

	public String getEnderecoEmail() {
		return enderecoEmail;
	}

	public void setEnderecoEmail(String enderecoEmail) {
		this.enderecoEmail = enderecoEmail;
	}

}
