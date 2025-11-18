package com.unimar.jornada_kids.model.dto.crianca;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unimar.jornada_kids.model.dto.usuario.UsuarioNovoDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public class CriancaNovaDTO { 
	
	public CriancaNovaDTO() {}
	
	@JsonProperty("usuario")
	@NotNull(message = "O usuário não pode ser nulo")
	@Valid
	private UsuarioNovoDTO usuarioNovo;
	
	@NotNull(message = "A data de nascimento não pode ser nula")
	@Past(message = "A data de nascimento deve ser no passado")
	private LocalDate dataNascimento;
	
	@NotNull(message = "O id do responsável não pode ser nulo")
	private Integer idResponsavel;

	public CriancaNovaDTO(@NotNull(message = "O usuário não pode ser nulo") @Valid UsuarioNovoDTO usuarioNovo,
			@NotNull(message = "A data de nascimento não pode ser nula") @Past(message = "A data de nascimento deve ser no passado") LocalDate dataNascimento,
			@NotNull(message = "O id do responsável não pode ser nulo") Integer idResponsavel) {
		super();
		this.usuarioNovo = usuarioNovo;
		this.dataNascimento = dataNascimento;
		this.idResponsavel = idResponsavel;
	}

	public UsuarioNovoDTO getUsuarioNovo() {
		return usuarioNovo;
	}

	public void setUsuarioNovo(UsuarioNovoDTO usuarioNovo) {
		this.usuarioNovo = usuarioNovo;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getIdResponsavel() {
		return idResponsavel;
	}

	public void setIdResponsavel(Integer idResponsavel) {
		this.idResponsavel = idResponsavel;
	}

	@Override
	public String toString() {
		return "CriancaNovaDTO [usuarioNovo=" + usuarioNovo + ", dataNascimento=" + dataNascimento + ", idResponsavel="
				+ idResponsavel + "]";
	}

}
