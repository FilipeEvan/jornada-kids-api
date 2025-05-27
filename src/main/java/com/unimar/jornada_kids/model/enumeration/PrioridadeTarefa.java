package com.unimar.jornada_kids.model.enumeration;

public enum PrioridadeTarefa {

	A("Alta"),
	M("Média"),
	B("Baixa");

    private final String rotulo;

    PrioridadeTarefa(String rotulo) {
        this.rotulo = rotulo;
    }

    public String obterRotulo() {
        return rotulo;
    }
	
}
