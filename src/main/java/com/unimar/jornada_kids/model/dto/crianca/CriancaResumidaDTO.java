package com.unimar.jornada_kids.model.dto.crianca;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unimar.jornada_kids.model.dto.responsavel.ResponsavelResumidoDTO;
import com.unimar.jornada_kids.model.dto.usuario.UsuarioResumidoDTO;

@JsonFilter("CriancaFilter")
public class CriancaResumidaDTO {
	
	public CriancaResumidaDTO() {}
	
	private Integer id;
	
	@JsonProperty("usuario")
	private UsuarioResumidoDTO usuarioResumido;
	
	private int idade;
	
	private int nivel;
	
	private long ponto;
	
	@JsonProperty("responsavel")
	private ResponsavelResumidoDTO responsavelResumidoDTO;

	public CriancaResumidaDTO(Integer id, UsuarioResumidoDTO usuarioResumido, int idade, int nivel, long ponto,
			ResponsavelResumidoDTO responsavelResumidoDTO) {
		super();
		this.id = id;
		this.usuarioResumido = usuarioResumido;
		this.idade = idade;
		this.nivel = nivel;
		this.ponto = ponto;
		this.responsavelResumidoDTO = responsavelResumidoDTO;
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

	public void setUsuarioResumido(UsuarioResumidoDTO usuarioResumido) {
		this.usuarioResumido = usuarioResumido;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	public long getPonto() {
		return ponto;
	}

	public void setPonto(long ponto) {
		this.ponto = ponto;
	}

	public ResponsavelResumidoDTO getResponsavelResumidoDTO() {
		return responsavelResumidoDTO;
	}

	public void setResponsavelResumidoDTO(ResponsavelResumidoDTO responsavelResumidoDTO) {
		this.responsavelResumidoDTO = responsavelResumidoDTO;
	}

	@Override
	public String toString() {
		return "CriancaResumidaDTO [id=" + id + ", usuarioResumido=" + usuarioResumido + ", idade=" + idade + ", nivel="
				+ nivel + ", ponto=" + ponto + ", responsavelResumidoDTO=" + responsavelResumidoDTO + "]";
	}

}
