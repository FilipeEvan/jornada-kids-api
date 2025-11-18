package com.unimar.jornada_kids.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.unimar.jornada_kids.exception.UsuarioNotFoundException;
import com.unimar.jornada_kids.mapper.AplicativoMapper;
import com.unimar.jornada_kids.model.dto.aplicativo.AplicativoBloqueadoDTO;
import com.unimar.jornada_kids.model.dto.aplicativo.AplicativoDetalhadoDTO;
import com.unimar.jornada_kids.model.dto.aplicativo.AplicativoNovoDTO;
import com.unimar.jornada_kids.model.dto.aplicativo.AplicativoResumidoDTO;
import com.unimar.jornada_kids.model.dto.aplicativo.AplicativoUsadoDTO;
import com.unimar.jornada_kids.model.entity.Aplicativo;
import com.unimar.jornada_kids.model.entity.Crianca;
import com.unimar.jornada_kids.model.entity.Responsavel;
import com.unimar.jornada_kids.model.enumeration.PlataformaAplicativo;
import com.unimar.jornada_kids.repository.AplicativoRepository;
import com.unimar.jornada_kids.repository.CriancaRepository;
import com.unimar.jornada_kids.repository.ResponsavelRepository;

@Component
public class AplicativoService {
	
	private CriancaRepository criancaRepository;
	
	private ResponsavelRepository responsavelRepository;
	
	private AplicativoRepository aplicativoRepository;
	
	private AplicativoMapper aplicativoMapper;

	public AplicativoService(CriancaRepository criancaRepository, ResponsavelRepository responsavelRepository,
			AplicativoRepository aplicativoRepository, AplicativoMapper aplicativoMapper) {
		super();
		this.criancaRepository = criancaRepository;
		this.responsavelRepository = responsavelRepository;
		this.aplicativoRepository = aplicativoRepository;
		this.aplicativoMapper = aplicativoMapper;
	}
	
	public List<AplicativoResumidoDTO> listarTodas(PlataformaAplicativo plataforma, Boolean bloqueado) {
		List<Aplicativo> aplicativos = aplicativoRepository.findAll();
		
		if (plataforma != null) 
			aplicativos = aplicativos.stream()
	    			.filter(a -> a.getPlataforma() == plataforma)
					.toList();
	    
		if (bloqueado != null) 
			aplicativos = aplicativos.stream()
	    			.filter(a -> a.getBloqueado() == bloqueado)
					.toList();
		
		return aplicativos.stream()
				.map(aplicativoMapper::paraResumidoDTO)
				.toList();
	}
	
	public AplicativoDetalhadoDTO buscarPorId(int id) {
		Aplicativo aplicativo = aplicativoRepository.findById(id)
				.orElseThrow(() -> new UsuarioNotFoundException("Aplicativo não encontrado"));
		
		AplicativoDetalhadoDTO aplicativoDetalhado = aplicativoMapper.paraDetalhadoDTO(aplicativo);

		return aplicativoDetalhado;
	}
	
	public Aplicativo salvar(AplicativoNovoDTO aplicativoNovo) {
		Aplicativo aplicativo  = aplicativoMapper.paraEntity(aplicativoNovo);
		
		Responsavel responsavel = responsavelRepository.findById(aplicativoNovo.getIdResponsavel())
				.orElseThrow(() -> new UsuarioNotFoundException("Responsável não encontrado"));
		
		Crianca crianca = criancaRepository.findById(aplicativoNovo.getIdCrianca())
				.orElseThrow(() -> new UsuarioNotFoundException("Criança não encontrada"));
		
		aplicativo.setResponsavel(responsavel);
		aplicativo.setCrianca(crianca);
		
		return aplicativoRepository.save(aplicativo);
    }
	
	public void deletar(int id) {
		if(!aplicativoRepository.existsById(id))
			throw new UsuarioNotFoundException("Aplicativo não encontrada");
		
		aplicativoRepository.deleteById(id);
	}
	
	public Aplicativo bloquear(int id, AplicativoBloqueadoDTO aplicativoBloqueado) {
		Aplicativo aplicativo = aplicativoRepository.findById(id)
				.orElseThrow(() -> new UsuarioNotFoundException("Aplicativo não encontrado"));
		
		aplicativo.setBloqueado(aplicativoBloqueado.getBloqueado());
		
		long tempoLimite =  aplicativo.getTempoLimite();
		aplicativo.setTempoLimite(tempoLimite + aplicativoBloqueado.getTempoLimite());
		
		return aplicativoRepository.save(aplicativo);
    }
	
	public Aplicativo atualizar(int id, AplicativoUsadoDTO aplicativoUsado) {
		Aplicativo aplicativo = aplicativoRepository.findById(id)
				.orElseThrow(() -> new UsuarioNotFoundException("Aplicativo não encontrado"));
		
		long tempoUsado =  aplicativo.getTempoUsado();
		aplicativo.setTempoUsado(tempoUsado + aplicativoUsado.getTempoUsado());
		
		return aplicativoRepository.save(aplicativo);
    }
	
}
