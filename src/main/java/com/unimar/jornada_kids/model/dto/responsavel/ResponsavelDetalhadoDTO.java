package com.unimar.jornada_kids.model.dto.responsavel;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unimar.jornada_kids.model.dto.usuario.UsuarioDetalhadoDTO;

public class ResponsavelDetalhadoDTO {
	
	public ResponsavelDetalhadoDTO() {}
	
	private Integer id;
	
	@JsonProperty("usuario")
	private UsuarioDetalhadoDTO usuarioDetalhado;
	
	private String codigo;
	
	private String tipo;

	public ResponsavelDetalhadoDTO(Integer id, UsuarioDetalhadoDTO usuarioDetalhado, String codigo, String tipo) {
		super();
		this.id = id;
		this.usuarioDetalhado = usuarioDetalhado;
		this.codigo = codigo;
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UsuarioDetalhadoDTO getUsuarioDetalhado() {
		return usuarioDetalhado;
	}

	public void setUsuarioDetalhado(UsuarioDetalhadoDTO usuarioDetalhado) {
		this.usuarioDetalhado = usuarioDetalhado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "ResponsavelDetalhadoDTO [id=" + id + ", usuarioDetalhado=" + usuarioDetalhado + ", codigo=" + codigo
				+ ", tipo=" + tipo + "]";
	}

}
