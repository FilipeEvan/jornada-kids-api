package com.unimar.jornada_kids.model.dto.aplicativo;

public class AplicativoUsadoDTO {

	public AplicativoUsadoDTO() {}
	
	private long tempoUsado;

	public AplicativoUsadoDTO(long tempoLimite) {
		this.tempoUsado = tempoLimite;
	}

	public long getTempoUsado() {
		return tempoUsado;
	}

	public void setTempoUsado(long tempoUsado) {
		this.tempoUsado = tempoUsado;
	}

	@Override
	public String toString() {
		return "AplicativoUsadoDTO [tempoUsado=" + tempoUsado + "]";
	}

}
