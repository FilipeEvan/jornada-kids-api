package com.unimar.jornada_kids.model.dto.aplicativo;

public class AplicativoBloqueadoDTO {

	public AplicativoBloqueadoDTO() {}
	
	private Boolean bloqueado;
	
	private long tempoLimite;

	public AplicativoBloqueadoDTO(Boolean bloqueado, long tempoLimite) {
		this.bloqueado = bloqueado;
		this.tempoLimite = tempoLimite;
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

	public void setTempoLimite(long tempoLimite) {
		this.tempoLimite = tempoLimite;
	}

	@Override
	public String toString() {
		return "AplicativoBloqueadoDTO [bloqueado=" + bloqueado + ", tempoLimite=" + tempoLimite + "]";
	}

}
