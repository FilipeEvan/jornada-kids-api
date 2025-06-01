package com.unimar.jornada_kids.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unimar.jornada_kids.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Optional<Usuario> findByNomeUsuario(String nomeUsuario);

}
