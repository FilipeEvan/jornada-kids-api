package com.unimar.jornada_kids.mapper.impl;

import org.springframework.stereotype.Component;

import com.unimar.jornada_kids.mapper.UsuarioMapper;
import com.unimar.jornada_kids.model.dto.usuario.UsuarioDetalhadoDTO;
import com.unimar.jornada_kids.model.dto.usuario.UsuarioNovoDTO;
import com.unimar.jornada_kids.model.dto.usuario.UsuarioResumidoDTO;
import com.unimar.jornada_kids.model.entity.Usuario;

@Component
public class UsuarioMapperImpl implements UsuarioMapper {
	
	@Override
	public Usuario paraEntity(UsuarioNovoDTO dto) {
		Usuario usuario = new Usuario();
		
		usuario.setNomeCompleto(dto.getNomeCompleto());
		usuario.setNomeUsuario(dto.getNomeUsuario());
		usuario.setEmail(dto.getEmail());
		usuario.setTelefone(dto.getTelefone());
		usuario.setSenha(dto.getSenha());
		usuario.setTipo(dto.getTipo());
		
		return usuario;
	}
	
	@Override
	public UsuarioDetalhadoDTO paraDetalhadoDTO(Usuario usuario) {
		UsuarioDetalhadoDTO dto = new UsuarioDetalhadoDTO();
		
		dto.setId(usuario.getId());
		dto.setNomeCompleto(usuario.getNomeCompleto());
		dto.setNomeUsuario(usuario.getNomeUsuario());
		dto.setEmail(usuario.getEmail());
		dto.setTelefone(usuario.getTelefone());
		dto.setTipo(usuario.getTipo().obterRotulo());
		dto.setCriadoEm(usuario.getCriadoEm());
		dto.setAtualizadoEm(usuario.getAtualizadoEm());
		
		return dto;
	}
	
	@Override
	public UsuarioResumidoDTO paraResumidoDTO(Usuario usuario) {
		UsuarioResumidoDTO dto = new UsuarioResumidoDTO();
		
		dto.setId(usuario.getId());
		dto.setNomeCompleto(usuario.getNomeCompleto());
		
		return dto;
	}

}
