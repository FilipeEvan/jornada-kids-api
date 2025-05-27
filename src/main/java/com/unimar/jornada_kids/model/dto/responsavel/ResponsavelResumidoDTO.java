package com.unimar.jornada_kids.model.dto.responsavel;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unimar.jornada_kids.model.dto.usuario.UsuarioResumidoDTO;

@JsonFilter("ResponsavelFilter")
public class ResponsavelResumidoDTO {
	
	public ResponsavelResumidoDTO() {}
	
	private Integer id;
	
	@JsonProperty("usuario")
	private UsuarioResumidoDTO usuarioResumido;
	
	private String codigo;
	
	private String tipo;

	public ResponsavelResumidoDTO(Integer id, UsuarioResumidoDTO usuarioResumido, String codigo, String tipo) {
		super();
		this.id = id;
		this.usuarioResumido = usuarioResumido;
		this.codigo = codigo;
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UsuarioResumidoDTO getUsuarioResumido() {
		return usuarioResumido;
	}

	public void setUsuarioResumido(UsuarioResumidoDTO usuarioResumidoDTO) {
		this.usuarioResumido = usuarioResumidoDTO;
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
		return "ResponsavelResumidoDTO [id=" + id + ", usuarioResumido=" + usuarioResumido + ", codigo=" + codigo
				+ ", tipo=" + tipo + "]";
	}

}
