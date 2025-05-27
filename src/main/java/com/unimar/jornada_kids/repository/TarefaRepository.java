package com.unimar.jornada_kids.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unimar.jornada_kids.model.entity.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

}
