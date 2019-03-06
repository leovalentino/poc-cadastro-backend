package br.com.poc.cadastro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "PERFILUSUARIO")
public class PerfilUsuario extends PocCadastroEntidade {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idPerfilUsuario")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idPerfilUsuario;

	@Enumerated(EnumType.STRING)
	@NaturalId
	@Column(name = "PERFIL")
	private PerfilUsuarioEnum perfil;

	public Integer getIdPerfilUsuario() {
		return idPerfilUsuario;
	}

	public void setIdPerfilUsuario(Integer idPerfilUsuario) {
		this.idPerfilUsuario = idPerfilUsuario;
	}

	public PerfilUsuarioEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilUsuarioEnum perfil) {
		this.perfil = perfil;
	}
	
	public PerfilUsuario() {
	}

}
