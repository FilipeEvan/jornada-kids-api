package com.unimar.jornada_kids.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.unimar.jornada_kids.model.dto.crianca.CriancaDetalhadaDTO;
import com.unimar.jornada_kids.model.dto.crianca.CriancaNovaDTO;
import com.unimar.jornada_kids.model.dto.crianca.CriancaResumidaDTO;
import com.unimar.jornada_kids.model.dto.tarefa.TarefaResumidaDTO;
import com.unimar.jornada_kids.model.entity.Crianca;
import com.unimar.jornada_kids.model.enumeration.PrioridadeTarefa;
import com.unimar.jornada_kids.model.enumeration.SituacaoTarefa;
import com.unimar.jornada_kids.service.CriancaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/criancas")
public class CriancaController {
	
	private CriancaService criancaService;
	
	public CriancaController(CriancaService criancaService) {
		this.criancaService = criancaService;
	}
	
	@GetMapping
	public ResponseEntity<MappingJacksonValue> listarCriancas() {
		List<CriancaResumidaDTO> criancas = criancaService.listarTodas();
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(criancas);
		
		SimpleBeanPropertyFilter criancaFilter = SimpleBeanPropertyFilter.serializeAll();
		SimpleBeanPropertyFilter responsavelFilter = SimpleBeanPropertyFilter.serializeAll();
		
		FilterProvider filters = new SimpleFilterProvider()
				.addFilter("CriancaFilter", criancaFilter)
				.addFilter("ResponsavelFilter", responsavelFilter);
		
		mappingJacksonValue.setFilters(filters);
		
		return ResponseEntity.ok(mappingJacksonValue);
	}
	
	@GetMapping("/{id}/tarefas")
	public ResponseEntity<MappingJacksonValue> listarTarefasPorCrianca(
			@PathVariable int id, 
			@RequestParam(required = false) PrioridadeTarefa prioridade,
			@RequestParam(required = false) SituacaoTarefa situacao,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
		List<TarefaResumidaDTO> tarefas = criancaService.listarTarefas(id, prioridade, situacao, data);
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(tarefas);
		
		SimpleBeanPropertyFilter criancaFilter = SimpleBeanPropertyFilter.serializeAll();
		SimpleBeanPropertyFilter responsavelFilter = SimpleBeanPropertyFilter.serializeAll();
		SimpleBeanPropertyFilter tarefaFilter = SimpleBeanPropertyFilter.serializeAllExcept("crianca");
		
		FilterProvider filters = new SimpleFilterProvider()
				.addFilter("CriancaFilter", criancaFilter)
				.addFilter("ResponsavelFilter", responsavelFilter)
				.addFilter("TarefaFilter", tarefaFilter );
		
		mappingJacksonValue.setFilters(filters);
		
		return ResponseEntity.ok(mappingJacksonValue);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MappingJacksonValue> buscarCriancaPorId(@PathVariable int id) {
		EntityModel<CriancaDetalhadaDTO> entityModel = EntityModel.of(criancaService.buscarPorId(id));
		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).listarCriancas());
		entityModel.add(link.withRel("lista-de-criancas"));
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(entityModel);
		
		SimpleBeanPropertyFilter criancaFilter = SimpleBeanPropertyFilter.serializeAll();
		SimpleBeanPropertyFilter responsavelFilter = SimpleBeanPropertyFilter.serializeAll();
		
		FilterProvider filters = new SimpleFilterProvider()
				.addFilter("CriancaFilter", criancaFilter)
				.addFilter("ResponsavelFilter", responsavelFilter);
		
		mappingJacksonValue.setFilters(filters);
		
		return ResponseEntity.ok(mappingJacksonValue);
	}
	
	@PostMapping
	public ResponseEntity<Crianca> criarCrianca(@Valid @RequestBody CriancaNovaDTO criancaNovo) {
		Crianca crianca = criancaService.salvar(criancaNovo);

		URI localizacao = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(crianca.getId())
						.toUri();	

		return ResponseEntity.created(localizacao).build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletarCriancaPorId(@PathVariable int id) {
		criancaService.deletar(id);
		
		return ResponseEntity.noContent().build();
	}

}
