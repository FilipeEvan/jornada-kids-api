package com.unimar.jornada_kids.service;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.unimar.jornada_kids.exception.UsuarioNotFoundException;
import com.unimar.jornada_kids.mapper.CriancaMapper;
import com.unimar.jornada_kids.mapper.RecompensaMapper;
import com.unimar.jornada_kids.mapper.ResponsavelMapper;
import com.unimar.jornada_kids.mapper.TarefaMapper;
import com.unimar.jornada_kids.mapper.UsuarioMapper;
import com.unimar.jornada_kids.model.dto.crianca.CriancaResumidaDTO;
import com.unimar.jornada_kids.model.dto.recompensa.RecompensaResumidaDTO;
import com.unimar.jornada_kids.model.dto.responsavel.ResponsavelDetalhadoDTO;
import com.unimar.jornada_kids.model.dto.responsavel.ResponsavelNovoDTO;
import com.unimar.jornada_kids.model.dto.responsavel.ResponsavelResumidoDTO;
import com.unimar.jornada_kids.model.dto.tarefa.TarefaResumidaDTO;
import com.unimar.jornada_kids.model.entity.Crianca;
import com.unimar.jornada_kids.model.entity.Recompensa;
import com.unimar.jornada_kids.model.entity.Responsavel;
import com.unimar.jornada_kids.model.entity.Tarefa;
import com.unimar.jornada_kids.model.entity.Usuario;
import com.unimar.jornada_kids.model.enumeration.PrioridadeTarefa;
import com.unimar.jornada_kids.model.enumeration.SituacaoRecompensa;
import com.unimar.jornada_kids.model.enumeration.SituacaoTarefa;
import com.unimar.jornada_kids.repository.ResponsavelRepository;
import com.unimar.jornada_kids.repository.UsuarioRepository;

@Component
public class ResponsavelService {
	
	private ResponsavelRepository responsavelRepository;
	
	private UsuarioRepository usuarioRepository;
	
	private CriancaMapper criancaMapper;
	
	private RecompensaMapper recompensaMapper;
	
	private ResponsavelMapper responsavelMapper;
	
	private TarefaMapper tarefaMapper;
	
	private UsuarioMapper usuarioMapper;
	
	public ResponsavelService(ResponsavelRepository responsavelRepository, UsuarioRepository usuarioRepository, 
			CriancaMapper criancaMapper, RecompensaMapper recompensaMapper, ResponsavelMapper responsavelMapper, TarefaMapper tarefaMapper, UsuarioMapper usuarioMapper) {
		this.criancaMapper = criancaMapper;
		this.responsavelRepository = responsavelRepository;
		this.usuarioRepository = usuarioRepository;
		this.recompensaMapper = recompensaMapper;
		this.responsavelMapper = responsavelMapper;
		this.tarefaMapper = tarefaMapper;
		this.usuarioMapper = usuarioMapper;
	}
	
	public List<ResponsavelResumidoDTO> listarTodos() {
		List<Responsavel> responsaveis = responsavelRepository.findAll();
		
		return responsaveis.stream()
				.map(responsavelMapper::paraResumidoDTO)
				.toList();
	}
	
	public List<CriancaResumidaDTO> listarCriancas(int id) {
	    Responsavel responsavel = responsavelRepository.findById(id)
	        .orElseThrow(() -> new UsuarioNotFoundException("Responsável não encontrado"));

	    List<Crianca> criancas = responsavel.getCriancas(); 

	    return criancas.stream()
				.map(criancaMapper::paraResumidaDTO)
				.toList();
	}
	
	public List<TarefaResumidaDTO> listarTarefas(int id, PrioridadeTarefa prioridade, SituacaoTarefa situacao) {
	    Responsavel responsavel = responsavelRepository.findById(id)
	        .orElseThrow(() -> new UsuarioNotFoundException("Responsável não encontrada"));

	    List<Tarefa> tarefas = responsavel.getTarefas(); 
	    
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
	
	public List<RecompensaResumidaDTO> listarRecompensas(int id, SituacaoRecompensa situacao) {
	    Responsavel responsavel = responsavelRepository.findById(id)
	        .orElseThrow(() -> new UsuarioNotFoundException("Responsável não encontrada"));

	    List<Recompensa> recompensas = responsavel.getRecompensas(); 
	    
	    if (situacao != null) 
	    	recompensas = recompensas.stream()
	    			.filter(r -> r.getSituacao() == situacao)
					.toList();
	    

	    return recompensas.stream()
				.map(recompensaMapper::paraResumidaDTO)
				.toList();
	}
	
	public ResponsavelDetalhadoDTO buscarPorId(int id) {
		Responsavel responsavel = responsavelRepository.findById(id)
				.orElseThrow(() -> new UsuarioNotFoundException("Responsável não encontrado"));
		
		ResponsavelDetalhadoDTO responsavelDetalhado = responsavelMapper.paraDetalhadoDTO(responsavel);

		return responsavelDetalhado;
	}
	
	public ResponsavelDetalhadoDTO buscarPorCodigo(String codigo) {
		Responsavel responsavel = responsavelRepository.findByCodigo(codigo)
				.orElseThrow(() -> new UsuarioNotFoundException("Responsável não encontrado"));
		
		ResponsavelDetalhadoDTO responsavelDetalhado = responsavelMapper.paraDetalhadoDTO(responsavel);

		return responsavelDetalhado;
	}
	
	public Responsavel salvar(ResponsavelNovoDTO responsavelNovo) {
		Responsavel responsavel = responsavelMapper.paraEntity(responsavelNovo);
		
		Usuario usuario = usuarioRepository.save(usuarioMapper.paraEntity(responsavelNovo.getUsuarioNovo()));
		
		if(usuario == null)
			throw new RuntimeException("Falha ao criar Usuário");
		
		responsavel.setUsuario(usuario);
		responsavel.setCodigo(gerarCodigo());
	    
		return responsavelRepository.save(responsavel);
    }
	
	public void deletar(int id) {
		Responsavel responsavel = responsavelRepository.findById(id)
				.orElseThrow(() -> new UsuarioNotFoundException("Responsável não encontrado"));
		
		if(!responsavel.getCriancas().isEmpty())
			throw new RuntimeException("Responsável associado a crianças e não pode ser removido");
		
		responsavelRepository.deleteById(id);
	}
	
	public String gerarCodigo() {
		String codigo;
		
		do {
			Random random = new Random();
		    codigo = String.valueOf(100000 + random.nextInt(900000));
		} while (responsavelRepository.existsByCodigo(codigo));
		
		return codigo;
	}

}
