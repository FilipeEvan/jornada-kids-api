package com.unimar.jornada_kids.model.enumeration;

public enum TipoUsuario {
	
	C("Criança"),
	R("Responsável");

    private final String rotulo;

	TipoUsuario(String rotulo) {
        this.rotulo = rotulo;
    }

    public String obterRotulo() {
        return rotulo;
    }

}
