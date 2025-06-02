package com.unimar.jornada_kids.model.dto.tarefa;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class TarefaAvaliadaDTO {
	
	public TarefaAvaliadaDTO() {}
	
	@Min(value = 0, message = "O mínimo de estrela é 0")
    @Max(value = 5, message = "O máximo de estrela é 5")
	private int estrela;

	public TarefaAvaliadaDTO(int estrela) {
		this.estrela = estrela;
	}

	public int getEstrela() {
		return estrela;
	}

	public void setEstrela(int estrela) {
		this.estrela = estrela;
	}

	@Override
	public String toString() {
		return "TarefaAvaliadaDTO [estrela=" + estrela + "]";
	}

}
