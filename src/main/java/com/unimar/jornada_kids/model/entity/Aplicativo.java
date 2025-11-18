package com.unimar.jornada_kids.model.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.unimar.jornada_kids.model.enumeration.PlataformaAplicativo;
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
public class Aplicativo {
	
	public Aplicativo() {}
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_responsavel", referencedColumnName = "id")
	private Responsavel responsavel;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_crianca", referencedColumnName = "id")
	private Crianca crianca;
	
	@Enumerated(EnumType.STRING)
	private PlataformaAplicativo plataforma;
	
	private String identificador;
	
	private String nome;
	
	private Boolean bloqueado;
	
	private long tempoLimite;
	
	private long tempoUsado;
	
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime criadoEm;
	
	@LastModifiedDate
	private LocalDateTime atualizadoEm;

	public Aplicativo(Responsavel responsavel, Crianca crianca, PlataformaAplicativo plataforma, String identificador,
			String nome, Boolean bloqueado, long tempoLimite, long tempoUsado, LocalDateTime criadoEm,
			LocalDateTime atualizadoEm) {
		super();
		this.responsavel = responsavel;
		this.crianca = crianca;
		this.plataforma = plataforma;
		this.identificador = identificador;
		this.nome = nome;
		this.bloqueado = bloqueado;
		this.tempoLimite = tempoLimite;
		this.tempoUsado = tempoUsado;
		this.criadoEm = criadoEm;
		this.atualizadoEm = atualizadoEm;
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

	public PlataformaAplicativo getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(PlataformaAplicativo plataforma) {
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

	public void setTempoLimite(long tempoLiimite) {
		this.tempoLimite = tempoLiimite;
	}

	public long getTempoUsado() {
		return tempoUsado;
	}

	public void setTempoUsado(long tempoUsado) {
		this.tempoUsado = tempoUsado;
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
		return "Aplicativo [id=" + id + ", responsavel=" + responsavel + ", crianca=" + crianca + ", plataforma="
				+ plataforma + ", identificador=" + identificador + ", nome=" + nome + ", bloqueado=" + bloqueado
				+ ", tempoLimite=" + tempoLimite + ", tempoUsado=" + tempoUsado + ", criadoEm=" + criadoEm
				+ ", atualizadoEm=" + atualizadoEm + "]";
	}

}
