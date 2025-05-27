package com.unimar.jornada_kids.model.dto.crianca;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unimar.jornada_kids.model.dto.responsavel.ResponsavelDetalhadoDTO;
import com.unimar.jornada_kids.model.dto.usuario.UsuarioDetalhadoDTO;

@JsonFilter("CriancaFilter")
public class CriancaDetalhadaDTO {
	
	public CriancaDetalhadaDTO() {}
	
	private Integer id;
	
	@JsonProperty("usuario")
	private UsuarioDetalhadoDTO usuarioDetalhado;
	
	private LocalDate dataNascimento;
	
	private int idade;
	
	private int nivel;
	
	private int xp;
	
	private int xpTotal;
	
	private long ponto;
	
	@JsonProperty("responsavel")
	private ResponsavelDetalhadoDTO responsavelDetalhado;

	public CriancaDetalhadaDTO(Integer id, UsuarioDetalhadoDTO usuarioDetalhado, LocalDate dataNascimento, int idade,
			int nivel, int xp, int xpTotal, long ponto, ResponsavelDetalhadoDTO responsavelDetalhado) {
		super();
		this.id = id;
		this.usuarioDetalhado = usuarioDetalhado;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
		this.nivel = nivel;
		this.xp = xp;
		this.xpTotal = xpTotal;
		this.ponto = ponto;
		this.responsavelDetalhado = responsavelDetalhado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UsuarioDetalhadoDTO getUsuarioDetalhado() {
		return usuarioDetalhado;
	}

	public void setUsuarioDetalhado(UsuarioDetalhadoDTO usuarioDetalhado) {
		this.usuarioDetalhado = usuarioDetalhado;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getXpTotal() {
		return xpTotal;
	}

	public void setXpTotal(int xpTotal) {
		this.xpTotal = xpTotal;
	}

	public long getPonto() {
		return ponto;
	}

	public void setPonto(long ponto) {
		this.ponto = ponto;
	}

	public ResponsavelDetalhadoDTO getResponsavelDetalhado() {
		return responsavelDetalhado;
	}

	public void setResponsavelDetalhado(ResponsavelDetalhadoDTO responsavelDetalhado) {
		this.responsavelDetalhado = responsavelDetalhado;
	}

	@Override
	public String toString() {
		return "CriancaDetalhadaDTO [id=" + id + ", usuarioDetalhado=" + usuarioDetalhado + ", dataNascimento="
				+ dataNascimento + ", idade=" + idade + ", nivel=" + nivel + ", xp=" + xp + ", xpTotal=" + xpTotal
				+ ", ponto=" + ponto + ", responsavelDetalhado=" + responsavelDetalhado + "]";
	}

}
