package com.unimar.jornada_kids.model.dto.responsavel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unimar.jornada_kids.model.dto.usuario.UsuarioNovoDTO;
import com.unimar.jornada_kids.model.enumeration.TipoResponsavel;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class ResponsavelNovoDTO {
	
	public ResponsavelNovoDTO() {}
	
	@JsonProperty("usuario")
	@NotNull(message = "O usuário não pode ser nulo")
	@Valid
	private UsuarioNovoDTO usuarioNovo;
	
	@NotNull(message = "O tipo de responsável não pode ser nulo")
	private TipoResponsavel tipo;

	public ResponsavelNovoDTO(UsuarioNovoDTO usuarioNovo, TipoResponsavel tipo) {
		super();
		this.usuarioNovo = usuarioNovo;
		this.tipo = tipo;
	}
	
	public UsuarioNovoDTO getUsuarioNovo() {
		return usuarioNovo;
	}
	
	public void setUsuarioNovo(UsuarioNovoDTO usuarioNovo) {
		this.usuarioNovo = usuarioNovo;
	}
	
	public TipoResponsavel getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoResponsavel tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "ResponsavelNovoDTO [usuarioNovo=" + usuarioNovo + ", tipo=" + tipo + "]";
	}

}
