package com.unimar.jornada_kids.model.dto.tarefa;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unimar.jornada_kids.model.dto.crianca.CriancaDetalhadaDTO;
import com.unimar.jornada_kids.model.dto.responsavel.ResponsavelDetalhadoDTO;

public class TarefaDetalhadaDTO {
	
	public TarefaDetalhadaDTO() {}
	
	private Integer id;
	
	@JsonProperty("responsavel")
	private ResponsavelDetalhadoDTO responsavelDetalhado;
	
	@JsonProperty("crianca")
	private CriancaDetalhadaDTO criancaDetalhada;
	
	private String titulo;
	
	private long pontuacaoTotal;
	
	private long pontuacaoConquistada;
	
	private int estrela;
	
	private String prioridade;
	
	private String situacao;
	
	private LocalDateTime dataHoraLimite;
	
	private LocalDateTime dataHoraConclusao; 
	
	private LocalDateTime criadoEm;
	
	private LocalDateTime atualizadoEm;

	public TarefaDetalhadaDTO(Integer id, ResponsavelDetalhadoDTO responsavelDetalhado,
			CriancaDetalhadaDTO criancaDetalhada, String titulo, long pontuacaoTotal, long pontuacaoConquistada,
			int estrela, String prioridade, String situacao, LocalDateTime dataHoraLimite,
			LocalDateTime dataHoraConclusao, LocalDateTime criadoEm, LocalDateTime atualizadoEm) {
		super();
		this.id = id;
		this.responsavelDetalhado = responsavelDetalhado;
		this.criancaDetalhada = criancaDetalhada;
		this.titulo = titulo;
		this.pontuacaoTotal = pontuacaoTotal;
		this.pontuacaoConquistada = pontuacaoConquistada;
		this.estrela = estrela;
		this.prioridade = prioridade;
		this.situacao = situacao;
		this.dataHoraLimite = dataHoraLimite;
		this.dataHoraConclusao = dataHoraConclusao;
		this.criadoEm = criadoEm;
		this.atualizadoEm = atualizadoEm;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ResponsavelDetalhadoDTO getResponsavelDetalhado() {
		return responsavelDetalhado;
	}

	public void setResponsavelDetalhado(ResponsavelDetalhadoDTO responsavelDetalhado) {
		this.responsavelDetalhado = responsavelDetalhado;
	}

	public CriancaDetalhadaDTO getCriancaDetalhada() {
		return criancaDetalhada;
	}

	public void setCriancaDetalhada(CriancaDetalhadaDTO criancaDetalhada) {
		this.criancaDetalhada = criancaDetalhada;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public long getPontuacaoTotal() {
		return pontuacaoTotal;
	}

	public void setPontuacaoTotal(long pontuacaoTotal) {
		this.pontuacaoTotal = pontuacaoTotal;
	}

	public long getPontuacaoConquistada() {
		return pontuacaoConquistada;
	}

	public void setPontuacaoConquistada(long pontuacaoConquistada) {
		this.pontuacaoConquistada = pontuacaoConquistada;
	}

	public int getEstrela() {
		return estrela;
	}

	public void setEstrela(int estrela) {
		this.estrela = estrela;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public LocalDateTime getDataHoraLimite() {
		return dataHoraLimite;
	}

	public void setDataHoraLimite(LocalDateTime dataHoraLimite) {
		this.dataHoraLimite = dataHoraLimite;
	}

	public LocalDateTime getDataHoraConclusao() {
		return dataHoraConclusao;
	}

	public void setDataHoraConclusao(LocalDateTime dataHoraConclusao) {
		this.dataHoraConclusao = dataHoraConclusao;
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
		return "TarefaDetalhadaDTO [id=" + id + ", responsavelDetalhadoDTO=" + responsavelDetalhado
				+ ", criancaDetalhada=" + criancaDetalhada + ", titulo=" + titulo + ", pontuacaoTotal=" + pontuacaoTotal
				+ ", pontuacaoConquistada=" + pontuacaoConquistada + ", estrela=" + estrela + ", prioridade="
				+ prioridade + ", situacao=" + situacao + ", dataHoraLimite=" + dataHoraLimite + ", dataHoraConclusao="
				+ dataHoraConclusao + ", criadoEm=" + criadoEm + ", atualizadoEm=" + atualizadoEm + "]";
	}

}
