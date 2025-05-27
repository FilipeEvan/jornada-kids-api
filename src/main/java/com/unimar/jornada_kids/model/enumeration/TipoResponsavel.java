package com.unimar.jornada_kids.model.enumeration;

public enum TipoResponsavel {

	AM("Avô"),
    AF("Avó"),
    P("Pai"),
    M("Mãe"),
    TM("Tio"),
    TF("Tia");

    private final String rotulo;

    TipoResponsavel(String rotulo) {
        this.rotulo = rotulo;
    }

    public String obterRotulo() {
        return rotulo;
    }
}
