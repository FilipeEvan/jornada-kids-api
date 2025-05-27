package com.unimar.jornada_kids.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.unimar.jornada_kids.exception.UsuarioNotFoundException;
import com.unimar.jornada_kids.mapper.RecompensaMapper;
import com.unimar.jornada_kids.model.dto.recompensa.RecompensaDetalhadaDTO;
import com.unimar.jornada_kids.model.dto.recompensa.RecompensaNovaDTO;
import com.unimar.jornada_kids.model.dto.recompensa.RecompensaResumidaDTO;
import com.unimar.jornada_kids.model.entity.Recompensa;
import com.unimar.jornada_kids.model.entity.Responsavel;
import com.unimar.jornada_kids.repository.RecompensaRepository;
import com.unimar.jornada_kids.repository.ResponsavelRepository;

@Component
public class RecompensaService {
	
	private RecompensaRepository recompensaRepository;
	
	private ResponsavelRepository responsavelRepository;
	
	private RecompensaMapper recompensaMapper;
	
	public RecompensaService(RecompensaRepository recompensaRepository, ResponsavelRepository responsavelRepository, RecompensaMapper recompensaMapper) {
		this.recompensaRepository = recompensaRepository;
		this.responsavelRepository = responsavelRepository;
		this.recompensaMapper = recompensaMapper;
	}
	
	public List<RecompensaResumidaDTO> listarTodas() {
		List<Recompensa> recompensas = recompensaRepository.findAll();
		
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

}
