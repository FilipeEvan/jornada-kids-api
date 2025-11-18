package com.unimar.jornada_kids.model.enumeration;

public enum PlataformaAplicativo {
	
	A("Android"),
	I("iOS");

    private final String rotulo;

    PlataformaAplicativo(String rotulo) {
        this.rotulo = rotulo;
    }

    public String obterRotulo() {
        return rotulo;
    }

}
