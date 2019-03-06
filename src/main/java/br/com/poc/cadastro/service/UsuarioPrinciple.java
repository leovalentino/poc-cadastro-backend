package br.com.poc.cadastro.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.poc.cadastro.model.Usuario;

public class UsuarioPrinciple implements UserDetails {

	private static final long serialVersionUID = -1080137625407525361L;
	
	private Integer idUsuario;
	private String login;
	
	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;
	
	public UsuarioPrinciple(Integer idUsuario, String login, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.idUsuario = idUsuario;
		this.login = login;
		this.password = password;
		this.authorities = authorities;
	}
	
	public static UsuarioPrinciple build(Usuario usuario) {
		List<GrantedAuthority> authorities = usuario.getPerfil().stream().map(perfil ->
		           new SimpleGrantedAuthority(perfil.getPerfil().getNomePerfil())).collect(Collectors.toList());
		
		return new UsuarioPrinciple(usuario.getIdUsuario(), usuario.getLogin(), usuario.getSenha(), authorities);
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public String getLogin() {
		return login;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        
	        UsuarioPrinciple user = (UsuarioPrinciple) o;
	        return Objects.equals(login, user.login);
	    }

}
