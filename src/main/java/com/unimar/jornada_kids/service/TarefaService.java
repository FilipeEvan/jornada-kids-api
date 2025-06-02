package com.unimar.jornada_kids.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.unimar.jornada_kids.exception.UsuarioNotFoundException;
import com.unimar.jornada_kids.mapper.TarefaMapper;
import com.unimar.jornada_kids.model.dto.tarefa.TarefaAvaliadaDTO;
import com.unimar.jornada_kids.model.dto.tarefa.TarefaDetalhadaDTO;
import com.unimar.jornada_kids.model.dto.tarefa.TarefaNovaDTO;
import com.unimar.jornada_kids.model.dto.tarefa.TarefaResumidaDTO;
import com.unimar.jornada_kids.model.entity.Crianca;
import com.unimar.jornada_kids.model.entity.Responsavel;
import com.unimar.jornada_kids.model.entity.Tarefa;
import com.unimar.jornada_kids.model.enumeration.PrioridadeTarefa;
import com.unimar.jornada_kids.model.enumeration.SituacaoTarefa;
import com.unimar.jornada_kids.repository.CriancaRepository;
import com.unimar.jornada_kids.repository.ResponsavelRepository;
import com.unimar.jornada_kids.repository.TarefaRepository;

@Component
public class TarefaService {
	
	private CriancaRepository criancaRepository;
	
	private ResponsavelRepository responsavelRepository;
	
	private TarefaRepository tarefaRepository;
	
	private TarefaMapper tarefaMapper;
	
	public TarefaService(CriancaRepository criancaRepository, ResponsavelRepository responsavelRepository, TarefaRepository tarefaRepository, 
			TarefaMapper tarefaMapper) {
		this.criancaRepository = criancaRepository;
		this.responsavelRepository = responsavelRepository;
		this.tarefaRepository = tarefaRepository;
		this.tarefaMapper = tarefaMapper;
	}
	
	public List<TarefaResumidaDTO> listarTodas(PrioridadeTarefa prioridade, SituacaoTarefa situacao) {
		List<Tarefa> tarefas = tarefaRepository.findAll();
		
		if (prioridade != null) 
	    	tarefas = tarefas.stream()
	    			.filter(t -> t.getPrioridade() == prioridade)
					.toList();
	    
	    
	    if (situacao != null) 
	    	tarefas = tarefas.stream()
	    			.filter(t -> t.getSituacao() == situacao)
					.toList();
		
		return tarefas.stream()
				.map(tarefaMapper::paraResumidaDTO)
				.toList();
	}
	
	public TarefaDetalhadaDTO buscarPorId(int id) {
		Tarefa tarefa = tarefaRepository.findById(id)
				.orElseThrow(() -> new UsuarioNotFoundException("Tarefa não encontrada"));
		
		TarefaDetalhadaDTO tarefaDetalhada = tarefaMapper.paraDetalhadaDTO(tarefa);

		return tarefaDetalhada;
	}
	
	public Tarefa salvar(TarefaNovaDTO tarefaNova) {
		Tarefa tarefa = tarefaMapper.paraEntity(tarefaNova);
		
		Responsavel responsavel = responsavelRepository.findById(tarefaNova.getIdResponsavel())
				.orElseThrow(() -> new UsuarioNotFoundException("Responsável não encontrado"));
		
		Crianca crianca = criancaRepository.findById(tarefaNova.getIdCrianca())
				.orElseThrow(() -> new UsuarioNotFoundException("Criança não encontrada"));
		
		tarefa.setResponsavel(responsavel);
		tarefa.setCrianca(crianca);
		tarefa.setSituacao(SituacaoTarefa.P);
		tarefa.setPontuacaoConquistada(0);
		tarefa.setEstrela(0);
		tarefa.setDataHoraConclusao(null);
	    
		return tarefaRepository.save(tarefa);
    }
	
	public void deletar(int id) {
		if(!tarefaRepository.existsById(id))
			throw new UsuarioNotFoundException("Tarefa não encontrada");
		
		tarefaRepository.deleteById(id);
	}
	
	public void concluir(int id) {
		Tarefa tarefa = tarefaRepository.findById(id)
				.orElseThrow(() -> new UsuarioNotFoundException("Tarefa não encontrada"));
		
		if (tarefa.getSituacao() != SituacaoTarefa.P) {
	        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tarefa não pode ser concluída");
	    }
		
		tarefa.setDataHoraConclusao(LocalDateTime.now());
		tarefa.setSituacao(SituacaoTarefa.C);

		tarefaRepository.save(tarefa);
	}
	
	public void avaliar(int id, TarefaAvaliadaDTO tarefaAvaliada) {
		Tarefa tarefa = tarefaRepository.findById(id)
				.orElseThrow(() -> new UsuarioNotFoundException("Tarefa não encontrada"));
		
		Crianca crianca = tarefa.getCrianca();
		
		if (tarefa.getSituacao() != SituacaoTarefa.C)
	        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tarefa não pode ser avaliada");
	    
	    long pontuacaoConquistada = (tarefaAvaliada.getEstrela() == 5)
	            ? tarefa.getPontuacaoTotal()
	            : Math.round(tarefa.getPontuacaoTotal() * (tarefaAvaliada.getEstrela() / 5.0));
		
		System.out.println(tarefaAvaliada.getEstrela());
		System.out.println(pontuacaoConquistada);
		tarefa.setEstrela(tarefaAvaliada.getEstrela());
		tarefa.setSituacao(SituacaoTarefa.A);
		tarefa.setPontuacaoConquistada(pontuacaoConquistada);
		
		tarefaRepository.save(tarefa);
		
		crianca.setPonto(crianca.getPonto() + pontuacaoConquistada);

		criancaRepository.save(crianca);
	}

}
