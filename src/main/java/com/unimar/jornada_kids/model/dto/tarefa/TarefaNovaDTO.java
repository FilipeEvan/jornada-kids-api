package com.unimar.jornada_kids.model.dto.tarefa;

import java.time.LocalDateTime;

import com.unimar.jornada_kids.model.enumeration.PrioridadeTarefa;
import com.unimar.jornada_kids.model.enumeration.SituacaoTarefa;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class TarefaNovaDTO {
	
	public TarefaNovaDTO() {}
	
	@NotNull(message = "O id do responsável não pode ser nulo")
	private Integer idResponsavel;
	
	@NotNull(message = "O id da criança não pode ser nulo")
	private Integer idCrianca;
	
	@NotBlank(message = "O título não pode estar em branco")
	@Size(min = 2, message = "O título deve ter pelo menos 2 caracteres")
	private String titulo;
	
	@NotNull(message = "A pontuação total não pode ser nula")
	@Positive(message = "A pontuação total não pode ser zero ou negativa")
	private long pontuacaoTotal;
	
	@NotNull(message = "A prioridade não pode ser nula")
	private PrioridadeTarefa prioridade;
	
	@NotNull(message = "A situação da tarefa não pode ser nula")
	private SituacaoTarefa situacao;
	
	@NotNull(message = "A data e hora limite não pode ser nula")
	@Future(message = "A data e hora limite deve ser no futuro")
	private LocalDateTime dataHoraLimite;

	public TarefaNovaDTO(Integer idResponsavel, Integer idCrianca, String titulo, long pontuacaoTotal,
			PrioridadeTarefa prioridade, SituacaoTarefa situacao, LocalDateTime dataHoraLimite) {
		super();
		this.idResponsavel = idResponsavel;
		this.idCrianca = idCrianca;
		this.titulo = titulo;
		this.pontuacaoTotal = pontuacaoTotal;
		this.prioridade = prioridade;
		this.situacao = situacao;
		this.dataHoraLimite = dataHoraLimite;
	}

	public Integer getIdResponsavel() {
		return idResponsavel;
	}

	public void setIdResponsavel(Integer idResponsavel) {
		this.idResponsavel = idResponsavel;
	}

	public Integer getIdCrianca() {
		return idCrianca;
	}

	public void setIdCrianca(Integer idCrianca) {
		this.idCrianca = idCrianca;
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

	public PrioridadeTarefa getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(PrioridadeTarefa prioridade) {
		this.prioridade = prioridade;
	}

	public SituacaoTarefa getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoTarefa situacao) {
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
		return "TarefaNovaDTO [idResponsavel=" + idResponsavel + ", idCrianca=" + idCrianca + ", titulo=" + titulo
				+ ", pontuacaoTotal=" + pontuacaoTotal + ", prioridade=" + prioridade + ", situacao=" + situacao
				+ ", dataHoraLimite=" + dataHoraLimite + "]";
	}

}
