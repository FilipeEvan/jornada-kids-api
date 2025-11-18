package com.unimar.jornada_kids.model.dto.aplicativo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unimar.jornada_kids.model.dto.crianca.CriancaResumidaDTO;
import com.unimar.jornada_kids.model.dto.responsavel.ResponsavelResumidoDTO;

public class AplicativoResumidoDTO {

	public AplicativoResumidoDTO() {}

	private Integer id;

	@JsonProperty("responsavel")
	private ResponsavelResumidoDTO responsavelResumido;
	
	@JsonProperty("crianca")
	private CriancaResumidaDTO criancaResumida;
	
	private String plataforma;
	
	private String identificador;
	
	private String nome;
	
	private Boolean bloqueado;
	
	private long tempoLimite;
	
	private long tempoUsado;

	public AplicativoResumidoDTO(Integer id, ResponsavelResumidoDTO responsavelResumido,
			CriancaResumidaDTO criancaResumida, String plataforma, String identificador, String nome, Boolean bloqueado,
			long tempoLimite, long tempoUsado) {
		this.id = id;
		this.responsavelResumido = responsavelResumido;
		this.criancaResumida = criancaResumida;
		this.plataforma = plataforma;
		this.identificador = identificador;
		this.nome = nome;
		this.bloqueado = bloqueado;
		this.tempoLimite = tempoLimite;
		this.tempoUsado = tempoUsado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ResponsavelResumidoDTO getResponsavelResumido() {
		return responsavelResumido;
	}

	public void setResponsavelResumido(ResponsavelResumidoDTO responsavelResumido) {
		this.responsavelResumido = responsavelResumido;
	}

	public CriancaResumidaDTO getCriancaResumida() {
		return criancaResumida;
	}

	public void setCriancaResumida(CriancaResumidaDTO criancaResumida) {
		this.criancaResumida = criancaResumida;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public long getTempoLimite() {
		return tempoLimite;
	}

	public void setTempoLimite(long tempoLimite) {
		this.tempoLimite = tempoLimite;
	}

	public long getTempoUsado() {
		return tempoUsado;
	}

	public void setTempoUsado(long tempoUsado) {
		this.tempoUsado = tempoUsado;
	}

	@Override
	public String toString() {
		return "AplicativoResumidoDTO [id=" + id + ", responsavelResumido=" + responsavelResumido + ", criancaResumida="
				+ criancaResumida + ", plataforma=" + plataforma + ", identificador=" + identificador + ", nome=" + nome
				+ ", bloqueado=" + bloqueado + ", tempoLimite=" + tempoLimite + ", tempoUsado=" + tempoUsado + "]";
	}
	
}
