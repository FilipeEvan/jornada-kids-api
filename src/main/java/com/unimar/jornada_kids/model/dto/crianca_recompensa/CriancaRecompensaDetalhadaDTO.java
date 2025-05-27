package com.unimar.jornada_kids.model.dto.crianca_recompensa;

import java.time.LocalDateTime;

import com.unimar.jornada_kids.model.dto.crianca.CriancaDetalhadaDTO;
import com.unimar.jornada_kids.model.dto.recompensa.RecompensaDetalhadaDTO;

public class CriancaRecompensaDetalhadaDTO {
	
	public CriancaRecompensaDetalhadaDTO() {}
	
    private Long id;
	
	private CriancaDetalhadaDTO criancaDetalhada;
	
	private RecompensaDetalhadaDTO recompensaDetalhada;
	
	private int quantidadeResgatada;
	
	private LocalDateTime dataHoraResgate;

	public CriancaRecompensaDetalhadaDTO(Long id, CriancaDetalhadaDTO criancaDetalhado,
			RecompensaDetalhadaDTO recompensaDetalhado, int quantidadeResgatada, LocalDateTime dataHoraResgate) {
		super();
		this.id = id;
		this.criancaDetalhada = criancaDetalhado;
		this.recompensaDetalhada = recompensaDetalhado;
		this.quantidadeResgatada = quantidadeResgatada;
		this.dataHoraResgate = dataHoraResgate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CriancaDetalhadaDTO getCriancaDetalhada() {
		return criancaDetalhada;
	}

	public void setCriancaDetalhada(CriancaDetalhadaDTO criancaDetalhada) {
		this.criancaDetalhada = criancaDetalhada;
	}

	public RecompensaDetalhadaDTO getRecompensaDetalhada() {
		return recompensaDetalhada;
	}

	public void setRecompensaDetalhada(RecompensaDetalhadaDTO recompensaDetalhada) {
		this.recompensaDetalhada = recompensaDetalhada;
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
		return "CriancaRecompensaDetalhadaDTO [id=" + id + ", criancaDetalhado=" + criancaDetalhada
				+ ", recompensaDetalhado=" + recompensaDetalhada + ", quantidadeResgatada=" + quantidadeResgatada
				+ ", dataHoraResgate=" + dataHoraResgate + "]";
	}

}
