package com.unimar.jornada_kids.model.dto.recompensa;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unimar.jornada_kids.model.dto.responsavel.ResponsavelDetalhadoDTO;

public class RecompensaDetalhadaDTO {
	
	public RecompensaDetalhadaDTO() {}
	
	private Integer id;
	
	@JsonProperty("responsavel")
	private ResponsavelDetalhadoDTO responsavelDetalhado;
	
	private String titulo;
	
	private long pontuacaoNecessaria;
	
	private int quantidade;
	
	private String situacao;
	
	private LocalDateTime criadoEm;
	
	private LocalDateTime atualizadoEm;

	public RecompensaDetalhadaDTO(Integer id, ResponsavelDetalhadoDTO responsavelDetalhado, String titulo,
			long pontuacaoNecessaria, int quantidade, String situacao, LocalDateTime criadoEm,
			LocalDateTime atualizadoEm) {
		super();
		this.id = id;
		this.responsavelDetalhado = responsavelDetalhado;
		this.titulo = titulo;
		this.pontuacaoNecessaria = pontuacaoNecessaria;
		this.quantidade = quantidade;
		this.situacao = situacao;
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public long getPontuacaoNecessaria() {
		return pontuacaoNecessaria;
	}

	public void setPontuacaoNecessaria(long pontuacaoNecessaria) {
		this.pontuacaoNecessaria = pontuacaoNecessaria;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
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
		return "RecompensaDetalhadaDTO [id=" + id + ", responsavelDetalhado=" + responsavelDetalhado + ", titulo="
				+ titulo + ", pontuacaoNecessaria=" + pontuacaoNecessaria + ", quantidade=" + quantidade + ", situacao="
				+ situacao + ", criadoEm=" + criadoEm + ", atualizadoEm=" + atualizadoEm + "]";
	}

}
