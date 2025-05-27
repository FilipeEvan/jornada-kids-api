package com.unimar.jornada_kids.model.dto.usuario;

import java.time.LocalDateTime;

public class UsuarioDetalhadoDTO {
	
	public UsuarioDetalhadoDTO() {}
	
	private Integer id;
	
	private String nomeCompleto;
	
	private String nomeUsuario;
	
	private String email;
	
	private String telefone;
	
	private String tipo;
	
	private LocalDateTime criadoEm;
	
	private LocalDateTime atualizadoEm;

	public UsuarioDetalhadoDTO(Integer id, String nomeCompleto, String nomeUsuario, String email, String telefone,
			String tipo, LocalDateTime criadoEm, LocalDateTime atualizadoEm) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.telefone = telefone;
		this.tipo = tipo;
		this.criadoEm = criadoEm;
		this.atualizadoEm = atualizadoEm;
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

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public LocalDateTime getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(LocalDateTime criadoEm) {
		this.criadoEm = criadoEm;
	}

	public LocalDateTime getAtualizadoEm() {
		return atualizadoEm;
	}

	public void setAtualizadoEm(LocalDateTime atualizadoEm) {
		this.atualizadoEm = atualizadoEm;
	}

	@Override
	public String toString() {
		return "UsuarioDetalhadoDTO [id=" + id + ", nomeCompleto=" + nomeCompleto + ", nomeUsuario=" + nomeUsuario
				+ ", email=" + email + ", telefone=" + telefone + ", tipo=" + tipo + ", criadoEm=" + criadoEm
				+ ", atualizadoEm=" + atualizadoEm + "]";
	}

}
