package com.unimar.jornada_kids.model.dto.recompensa;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unimar.jornada_kids.model.dto.responsavel.ResponsavelResumidoDTO;

public class RecompensaResumidaDTO {
	
	public RecompensaResumidaDTO() {}
	
	private Integer id;
	
	@JsonProperty("responsavel")
	private ResponsavelResumidoDTO responsavelResumido;
	
	private String titulo;
	
	private long pontuacaoNecessaria;
	
	private int quantidade;
	
	private String situacao;

	public RecompensaResumidaDTO(Integer id, ResponsavelResumidoDTO responsavelResumido, String titulo,
			long pontuacaoNecessaria, int quantidade, String situacao) {
		super();
		this.id = id;
		this.responsavelResumido = responsavelResumido;
		this.titulo = titulo;
		this.pontuacaoNecessaria = pontuacaoNecessaria;
		this.quantidade = quantidade;
		this.situacao = situacao;
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

	@Override
	public String toString() {
		return "RecompensaResumidaDTO [id=" + id + ", responsavelResumido=" + responsavelResumido + ", titulo=" + titulo
				+ ", pontuacaoNecessaria=" + pontuacaoNecessaria + ", quantidade=" + quantidade + ", situacao="
				+ situacao + "]";
	}

}
