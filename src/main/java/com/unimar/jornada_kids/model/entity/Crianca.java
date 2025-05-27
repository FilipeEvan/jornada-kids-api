package com.unimar.jornada_kids.model.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Crianca {
	
	public Crianca() {}
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	private Usuario usuario;
	
	private LocalDate dataNascimento;
	
	private int nivel;
	
	private int xp;
	
	private int xpTotal;
	
	private long ponto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_responsavel", referencedColumnName = "id")
	private Responsavel responsavel;
	
	@OneToMany(mappedBy = "crianca", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Tarefa> tarefas;

	public Crianca(Usuario usuario, LocalDate dataNascimento, int nivel, int xp, int xpTotal, long ponto,
			Responsavel responsavel) {
		super();
		this.usuario = usuario;
		this.dataNascimento = dataNascimento;
		this.nivel = nivel;
		this.xp = xp;
		this.xpTotal = xpTotal;
		this.ponto = ponto;
		this.responsavel = responsavel;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
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

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}
	
	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	@Override
	public String toString() {
		return "Crianca [id=" + id + ", usuario=" + usuario + ", dataNascimento=" + dataNascimento + ", nivel=" + nivel
				+ ", xp=" + xp + ", xpTotal=" + xpTotal + ", ponto=" + ponto + ", responsavel=" + responsavel + "]";
	}

}
