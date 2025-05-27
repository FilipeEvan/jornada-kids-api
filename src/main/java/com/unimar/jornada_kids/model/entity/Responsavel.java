package com.unimar.jornada_kids.model.entity;

import java.util.List;

import com.unimar.jornada_kids.model.enumeration.TipoResponsavel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity 
public class Responsavel {
	
	public Responsavel() {}
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	private Usuario usuario;
	
	private String codigo;
	
	@Enumerated(EnumType.STRING)
	private TipoResponsavel tipo;
	
	@OneToMany(mappedBy = "responsavel")
	private List<Crianca> criancas;
	
	@OneToMany(mappedBy = "responsavel", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Tarefa> tarefas;
	
	@OneToMany(mappedBy = "responsavel", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Recompensa> recompensas;

	public Responsavel(Usuario usuario, String codigo, TipoResponsavel tipo, List<Crianca> criancas) {
		super();
		this.usuario = usuario;
		this.codigo = codigo;
		this.tipo = tipo;
		this.criancas = criancas;
	}

	public Integer getId() {
		return id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public TipoResponsavel getTipo() {
		return tipo;
	}

	public void setTipo(TipoResponsavel tipo) {
		this.tipo = tipo;
	}

	public List<Crianca> getCriancas() {
		return criancas;
	}

	public void setCriancas(List<Crianca> criancas) {
		this.criancas = criancas;
	}
	

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public List<Recompensa> getRecompensas() {
		return recompensas;
	}

	public void setRecompensas(List<Recompensa> recompensas) {
		this.recompensas = recompensas;
	}

	@Override
	public String toString() {
		return "Responsavel [id=" + id + ", usuario=" + usuario + ", codigo=" + codigo + ", tipo=" + tipo + "]";
	}

}
