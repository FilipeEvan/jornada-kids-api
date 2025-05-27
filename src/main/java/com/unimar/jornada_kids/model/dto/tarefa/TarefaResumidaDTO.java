package com.unimar.jornada_kids.model.dto.tarefa;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unimar.jornada_kids.model.dto.crianca.CriancaResumidaDTO;
import com.unimar.jornada_kids.model.dto.responsavel.ResponsavelResumidoDTO;

@JsonFilter("TarefaFilter")
public class TarefaResumidaDTO {
	
	public TarefaResumidaDTO() {}
	
	private Integer id;
	
	@JsonProperty("responsavel")
	private ResponsavelResumidoDTO responsavelResumido;
	
	@JsonProperty("crianca")
	private CriancaResumidaDTO criancaResumida;
	
	private String titulo;
	
	private long pontuacaoTotal;
		
	private String prioridade;
	
	private String situacao;
	
	private LocalDateTime dataHoraLimite;

	public TarefaResumidaDTO(Integer id, ResponsavelResumidoDTO responsavelResumido, CriancaResumidaDTO criancaResumida,
			String titulo, long pontuacaoTotal, String prioridade, String situacao, LocalDateTime dataHoraLimite) {
		super();
		this.id = id;
		this.responsavelResumido = responsavelResumido;
		this.criancaResumida = criancaResumida;
		this.titulo = titulo;
		this.pontuacaoTotal = pontuacaoTotal;
		this.prioridade = prioridade;
		this.situacao = situacao;
		this.dataHoraLimite = dataHoraLimite;
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public long getPontuacaoTotal() {
		return pontuacaoTotal;
	}

	public void setPontuacaoTotal(long pontuacaoTotal) {
		this.pontuacaoTotal = pontuacaoTotal;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public LocalDateTime getDataHoraLimite() {
		return dataHoraLimite;
	}

	public void setDataHoraLimite(LocalDateTime dataHoraLimite) {
		this.dataHoraLimite = dataHoraLimite;
	}

	@Override
	public String toString() {
		return "TarefaResumidaDTO [id=" + id + ", responsavelResumido=" + responsavelResumido + ", criancaResumida="
				+ criancaResumida + ", titulo=" + titulo + ", pontuacaoTotal=" + pontuacaoTotal + ", prioridade=" + prioridade 
				+ ", situacao=" + situacao + ", dataHoraLimite=" + dataHoraLimite + "]";
	}

}
