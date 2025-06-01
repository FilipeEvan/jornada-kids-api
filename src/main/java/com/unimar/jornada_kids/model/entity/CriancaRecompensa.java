package com.unimar.jornada_kids.model.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class CriancaRecompensa {
	
	public CriancaRecompensa() {}
	
	@Id
    @GeneratedValue
    private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_crianca", referencedColumnName = "id")
	private Crianca crianca;
	
	@ManyToOne
	@JoinColumn(name = "id_recompensa", referencedColumnName = "id")
	private Recompensa recompensa;
	
	private int quantidadeResgatada;
	
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime dataHoraResgate;

	public CriancaRecompensa(Crianca crianca, Recompensa recompensa, int quantidadeResgatada,
			LocalDateTime dataHoraResgate) {
		super();
		this.crianca = crianca;
		this.recompensa = recompensa;
		this.quantidadeResgatada = quantidadeResgatada;
		this.dataHoraResgate = dataHoraResgate;
	}

	public Crianca getCrianca() {
		return crianca;
	}

	public void setCrianca(Crianca crianca) {
		this.crianca = crianca;
	}

	public Recompensa getRecompensa() {
		return recompensa;
	}

	public void setRecompensa(Recompensa recompensa) {
		this.recompensa = recompensa;
	}

	public int getQuantidadeResgatada() {
		return quantidadeResgatada;
	}

	public void setQuantidadeResgatada(int quantidadeResgatada) {
		this.quantidadeResgatada = quantidadeResgatada;
	}

	public LocalDateTime getDataHoraResgate() {
		return dataHoraResgate;
	}

	public void setDataHoraResgate(LocalDateTime dataHoraResgate) {
		this.dataHoraResgate = dataHoraResgate;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "CriancaRecompensa [id=" + id + ", crianca=" + crianca + ", recompensa=" + recompensa
				+ ", quantidadeResgatada=" + quantidadeResgatada + ", dataHoraResgate=" + dataHoraResgate + "]";
	}

}
