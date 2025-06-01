package com.unimar.jornada_kids.model.dto.usuario;

import jakarta.validation.constraints.NotBlank;

public class UsuarioAutenticadoDTO {
	
	public UsuarioAutenticadoDTO() {}
	
	@NotBlank(message = "O nome de usuário não pode estar em branco")
	private String nomeUsuario;
	
	@NotBlank(message = "A senha não pode estar em branco")
	private String senha;
	
	public UsuarioAutenticadoDTO(String nomeUsuario, String senha) {
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "UsuarioLogadoDTO [nomeUsuario=" + nomeUsuario + ", senha=" + senha + "]";
	}

}
