package com.unimar.jornada_kids.mapper.impl;

import org.springframework.stereotype.Component;

import com.unimar.jornada_kids.mapper.AplicativoMapper;
import com.unimar.jornada_kids.mapper.CriancaMapper;
import com.unimar.jornada_kids.mapper.ResponsavelMapper;
import com.unimar.jornada_kids.model.dto.aplicativo.AplicativoDetalhadoDTO;
import com.unimar.jornada_kids.model.dto.aplicativo.AplicativoNovoDTO;
import com.unimar.jornada_kids.model.dto.aplicativo.AplicativoResumidoDTO;
import com.unimar.jornada_kids.model.entity.Aplicativo;

@Component
public class AplicativoMapperImpl implements AplicativoMapper {
	
	private CriancaMapper criancaMapper;
	
	private ResponsavelMapper responsavelMapper;
	
	public AplicativoMapperImpl(CriancaMapper criancaMapper, ResponsavelMapper responsavelMapper) {
		this.criancaMapper = criancaMapper;
		this.responsavelMapper = responsavelMapper;
	}

	@Override
	public Aplicativo paraEntity(AplicativoNovoDTO dto) {
		Aplicativo aplicativo = new Aplicativo();
		
		aplicativo.setPlataforma(dto.getPlataforma());
		aplicativo.setIdentificador(dto.getIdentificador());
		aplicativo.setNome(dto.getNome());
		aplicativo.setBloqueado(false);
		aplicativo.setTempoUsado(dto.getTempoUsado());
		
		return aplicativo;
	}

	@Override
	public AplicativoDetalhadoDTO paraDetalhadoDTO(Aplicativo aplicativo) {
		AplicativoDetalhadoDTO dto = new AplicativoDetalhadoDTO();
		
		dto.setId(aplicativo.getId());
		dto.setResponsavelDetalhado(responsavelMapper.paraDetalhadoDTO(aplicativo.getResponsavel()));
		dto.setCriancaDetalhada(criancaMapper.paraDetalhadaDTO(aplicativo.getCrianca()));
		dto.setPlataforma(aplicativo.getPlataforma().obterRotulo());
		dto.setIdentificador(aplicativo.getIdentificador());
		dto.setNome(aplicativo.getNome());
		dto.setBloqueado(aplicativo.getBloqueado());
		dto.setTempoLimite(aplicativo.getTempoLimite());
		dto.setTempoUsado(aplicativo.getTempoUsado());
		dto.setCriadoEm(aplicativo.getCriadoEm());
		dto.setAtualizadoEm(aplicativo.getAtualizadoEm());
		
		return dto;
	}

	@Override
	public AplicativoResumidoDTO paraResumidoDTO(Aplicativo aplicativo) {
		AplicativoResumidoDTO dto = new AplicativoResumidoDTO();
		
		dto.setId(aplicativo.getId());
		dto.setResponsavelResumido(responsavelMapper.paraResumidoDTO(aplicativo.getResponsavel()));
		dto.setCriancaResumida(criancaMapper.paraResumidaDTO(aplicativo.getCrianca()));
		dto.setPlataforma(aplicativo.getPlataforma().obterRotulo());
		dto.setIdentificador(aplicativo.getIdentificador());
		dto.setNome(aplicativo.getNome());
		dto.setBloqueado(aplicativo.getBloqueado());
		dto.setTempoLimite(aplicativo.getTempoLimite());
		dto.setTempoUsado(aplicativo.getTempoUsado());
		
		return dto;
	}

}
