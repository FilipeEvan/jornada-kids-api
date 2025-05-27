package com.unimar.jornada_kids.model.dto.usuario;

public class UsuarioResumidoDTO {
	
	public UsuarioResumidoDTO() {}
	
	private Integer id;
	
	private String nomeCompleto;

	public UsuarioResumidoDTO(Integer id, String nomeCompleto) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	@Override
	public String toString() {
		return "UsuarioResumidoDTO [id=" + id + ", nomeCompleto=" + nomeCompleto + "]";
	}

}
