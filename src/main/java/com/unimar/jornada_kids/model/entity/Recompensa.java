package com.unimar.jornada_kids.model.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.unimar.jornada_kids.model.enumeration.SituacaoRecompensa;

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
public class Recompensa {
	
	public Recompensa() {}
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_responsavel", referencedColumnName = "id")
	private Responsavel responsavel;
	
	private String titulo;
	
	private long pontuacaoNecessaria;
	
	private int quantidade;
	
	@Enumerated(EnumType.STRING)
	private SituacaoRecompensa situacao;
	
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime criadoEm;
	
	@LastModifiedDate
	private LocalDateTime atualizadoEm;
	
	public Recompensa(Responsavel responsavel, String titulo, long pontuacaoNecessaria, int quantidade, SituacaoRecompensa situacao) {
		super();
		this.responsavel = responsavel;
		this.titulo = titulo;
		this.pontuacaoNecessaria = pontuacaoNecessaria;
		this.quantidade = quantidade;
		this.situacao = situacao;
	}


	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
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

	public SituacaoRecompensa getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoRecompensa situacao) {
		this.situacao = situacao;
	}

	public Integer getId() {
		return id;
	}

	public LocalDateTime getCriadoEm() {
		return criadoEm;
	}

	public LocalDateTime getAtualizadoEm() {
		return atualizadoEm;
	}


	@Override
	public String toString() {
		return "Recompensa [id=" + id + ", responsavel=" + responsavel + ", titulo=" + titulo + ", pontuacaoNecessaria="
				+ pontuacaoNecessaria + ", quantidade=" + quantidade + ", situacao=" + situacao + ", criadoEm="
				+ criadoEm + ", atualizadoEm=" + atualizadoEm + "]";
	}

}
