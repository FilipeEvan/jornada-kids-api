package com.unimar.jornada_kids.model.dto.crianca_recompensa;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CriancaRecompensaNovaDTO {
	
	public CriancaRecompensaNovaDTO() {}
	
	@NotNull(message = "O id da criança não pode ser nulo")
	private Integer idCrianca;
	
	@NotNull(message = "O id da recompensa não pode ser nulo")
	private Integer idRecompensa;
	
	@NotNull(message = "A quantidade resgatada não pode ser nula")
	@Positive(message = "A quantidade resgatada não pode ser zero ou negativa")
	private int quantidadeResgatada;
	
	@NotNull(message = "A data e hora do resgate não pode ser nula")
	@Future(message = "A data e hora do resgate deve ser no futuro")
	private LocalDateTime dataHoraResgate;

	public CriancaRecompensaNovaDTO(Integer idCrianca, Integer idRecompensa, int quantidadeResgatada, LocalDateTime dataHoraResgate) {
		super();
		this.idCrianca = idCrianca;
		this.idRecompensa = idRecompensa;
		this.quantidadeResgatada = quantidadeResgatada;
		this.dataHoraResgate = dataHoraResgate;
	}

	public Integer getIdCrianca() {
		return idCrianca;
	}

	public void setIdCrianca(Integer idCrianca) {
		this.idCrianca = idCrianca;
	}

	public Integer getIdRecompensa() {
		return idRecompensa;
	}

	public void setIdRecompensa(Integer idRecompensa) {
		this.idRecompensa = idRecompensa;
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

	@Override
	public String toString() {
		return "CriancaRecompensaNovaDTO [idCrianca=" + idCrianca + ", idRecompensa=" + idRecompensa
				+ ", quantidadeResgatada=" + quantidadeResgatada + ", dataHoraResgate=" + dataHoraResgate + "]";
	}

}
