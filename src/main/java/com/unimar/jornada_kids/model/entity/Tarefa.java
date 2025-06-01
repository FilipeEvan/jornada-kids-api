package com.unimar.jornada_kids.model.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.unimar.jornada_kids.model.enumeration.PrioridadeTarefa;
import com.unimar.jornada_kids.model.enumeration.SituacaoTarefa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Tarefa { 
	
	public Tarefa() {}
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_responsavel", referencedColumnName = "id")
	private Responsavel responsavel;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_crianca", referencedColumnName = "id")
	private Crianca crianca;
	
	private String titulo;
	
	private long pontuacaoTotal;
	
	private long pontuacaoConquistada;
	
	private int estrela;
	
	@Enumerated(EnumType.STRING)
	private PrioridadeTarefa prioridade;
	
	@Enumerated(EnumType.STRING)
	private SituacaoTarefa situacao;
	
	private LocalDateTime dataHoraLimite;
	
	private LocalDateTime dataHoraConclusao; 
	
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime criadoEm;
	
	@LastModifiedDate
	private LocalDateTime atualizadoEm;

	public Tarefa(Responsavel responsavel, Crianca crianca, String titulo, long pontuacaoTotal, long pontuacaoConquistada, 
			int estrela, PrioridadeTarefa prioridade, SituacaoTarefa situacao, LocalDateTime dataHoraLimite, LocalDateTime dataHoraConclusao) {
		super();
		this.responsavel = responsavel;
		this.crianca = crianca;
		this.titulo = titulo;
		this.pontuacaoTotal = pontuacaoTotal;
		this.pontuacaoConquistada = pontuacaoConquistada;
		this.estrela = estrela;
		this.prioridade = prioridade;
		this.situacao = situacao;
		this.dataHoraLimite = dataHoraLimite;
		this.dataHoraConclusao = dataHoraConclusao;
	}

	public Integer getId() {
		return id;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public Crianca getCrianca() {
		return crianca;
	}

	public void setCrianca(Crianca crianca) {
		this.crianca = crianca;
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

	public long getPontuacaoConquistada() {
		return pontuacaoConquistada;
	}

	public void setPontuacaoConquistada(long pontuacaoConquistada) {
		this.pontuacaoConquistada = pontuacaoConquistada;
	}

	public int getEstrela() {
		return estrela;
	}

	public void setEstrela(int estrela) {
		this.estrela = estrela;
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

	public LocalDateTime getDataHoraConclusao() {
		return dataHoraConclusao;
	}

	public void setDataHoraConclusao(LocalDateTime dataHoraConclusao) {
		this.dataHoraConclusao = dataHoraConclusao;
	}

	public LocalDateTime getCriadoEm() {
		return criadoEm;
	}

	public LocalDateTime getAtualizadoEm() {
		return atualizadoEm;
	}

	@Override
	public String toString() {
		return "Tarefa [id=" + id + ", responsavel=" + responsavel + ", crianca=" + crianca + ", titulo=" + titulo
				+ ", pontuacaoTotal=" + pontuacaoTotal + ", pontuacaoConquistada=" + pontuacaoConquistada + ", estrela="
				+ estrela + ", prioridade=" + prioridade + ", situacao=" + situacao + ", dataHoraLimite="
				+ dataHoraLimite + ", dataHoraConclusao=" + dataHoraConclusao + ", criadoEm=" + criadoEm
				+ ", atualizadoEm=" + atualizadoEm + "]";
	}

}
