package com.unimar.jornada_kids.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.unimar.jornada_kids.exception.UsuarioNotFoundException;
import com.unimar.jornada_kids.mapper.CriancaMapper;
import com.unimar.jornada_kids.mapper.ResponsavelMapper;
import com.unimar.jornada_kids.model.dto.usuario.UsuarioAutenticadoDTO;
import com.unimar.jornada_kids.model.entity.Usuario;
import com.unimar.jornada_kids.model.enumeration.TipoUsuario;
import com.unimar.jornada_kids.repository.UsuarioRepository;

@Component
public class UsuarioService {
	
	private UsuarioRepository usuarioRepository;
	
	private CriancaMapper criancaMapper;
		
	private ResponsavelMapper responsavelMapper;

	public UsuarioService(UsuarioRepository usuarioRepository, 
			CriancaMapper criancaMapper, ResponsavelMapper responsavelMapper) {
		this.usuarioRepository = usuarioRepository;
		this.criancaMapper = criancaMapper;
		this.responsavelMapper = responsavelMapper;
	}
	
	public Object autenticar(UsuarioAutenticadoDTO usuarioAutenticado) {
		Usuario usuario = usuarioRepository.findByNomeUsuario(usuarioAutenticado.getNomeUsuario())
				.orElseThrow(() -> new UsuarioNotFoundException("Responsável não encontrado"));

		if (!usuario.getSenha().equals(usuarioAutenticado.getSenha()))
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Senha inválida");
		
		if (usuario.getTipo().equals(TipoUsuario.C) && usuario.getCrianca() != null)
			return criancaMapper.paraDetalhadaDTO(usuario.getCrianca());
		
		if (usuario.getTipo().equals(TipoUsuario.R) && usuario.getResponsavel() != null)
			return responsavelMapper.paraDetalhadoDTO(usuario.getResponsavel());
		
		
		throw new UsuarioNotFoundException("Criança ou Responsável não encontrado");
	}

}
