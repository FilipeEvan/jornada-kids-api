package com.unimar.jornada_kids.model.enumeration;

public enum SituacaoTarefa {
	
	P("Pendente"),
	E("Expirada"),
	C("Concluída"),
	A("Avaliada");

    private final String rotulo;

    SituacaoTarefa(String rotulo) {
        this.rotulo = rotulo;
    }

    public String obterRotulo() {
        return rotulo;
    }

}
