package com.unimar.jornada_kids.mapper.impl;

import org.springframework.stereotype.Component;

import com.unimar.jornada_kids.mapper.CriancaMapper;
import com.unimar.jornada_kids.mapper.CriancaRecompensaMapper;
import com.unimar.jornada_kids.mapper.RecompensaMapper;
import com.unimar.jornada_kids.model.dto.crianca_recompensa.CriancaRecompensaDetalhadaDTO;
import com.unimar.jornada_kids.model.dto.crianca_recompensa.RecompensaResgatadaDTO;
import com.unimar.jornada_kids.model.entity.CriancaRecompensa;

@Component
public class CriancaRecompensaMapperImpl implements CriancaRecompensaMapper {
	
	private CriancaMapper criancaMapper;
	
	private RecompensaMapper recompensaMapper;
	
	public CriancaRecompensaMapperImpl(CriancaMapper criancaMapper, RecompensaMapper recompensaMapper) {
		this.criancaMapper = criancaMapper;
		this.recompensaMapper = recompensaMapper;
	}

	@Override
	public CriancaRecompensa paraEntity(RecompensaResgatadaDTO dto) {
		CriancaRecompensa criancaRecompensa = new CriancaRecompensa();
		
		criancaRecompensa.setQuantidadeResgatada(dto.getQuantidadeResgatada());
		
		return criancaRecompensa;
	}

	@Override
	public CriancaRecompensaDetalhadaDTO paraDetalhadaDTO(CriancaRecompensa criancaRecompensa) {
		CriancaRecompensaDetalhadaDTO dto = new CriancaRecompensaDetalhadaDTO();
		
		dto.setId(criancaRecompensa.getId());
		dto.setCriancaDetalhada(criancaMapper.paraDetalhadaDTO(criancaRecompensa.getCrianca()));
		dto.setRecompensaDetalhada(recompensaMapper.paraDetalhadaDTO(criancaRecompensa.getRecompensa()));
		dto.setId(criancaRecompensa.getId());
		dto.setId(criancaRecompensa.getId());
		
		return dto;
	}

}
