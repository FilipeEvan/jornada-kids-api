package com.unimar.jornada_kids.model.dto.usuario;

import com.unimar.jornada_kids.model.enumeration.TipoUsuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UsuarioNovoDTO {
	
	public UsuarioNovoDTO() {}
	
	@NotBlank(message = "O nome completo não pode estar em branco")
	@Size(min = 2, message = "O nome completo deve ter pelo menos 2 caracteres")
	private String nomeCompleto;
	
	@NotBlank(message = "O nome de usuário não pode estar em branco")
	@Size(min = 2, message = "O nome de usuário deve ter pelo menos 2 caracteres")
	private String nomeUsuario;
	
	@NotBlank(message = "O e-mail não pode estar em branco")
	@Email(message = "O e-mail deve estar em um formato válido")
	private String email;
	
	@Size(min = 10, max = 15, message = "O telefone deve ter entre 10 e 15 dígitos")
	@NotBlank(message = "O telefone não pode estar em branco")
	private String telefone;
	
	@Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
	@NotBlank(message = "A senha não pode estar em branco")
	private String senha;
	
	@NotNull(message = "O tipo de usuário não pode ser nulo")
	private TipoUsuario tipo;

	public UsuarioNovoDTO(
			@NotBlank(message = "O nome completo não pode estar em branco") @Size(min = 2, message = "O nome completo deve ter pelo menos 2 caracteres") String nomeCompleto,
			@NotBlank(message = "O nome de usuário não pode estar em branco") @Size(min = 2, message = "O nome de usuário deve ter pelo menos 2 caracteres") String nomeUsuario,
			@NotBlank(message = "O e-mail não pode estar em branco") @Email(message = "O e-mail deve estar em um formato válido") String email,
			@Size(min = 10, max = 15, message = "O telefone deve ter entre 10 e 15 dígitos") @NotBlank(message = "O telefone não pode estar em branco") String telefone,
			@Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres") @NotBlank(message = "A senha não pode estar em branco") String senha,
			@NotNull(message = "O tipo de usuário não pode ser nulo") TipoUsuario tipo) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		this.tipo = tipo;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "NovoUsuarioDTO [nomeCompleto=" + nomeCompleto + ", nomeUsuario=" + nomeUsuario + ", email=" + email
				+ ", telefone=" + telefone + ", senha=" + senha + ", tipo=" + tipo + "]";
	}

}
