package com.unimar.jornada_kids.model.dto.aplicativo;

import com.unimar.jornada_kids.model.enumeration.PlataformaAplicativo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AplicativoNovoDTO {

	public AplicativoNovoDTO() {}
	
	@NotNull(message = "O id do responsável não pode ser nulo")
	private Integer idResponsavel;
	
	@NotNull(message = "O id da criança não pode ser nulo")
	private Integer idCrianca;
	
	@NotNull(message = "A plataforma não pode ser nula")
	private PlataformaAplicativo plataforma;
	
	@NotBlank(message = "O identificador não pode estar em branco")
	@Size(min = 2, message = "O identificador deve ter pelo menos 2 caracteres")
	private String identificador;
	
	@NotBlank(message = "O nome não pode estar em branco")
	@Size(min = 2, message = "O nome deve ter pelo menos 2 caracteres")
	private String nome;
	
	private Boolean bloqueado;
	
	@NotNull(message = "O tempo usado não pode ser nulo")
	private long tempoUsado;

	public AplicativoNovoDTO(@NotNull(message = "O id do responsável não pode ser nulo") Integer idResponsavel,
			@NotNull(message = "O id da criança não pode ser nulo") Integer idCrianca,
			@NotNull(message = "A plataforma não pode ser nula") PlataformaAplicativo plataforma,
			@NotBlank(message = "O identificador não pode estar em branco") @Size(min = 2, message = "O identificador deve ter pelo menos 2 caracteres") String identificador,
			@NotBlank(message = "O nome não pode estar em branco") @Size(min = 2, message = "O nome deve ter pelo menos 2 caracteres") String nome,
			Boolean bloqueado, @NotNull(message = "O tempo usado não pode ser nulo") long tempoUsado) {
		this.idResponsavel = idResponsavel;
		this.idCrianca = idCrianca;
		this.plataforma = plataforma;
		this.identificador = identificador;
		this.nome = nome;
		this.bloqueado = bloqueado;
		this.tempoUsado = tempoUsado;
	}

	public Integer getIdResponsavel() {
		return idResponsavel;
	}

	public void setIdResponsavel(Integer idResponsavel) {
		this.idResponsavel = idResponsavel;
	}

	public Integer getIdCrianca() {
		return idCrianca;
	}

	public void setIdCrianca(Integer idCrianca) {
		this.idCrianca = idCrianca;
	}

	public PlataformaAplicativo getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(PlataformaAplicativo plataforma) {
		this.plataforma = plataforma;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public long getTempoUsado() {
		return tempoUsado;
	}

	public void setTempoUsado(long tempoUsado) {
		this.tempoUsado = tempoUsado;
	}

	@Override
	public String toString() {
		return "AplicativoNovoDTO [idResponsavel=" + idResponsavel + ", idCrianca=" + idCrianca + ", plataforma="
				+ plataforma + ", identificador=" + identificador + ", nome=" + nome + ", bloqueado=" + bloqueado
				+ ", tempoUsado=" + tempoUsado + "]";
	}

}
