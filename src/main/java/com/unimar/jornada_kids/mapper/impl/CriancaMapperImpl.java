package com.unimar.jornada_kids.mapper.impl;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Component;

import com.unimar.jornada_kids.mapper.CriancaMapper;
import com.unimar.jornada_kids.mapper.ResponsavelMapper;
import com.unimar.jornada_kids.mapper.UsuarioMapper;
import com.unimar.jornada_kids.model.dto.crianca.CriancaDetalhadaDTO;
import com.unimar.jornada_kids.model.dto.crianca.CriancaNovaDTO;
import com.unimar.jornada_kids.model.dto.crianca.CriancaResumidaDTO;
import com.unimar.jornada_kids.model.entity.Crianca;

@Component
public class CriancaMapperImpl implements CriancaMapper {
	
	private UsuarioMapper usuarioMapper;
	
	private ResponsavelMapper responsavelMapper;
	
	public CriancaMapperImpl(UsuarioMapper usuarioMapper, ResponsavelMapper responsavelMapper) {
		this.usuarioMapper = usuarioMapper;
		this.responsavelMapper = responsavelMapper;
	}
	
	@Override
	public Crianca paraEntity(CriancaNovaDTO dto) {
		Crianca crianca = new Crianca();
		
		crianca.setDataNascimento(dto.getDataNascimento());
		
		return crianca;
	}
	
	@Override
	public CriancaDetalhadaDTO paraDetalhadaDTO(Crianca crianca) {
		CriancaDetalhadaDTO dto = new CriancaDetalhadaDTO();
		
		dto.setId(crianca.getId());
		dto.setUsuarioDetalhado(usuarioMapper.paraDetalhadoDTO(crianca.getUsuario()));
		dto.setDataNascimento(crianca.getDataNascimento());
		dto.setIdade(Period.between(crianca.getDataNascimento(), LocalDate.now()).getYears());
		dto.setNivel(crianca.getNivel());
		dto.setXp(crianca.getXp());
		dto.setXpTotal(crianca.getXpTotal());
		dto.setPonto(crianca.getPonto());
		dto.setResponsavelDetalhado(responsavelMapper.paraDetalhadoDTO(crianca.getResponsavel()));
		
		return dto;
	}
	
	@Override
	public CriancaResumidaDTO paraResumidaDTO(Crianca crianca) {
		CriancaResumidaDTO dto = new CriancaResumidaDTO();
		
		dto.setId(crianca.getId());
		dto.setUsuarioResumido(usuarioMapper.paraResumidoDTO(crianca.getUsuario()));
		dto.setIdade(Period.between(crianca.getDataNascimento(), LocalDate.now()).getYears());
		dto.setNivel(crianca.getNivel());
		dto.setResponsavelResumidoDTO(responsavelMapper.paraResumidoDTO(crianca.getResponsavel()));
		
		return dto;
	}

}
