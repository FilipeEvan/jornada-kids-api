package com.unimar.jornada_kids.mapper.impl;

import org.springframework.stereotype.Component;

import com.unimar.jornada_kids.mapper.ResponsavelMapper;
import com.unimar.jornada_kids.mapper.UsuarioMapper;
import com.unimar.jornada_kids.model.dto.responsavel.ResponsavelDetalhadoDTO;
import com.unimar.jornada_kids.model.dto.responsavel.ResponsavelNovoDTO;
import com.unimar.jornada_kids.model.dto.responsavel.ResponsavelResumidoDTO;
import com.unimar.jornada_kids.model.entity.Responsavel;

@Component
public class ResponsavelMapperImpl implements ResponsavelMapper {
	
	private UsuarioMapper usuarioMapper;
	
	public ResponsavelMapperImpl(UsuarioMapper usuarioMapper) {
		this.usuarioMapper = usuarioMapper;
	}
	
	@Override
	public Responsavel paraEntity(ResponsavelNovoDTO dto) {
		Responsavel responsavel = new Responsavel();
		
		responsavel.setTipo(dto.getTipo());
		
		return responsavel;
	}
	
	@Override
	public ResponsavelDetalhadoDTO paraDetalhadoDTO(Responsavel responsavel) {
		ResponsavelDetalhadoDTO dto = new ResponsavelDetalhadoDTO();
		
		dto.setId(responsavel.getId());
		dto.setUsuarioDetalhado(usuarioMapper.paraDetalhadoDTO(responsavel.getUsuario()));
		dto.setCodigo(responsavel.getCodigo());
		dto.setTipo(responsavel.getTipo().obterRotulo());
		
		return dto;
	}
	
	@Override
	public ResponsavelResumidoDTO paraResumidoDTO(Responsavel responsavel) {
		ResponsavelResumidoDTO dto = new ResponsavelResumidoDTO();
		
		dto.setId(responsavel.getId());
		dto.setUsuarioResumido(usuarioMapper.paraResumidoDTO(responsavel.getUsuario()));
		dto.setCodigo(responsavel.getCodigo());
		dto.setTipo(responsavel.getTipo().obterRotulo());
		
		return dto;
	}

}
