package com.unimar.jornada_kids.model.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unimar.jornada_kids.model.enumeration.TipoUsuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Usuario {
	
	public Usuario() {}
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String nomeCompleto;
	
	private String nomeUsuario;
	
	private String email;
	
	private String telefone;
	
	@JsonIgnore
	private String senha;
	
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipo;
	
	@OneToOne(mappedBy = "usuario")
	private Crianca crianca;
	
	@OneToOne(mappedBy = "usuario")
	private Responsavel responsavel;
	
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime criadoEm;
	
	@LastModifiedDate
	private LocalDateTime atualizadoEm;

	public Usuario(String nomeCompleto, String nomeUsuario, String email, String telefone, String senha,
			TipoUsuario tipo) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
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

	public Crianca getCrianca() {
		return crianca;
	}

	public void setCrianca(Crianca crianca) {
		this.crianca = crianca;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public LocalDateTime getCriadoEm() {
		return criadoEm;
	}

	public LocalDateTime getAtualizadoEm() {
		return atualizadoEm;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nomeCompleto=" + nomeCompleto + ", nomeUsuario=" + nomeUsuario + ", email="
				+ email + ", telefone=" + telefone + ", senha=" + senha + ", tipo=" + tipo + ", criadoEm=" + criadoEm
				+ ", atualizadoEm=" + atualizadoEm + "]";
	}

}
