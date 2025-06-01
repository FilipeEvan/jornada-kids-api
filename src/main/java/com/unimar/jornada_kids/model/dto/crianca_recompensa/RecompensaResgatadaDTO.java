package com.unimar.jornada_kids.model.dto.crianca_recompensa;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class RecompensaResgatadaDTO {
	
	public RecompensaResgatadaDTO() {}
	
	@NotNull(message = "O id da criança não pode ser nulo")
	private Integer idCrianca;
	
	@NotNull(message = "A quantidade resgatada não pode ser nula")
	@Positive(message = "A quantidade resgatada não pode ser zero ou negativa")
	private int quantidadeResgatada;

	public RecompensaResgatadaDTO(Integer idCrianca, int quantidadeResgatada) {
		super();
		this.idCrianca = idCrianca;
		this.quantidadeResgatada = quantidadeResgatada;
	}

	public Integer getIdCrianca() {
		return idCrianca;
	}

	public void setIdCrianca(Integer idCrianca) {
		this.idCrianca = idCrianca;
	}

	public int getQuantidadeResgatada() {
		return quantidadeResgatada;
	}

	public void setQuantidadeResgatada(int quantidadeResgatada) {
		this.quantidadeResgatada = quantidadeResgatada;
	}

	@Override
	public String toString() {
		return "CriancaRecompensaNovaDTO [idCrianca=" + idCrianca + ", quantidadeResgatada=" + quantidadeResgatada + "]";
	}

}
