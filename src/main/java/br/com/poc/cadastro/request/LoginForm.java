package br.com.poc.cadastro.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginForm {

	@NotBlank
	@Size(min = 3, max = 60)
	private String login;

	@NotBlank
	@Size(min = 6, max = 40)
	private String senha;

	public String getUsername() {
		return login;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setUsername(String username) {
		this.login = username;
	}

	public String getPassword() {
		return senha;
	}

	public void setPassword(String password) {
		this.senha = password;
	}

}
