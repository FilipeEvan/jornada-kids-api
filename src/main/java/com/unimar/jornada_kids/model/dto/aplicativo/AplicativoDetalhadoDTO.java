package com.unimar.jornada_kids.model.dto.aplicativo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unimar.jornada_kids.model.dto.crianca.CriancaDetalhadaDTO;
import com.unimar.jornada_kids.model.dto.responsavel.ResponsavelDetalhadoDTO;

public class AplicativoDetalhadoDTO {

	public AplicativoDetalhadoDTO() {}
	
	private Integer id;

	@JsonProperty("responsavel")
	private ResponsavelDetalhadoDTO responsavelDetalhado;
	
	@JsonProperty("crianca")
	private CriancaDetalhadaDTO criancaDetalhada;
	
	private String plataforma;
	
	private String identificador;
	
	private String nome;
	
	private Boolean bloqueado;
	
	private long tempoLimite;
	
	private long tempoUsado;
	
	private LocalDateTime criadoEm;

	private LocalDateTime atualizadoEm;

	public AplicativoDetalhadoDTO(Integer id, ResponsavelDetalhadoDTO responsavelDetalhado,
			CriancaDetalhadaDTO criancaDetalhada, String plataforma, String identificador, String nome,
			Boolean bloqueado, long tempoLimite, long tempoUsado, LocalDateTime criadoEm, LocalDateTime atualizadoEm) {
		this.id = id;
		this.responsavelDetalhado = responsavelDetalhado;
		this.criancaDetalhada = criancaDetalhada;
		this.plataforma = plataforma;
		this.identificador = identificador;
		this.nome = nome;
		this.bloqueado = bloqueado;
		this.tempoLimite = tempoLimite;
		this.tempoUsado = tempoUsado;
		this.criadoEm = criadoEm;
		this.atualizadoEm = atualizadoEm;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ResponsavelDetalhadoDTO getResponsavelDetalhado() {
		return responsavelDetalhado;
	}

	public void setResponsavelDetalhado(ResponsavelDetalhadoDTO responsavelDetalhado) {
		this.responsavelDetalhado = responsavelDetalhado;
	}

	public CriancaDetalhadaDTO getCriancaDetalhada() {
		return criancaDetalhada;
	}

	public void setCriancaDetalhada(CriancaDetalhadaDTO criancaDetalhada) {
		this.criancaDetalhada = criancaDetalhada;
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

	public LocalDateTime getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(LocalDateTime criadoEm) {
		this.criadoEm = criadoEm;
	}

	public LocalDateTime getAtualizadoEm() {
		return atualizadoEm;
	}

	public void setAtualizadoEm(LocalDateTime atualizadoEm) {
		this.atualizadoEm = atualizadoEm;
	}

	@Override
	public String toString() {
		return "AplicativoDetalhadoDTO [id=" + id + ", responsavelDetalhado=" + responsavelDetalhado
				+ ", criancaDetalhada=" + criancaDetalhada + ", plataforma=" + plataforma + ", identificador="
				+ identificador + ", nome=" + nome + ", bloqueado=" + bloqueado + ", tempoLimite=" + tempoLimite
				+ ", tempoUsado=" + tempoUsado + ", criadoEm=" + criadoEm + ", atualizadoEm=" + atualizadoEm + "]";
	}
	
}
