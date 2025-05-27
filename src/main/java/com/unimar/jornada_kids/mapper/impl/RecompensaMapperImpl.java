package com.unimar.jornada_kids.mapper.impl;

import org.springframework.stereotype.Component;

import com.unimar.jornada_kids.mapper.RecompensaMapper;
import com.unimar.jornada_kids.mapper.ResponsavelMapper;
import com.unimar.jornada_kids.model.dto.recompensa.RecompensaDetalhadaDTO;
import com.unimar.jornada_kids.model.dto.recompensa.RecompensaNovaDTO;
import com.unimar.jornada_kids.model.dto.recompensa.RecompensaResumidaDTO;
import com.unimar.jornada_kids.model.entity.Recompensa;

@Component
public class RecompensaMapperImpl implements RecompensaMapper {
	
	private ResponsavelMapper responsavelMapper;
	
	public RecompensaMapperImpl(ResponsavelMapper responsavelMapper) {
		this.responsavelMapper = responsavelMapper;
	}

	@Override
	public Recompensa paraEntity(RecompensaNovaDTO dto) {
		Recompensa recompensa = new Recompensa();
		
		recompensa.setTitulo(dto.getTitulo());
		recompensa.setPontuacaoNecessaria(dto.getPontuacaoNecessaria());
		recompensa.setQuantidade(dto.getQuantidade());
		recompensa.setSituacao(dto.getSituacao());
		
		return recompensa;
	}

	@Override
	public RecompensaDetalhadaDTO paraDetalhadaDTO(Recompensa recompensa) {
		RecompensaDetalhadaDTO dto = new RecompensaDetalhadaDTO();
		
		dto.setId(recompensa.getId());
		dto.setResponsavelDetalhado(responsavelMapper.paraDetalhadoDTO(recompensa.getResponsavel()));
		dto.setTitulo(recompensa.getTitulo());
		dto.setPontuacaoNecessaria(recompensa.getPontuacaoNecessaria());
		dto.setQuantidade(recompensa.getQuantidade());
		dto.setSituacao(recompensa.getSituacao().obterRotulo());
		dto.setCriadoEm(recompensa.getCriadoEm());
		dto.setAtualizadoEm(recompensa.getAtualizadoEm());
		
		return dto;
	}

	@Override
	public RecompensaResumidaDTO paraResumidaDTO(Recompensa recompensa) {
		RecompensaResumidaDTO dto = new RecompensaResumidaDTO();
		
		dto.setId(recompensa.getId());
		dto.setResponsavelResumido(responsavelMapper.paraResumidoDTO(recompensa.getResponsavel()));
		dto.setTitulo(recompensa.getTitulo());
		dto.setPontuacaoNecessaria(recompensa.getPontuacaoNecessaria());
		dto.setQuantidade(recompensa.getQuantidade());
		dto.setSituacao(recompensa.getSituacao().obterRotulo());
		
		return dto;
	}

}
