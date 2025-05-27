package com.unimar.jornada_kids.model.enumeration;

public enum SituacaoRecompensa {
	
	D("Disponível"),
	E("Esgotada"),
	B("Bloqueada"),
	O("Oculta");

    private final String rotulo;

    SituacaoRecompensa(String rotulo) {
        this.rotulo = rotulo;
    }

    public String obterRotulo() {
        return rotulo;
    }

}
