package com.unimar.jornada_kids.mapper;

import com.unimar.jornada_kids.model.dto.usuario.UsuarioDetalhadoDTO;
import com.unimar.jornada_kids.model.dto.usuario.UsuarioNovoDTO;
import com.unimar.jornada_kids.model.dto.usuario.UsuarioResumidoDTO;
import com.unimar.jornada_kids.model.entity.Usuario;

public interface UsuarioMapper {
	Usuario paraEntity(UsuarioNovoDTO usuarioNovo);
	UsuarioDetalhadoDTO paraDetalhadoDTO(Usuario usuario);
	UsuarioResumidoDTO paraResumidoDTO(Usuario usuario);
}
