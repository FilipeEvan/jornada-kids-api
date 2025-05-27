package com.unimar.jornada_kids.mapper;

import com.unimar.jornada_kids.model.dto.tarefa.TarefaDetalhadaDTO;
import com.unimar.jornada_kids.model.dto.tarefa.TarefaNovaDTO;
import com.unimar.jornada_kids.model.dto.tarefa.TarefaResumidaDTO;
import com.unimar.jornada_kids.model.entity.Tarefa;

public interface TarefaMapper {
	Tarefa paraEntity(TarefaNovaDTO dto);
	TarefaDetalhadaDTO paraDetalhadaDTO(Tarefa tarefa);
	TarefaResumidaDTO paraResumidaDTO(Tarefa tarefa);
}
