package com.unimar.jornada_kids.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.unimar.jornada_kids.exception.UsuarioNotFoundException;
import com.unimar.jornada_kids.mapper.CriancaMapper;
import com.unimar.jornada_kids.mapper.TarefaMapper;
import com.unimar.jornada_kids.mapper.UsuarioMapper;
import com.unimar.jornada_kids.model.dto.crianca.CriancaDetalhadaDTO;
import com.unimar.jornada_kids.model.dto.crianca.CriancaNovaDTO;
import com.unimar.jornada_kids.model.dto.crianca.CriancaResumidaDTO;
import com.unimar.jornada_kids.model.dto.tarefa.TarefaResumidaDTO;
import com.unimar.jornada_kids.model.entity.Crianca;
import com.unimar.jornada_kids.model.entity.Responsavel;
import com.unimar.jornada_kids.model.entity.Tarefa;
import com.unimar.jornada_kids.model.entity.Usuario;
import com.unimar.jornada_kids.model.enumeration.PrioridadeTarefa;
import com.unimar.jornada_kids.model.enumeration.SituacaoTarefa;
import com.unimar.jornada_kids.repository.CriancaRepository;
import com.unimar.jornada_kids.repository.ResponsavelRepository;
import com.unimar.jornada_kids.repository.UsuarioRepository;

@Component
public class CriancaService {
	
	private CriancaRepository criancaRepository;
	
	private ResponsavelRepository responsavelRepository;
	
	private UsuarioRepository usuarioRepository;
	
	private CriancaMapper criancaMapper;
	
	private UsuarioMapper usuarioMapper;
	
	private TarefaMapper tarefaMapper;
	
	public CriancaService(CriancaMapper criancaMapper, ResponsavelRepository responsavelRepository, UsuarioRepository usuarioRepository,  
			CriancaRepository criancaRepository, UsuarioMapper usuarioMapper, TarefaMapper tarefaMapper) {
		this.criancaRepository = criancaRepository;
		this.usuarioRepository = usuarioRepository;
		this.responsavelRepository = responsavelRepository;
		this.criancaMapper = criancaMapper;
		this.usuarioMapper = usuarioMapper;
		this.tarefaMapper = tarefaMapper;
	}
	
	public List<CriancaResumidaDTO> listarTodas() {
		List<Crianca> criancas = criancaRepository.findAll();
		
		return criancas.stream()
				.map(criancaMapper::paraResumidaDTO)
				.toList();
	}
	
	public List<TarefaResumidaDTO> listarTarefas(int id, PrioridadeTarefa prioridade, SituacaoTarefa situacao) {
	    Crianca crianca = criancaRepository.findById(id)
	        .orElseThrow(() -> new UsuarioNotFoundException("Criança não encontrada"));

	    List<Tarefa> tarefas = crianca.getTarefas(); 
	    
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
	
	public CriancaDetalhadaDTO buscarPorId(int id) {
		Crianca crianca = criancaRepository.findById(id)
				.orElseThrow(() -> new UsuarioNotFoundException("Criança não encontrada"));
		
		CriancaDetalhadaDTO criancaDetalhada = criancaMapper.paraDetalhadaDTO(crianca);

		return criancaDetalhada;
	}
	
	public Crianca salvar(CriancaNovaDTO criancaNova) {
		Crianca crianca = criancaMapper.paraEntity(criancaNova);
		
		Responsavel responsavel = responsavelRepository.findById(criancaNova.getIdResponsavel())
				.orElseThrow(() -> new UsuarioNotFoundException("Responsável não encontrado"));
		
		Usuario usuario = usuarioRepository.save(usuarioMapper.paraEntity(criancaNova.getUsuarioNovo()));
		
		if(usuario == null)
			throw new RuntimeException("Falha ao criar Usuário");
		
		crianca.setUsuario(usuario);
		crianca.setResponsavel(responsavel);
		crianca.setNivel(0);
		crianca.setXp(0);
		crianca.setXpTotal(0);
		crianca.setPonto(0);
	    
		return criancaRepository.save(crianca);
    }
	
	public void deletar(int id) {
		if(!criancaRepository.existsById(id))
			throw new UsuarioNotFoundException("Criança não encontrada");
		
		criancaRepository.deleteById(id);
	}

}
