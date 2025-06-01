package com.unimar.jornada_kids.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.unimar.jornada_kids.exception.UsuarioNotFoundException;
import com.unimar.jornada_kids.mapper.CriancaRecompensaMapper;
import com.unimar.jornada_kids.mapper.RecompensaMapper;
import com.unimar.jornada_kids.model.dto.crianca_recompensa.RecompensaResgatadaDTO;
import com.unimar.jornada_kids.model.dto.recompensa.RecompensaDetalhadaDTO;
import com.unimar.jornada_kids.model.dto.recompensa.RecompensaNovaDTO;
import com.unimar.jornada_kids.model.dto.recompensa.RecompensaResumidaDTO;
import com.unimar.jornada_kids.model.entity.Crianca;
import com.unimar.jornada_kids.model.entity.CriancaRecompensa;
import com.unimar.jornada_kids.model.entity.Recompensa;
import com.unimar.jornada_kids.model.entity.Responsavel;
import com.unimar.jornada_kids.model.enumeration.SituacaoRecompensa;
import com.unimar.jornada_kids.repository.CriancaRecompensaRepository;
import com.unimar.jornada_kids.repository.CriancaRepository;
import com.unimar.jornada_kids.repository.RecompensaRepository;
import com.unimar.jornada_kids.repository.ResponsavelRepository;

@Component
public class RecompensaService {
	
	private CriancaRepository criancaRepository;
	
	private CriancaRecompensaRepository criancaRecompensaRepository;
	
	private RecompensaRepository recompensaRepository;
	
	private ResponsavelRepository responsavelRepository;
	
	private CriancaRecompensaMapper criancaRecompensaMapper;
	
	private RecompensaMapper recompensaMapper;
	
	public RecompensaService(CriancaRepository criancaRepository, CriancaRecompensaRepository criancaRecompensaRepository, CriancaRecompensaMapper criancaRecompensaMapper,
			RecompensaRepository recompensaRepository, ResponsavelRepository responsavelRepository, RecompensaMapper recompensaMapper) {
		this.criancaRepository = criancaRepository;
		this.criancaRecompensaRepository = criancaRecompensaRepository;
		this.recompensaRepository = recompensaRepository;
		this.responsavelRepository = responsavelRepository;
		this.criancaRecompensaMapper = criancaRecompensaMapper;
		this.recompensaMapper = recompensaMapper;
	}
	
	public List<RecompensaResumidaDTO> listarTodas(SituacaoRecompensa situacao) {
		List<Recompensa> recompensas = recompensaRepository.findAll();
		
		if (situacao != null) 
			recompensas = recompensas.stream()
	    			.filter(r -> r.getSituacao() == situacao)
					.toList();
		
		return recompensas.stream()
				.map(recompensaMapper::paraResumidaDTO)
				.toList();
	}
	
	public RecompensaDetalhadaDTO buscarPorId(int id) {
		Recompensa recompensa = recompensaRepository.findById(id)
				.orElseThrow(() -> new UsuarioNotFoundException("Recompensa não encontrada"));
		
		RecompensaDetalhadaDTO recompensaDetalhada = recompensaMapper.paraDetalhadaDTO(recompensa);

		return recompensaDetalhada;
	}
	
	public Recompensa salvar(RecompensaNovaDTO recompensaNova) {
		Recompensa recompensa = recompensaMapper.paraEntity(recompensaNova);
		
		Responsavel responsavel = responsavelRepository.findById(recompensaNova.getIdResponsavel())
				.orElseThrow(() -> new UsuarioNotFoundException("Responsável não encontrado"));
		
		recompensa.setResponsavel(responsavel);
	    
		return recompensaRepository.save(recompensa);
    }
	
	public void deletar(int id) {
		if(!recompensaRepository.existsById(id))
			throw new UsuarioNotFoundException("Recompensa não encontrada");
		
		recompensaRepository.deleteById(id);
	}
	
	public void resgatar(int id, RecompensaResgatadaDTO recompensaResgatada) {
		System.out.println(recompensaResgatada);
		CriancaRecompensa criancaRecompensa = criancaRecompensaMapper.paraEntity(recompensaResgatada);
		
		Recompensa recompensa = recompensaRepository.findById(id)
				.orElseThrow(() -> new UsuarioNotFoundException("Recompensa não encontrada"));
		
		Crianca crianca = criancaRepository.findById(recompensaResgatada.getIdCrianca())
				.orElseThrow(() -> new UsuarioNotFoundException("Criança não encontrada"));
		
		if (recompensa.getSituacao() != SituacaoRecompensa.D) 
	        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Recompensa indisponível");
		
		if (recompensa.getQuantidade() < recompensaResgatada.getQuantidadeResgatada())
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST, 
					"Quantidade de recompensa insuficiente. Restam apenas " + recompensa.getQuantidade() + " unidade(s).");
		
		recompensa.setQuantidade(recompensa.getQuantidade() - criancaRecompensa.getQuantidadeResgatada());
		
		if (recompensa.getQuantidade() == 0)
		    recompensa.setSituacao(SituacaoRecompensa.E);
		
		if (crianca.getPonto() < (recompensa.getPontuacaoNecessaria() * criancaRecompensa.getQuantidadeResgatada()))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pontos insuficientes");
		
		crianca.setPonto(crianca.getPonto() - (recompensa.getPontuacaoNecessaria() * criancaRecompensa.getQuantidadeResgatada()));
		
		criancaRecompensa.setCrianca(crianca);
		criancaRecompensa.setRecompensa(recompensa);
		
		criancaRepository.save(crianca);
		recompensaRepository.save(recompensa);
		criancaRecompensaRepository.save(criancaRecompensa);
	}

}
