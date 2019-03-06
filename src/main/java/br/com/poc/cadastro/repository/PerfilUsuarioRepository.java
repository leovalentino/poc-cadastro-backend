package br.com.poc.cadastro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.poc.cadastro.model.PerfilUsuario;
import br.com.poc.cadastro.model.PerfilUsuarioEnum;

public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuario, Integer>{

	public Optional<PerfilUsuario> findByPerfil(PerfilUsuarioEnum perfil);

}
