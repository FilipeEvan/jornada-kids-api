package com.unimar.jornada_kids.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unimar.jornada_kids.model.entity.Responsavel;


public interface ResponsavelRepository extends JpaRepository<Responsavel, Integer> {
	
	boolean existsByCodigo(String codigo);
	
	Optional<Responsavel> findByCodigo(String codigo);

}
