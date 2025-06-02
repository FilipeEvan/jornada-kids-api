package com.unimar.jornada_kids.mapper.impl;

import org.springframework.stereotype.Component;

import com.unimar.jornada_kids.mapper.CriancaMapper;
import com.unimar.jornada_kids.mapper.ResponsavelMapper;
import com.unimar.jornada_kids.mapper.TarefaMapper;
import com.unimar.jornada_kids.model.dto.tarefa.TarefaDetalhadaDTO;
import com.unimar.jornada_kids.model.dto.tarefa.TarefaNovaDTO;
import com.unimar.jornada_kids.model.dto.tarefa.TarefaResumidaDTO;
import com.unimar.jornada_kids.model.entity.Tarefa;

@Component
public class TarefaMapperImpl implements TarefaMapper {
	
	private CriancaMapper criancaMapper;
	
	private ResponsavelMapper responsavelMapper;
	
	public TarefaMapperImpl(CriancaMapper criancaMapper, ResponsavelMapper responsavelMapper) {
		this.criancaMapper = criancaMapper;
		this.responsavelMapper = responsavelMapper;
	}

	@Override
	public Tarefa paraEntity(TarefaNovaDTO dto) {
		Tarefa tarefa = new Tarefa();
		
		tarefa.setTitulo(dto.getTitulo());
		tarefa.setDescricao(dto.getDescricao());
		tarefa.setPontuacaoTotal(dto.getPontuacaoTotal());
		tarefa.setPrioridade(dto.getPrioridade());
		tarefa.setDataHoraLimite(dto.getDataHoraLimite());
		
		return tarefa;
	}

	@Override
	public TarefaDetalhadaDTO paraDetalhadaDTO(Tarefa tarefa) {
		TarefaDetalhadaDTO dto = new TarefaDetalhadaDTO();
		
		dto.setId(tarefa.getId());
		dto.setResponsavelDetalhado(responsavelMapper.paraDetalhadoDTO(tarefa.getResponsavel()));
		dto.setCriancaDetalhada(criancaMapper.paraDetalhadaDTO(tarefa.getCrianca()));
		dto.setTitulo(tarefa.getTitulo());
		dto.setDescricao(tarefa.getDescricao());
		dto.setPontuacaoTotal(tarefa.getPontuacaoTotal());
		dto.setPontuacaoConquistada(tarefa.getPontuacaoConquistada());
		dto.setEstrela(tarefa.getEstrela());
		dto.setPrioridade(tarefa.getPrioridade().obterRotulo());
		dto.setSituacao(tarefa.getSituacao().obterRotulo());
		dto.setDataHoraLimite(tarefa.getDataHoraLimite());
		dto.setDataHoraConclusao(tarefa.getDataHoraConclusao());
		dto.setCriadoEm(tarefa.getCriadoEm());
		dto.setAtualizadoEm(tarefa.getAtualizadoEm());
		
		return dto;
	}

	@Override
	public TarefaResumidaDTO paraResumidaDTO(Tarefa tarefa) {
		TarefaResumidaDTO dto = new TarefaResumidaDTO();
		
		dto.setId(tarefa.getId());
		dto.setResponsavelResumido(responsavelMapper.paraResumidoDTO(tarefa.getResponsavel()));
		dto.setCriancaResumida(criancaMapper.paraResumidaDTO(tarefa.getCrianca()));
		dto.setTitulo(tarefa.getTitulo());
		dto.setPontuacaoTotal(tarefa.getPontuacaoTotal());
		dto.setPrioridade(tarefa.getPrioridade().obterRotulo());
		dto.setSituacao(tarefa.getSituacao().obterRotulo());
		dto.setDataHoraLimite(tarefa.getDataHoraLimite());

		return dto;
	}
	
}
