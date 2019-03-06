package br.com.poc.cadastro.model;

public enum PerfilUsuarioEnum {
	
	ADMINISTRADOR ("ADMINISTRADOR"),
	FUNCIONARIO ("FUNCIONÁRIO");
	
	private final String nomePerfil;
	
	PerfilUsuarioEnum(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}
	
	public String getNomePerfil() {
		return nomePerfil;
	}
	
	
}
