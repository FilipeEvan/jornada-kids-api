package com.unimar.jornada_kids.model.dto.recompensa;

import com.unimar.jornada_kids.model.enumeration.SituacaoRecompensa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class RecompensaNovaDTO {
	
	public RecompensaNovaDTO() {}
	
	@NotNull(message = "O id do responsável não pode ser nulo")
	private Integer idResponsavel;
	
	@NotBlank(message = "O título não pode estar em branco")
	@Size(min = 2, message = "O título deve ter pelo menos 2 caracteres")
	private String titulo;
	
	@NotNull(message = "A pontuação necessária não pode ser nula")
	@Positive(message = "A pontuação necessária não pode ser zero ou negativa")
	private long pontuacaoNecessaria;
	
	@NotNull(message = "A quantidade não pode ser nula")
	@Positive(message = "A quantidade não pode ser zero ou negativa")
	private int quantidade;
	
	@NotNull(message = "A situação da recompensa não pode ser nula")
	private SituacaoRecompensa situacao;

	public RecompensaNovaDTO(@NotNull(message = "O id do responsável não pode ser nulo") Integer idResponsavel,
			@NotBlank(message = "O título não pode estar em branco") @Size(min = 2, message = "O título deve ter pelo menos 2 caracteres") String titulo,
			@NotNull(message = "A pontuação necessária não pode ser nula") @Positive(message = "A pontuação necessária não pode ser zero ou negativa") long pontuacaoNecessaria,
			@NotNull(message = "A quantidade não pode ser nula") @Positive(message = "A quantidade não pode ser zero ou negativa") int quantidade,
			@NotNull(message = "A situação da recompensa não pode ser nula") SituacaoRecompensa situacao) {
		super();
		this.idResponsavel = idResponsavel;
		this.titulo = titulo;
		this.pontuacaoNecessaria = pontuacaoNecessaria;
		this.quantidade = quantidade;
		this.situacao = situacao;
	}

	public Integer getIdResponsavel() {
		return idResponsavel;
	}

	public void setIdResponsavel(Integer idResponsavel) {
		this.idResponsavel = idResponsavel;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public long getPontuacaoNecessaria() {
		return pontuacaoNecessaria;
	}

	public void setPontuacaoNecessaria(long pontuacaoNecessaria) {
		this.pontuacaoNecessaria = pontuacaoNecessaria;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public SituacaoRecompensa getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoRecompensa situacao) {
		this.situacao = situacao;
	}

	@Override
	public String toString() {
		return "RecompensaNovaDTO [idResponsavel=" + idResponsavel + ", titulo=" + titulo + ", pontuacaoNecessaria="
				+ pontuacaoNecessaria + ", quantidade=" + quantidade + ", situacao=" + situacao + "]";
	}

}
