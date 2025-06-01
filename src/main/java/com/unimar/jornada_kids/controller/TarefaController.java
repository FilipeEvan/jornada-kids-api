package com.unimar.jornada_kids.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

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
import com.unimar.jornada_kids.model.dto.tarefa.TarefaDetalhadaDTO;
import com.unimar.jornada_kids.model.dto.tarefa.TarefaNovaDTO;
import com.unimar.jornada_kids.model.dto.tarefa.TarefaResumidaDTO;
import com.unimar.jornada_kids.model.entity.Tarefa;
import com.unimar.jornada_kids.model.enumeration.PrioridadeTarefa;
import com.unimar.jornada_kids.model.enumeration.SituacaoTarefa;
import com.unimar.jornada_kids.service.TarefaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/tarefas")
public class TarefaController {
	
	private TarefaService tarefaService;
	
	public TarefaController(TarefaService tarefaService) {
		this.tarefaService = tarefaService;
	}
	
	@GetMapping
	public ResponseEntity<MappingJacksonValue> listarTarefas(
			@RequestParam(required = false) PrioridadeTarefa prioridade,
			@RequestParam(required = false) SituacaoTarefa situacao) {
		List<TarefaResumidaDTO> tarefas = tarefaService.listarTodas(prioridade, situacao);
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(tarefas);
		
		SimpleBeanPropertyFilter criancaFilter = SimpleBeanPropertyFilter.serializeAllExcept("responsavel");
		SimpleBeanPropertyFilter responsavelFilter = SimpleBeanPropertyFilter.serializeAll();
		SimpleBeanPropertyFilter tarefaFilter = SimpleBeanPropertyFilter.serializeAll();
		
		
		FilterProvider filters = new SimpleFilterProvider()
				.addFilter("CriancaFilter", criancaFilter)
				.addFilter("ResponsavelFilter", responsavelFilter)
				.addFilter("TarefaFilter", tarefaFilter);;
		
		mappingJacksonValue.setFilters(filters);
		
		return ResponseEntity.ok(mappingJacksonValue);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MappingJacksonValue> buscarTarefaPorId(@PathVariable int id) {
		EntityModel<TarefaDetalhadaDTO> entityModel = EntityModel.of(tarefaService.buscarPorId(id));
		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).listarTarefas(null, null));
		entityModel.add(link.withRel("lista-de-tarefas"));
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(entityModel);
		
		SimpleBeanPropertyFilter criancaFilter = SimpleBeanPropertyFilter.serializeAllExcept("responsavel");
		SimpleBeanPropertyFilter responsavelFilter = SimpleBeanPropertyFilter.serializeAll();
		SimpleBeanPropertyFilter tarefaFilter = SimpleBeanPropertyFilter.serializeAll();
		
		FilterProvider filters = new SimpleFilterProvider()
				.addFilter("CriancaFilter", criancaFilter)
				.addFilter("ResponsavelFilter", responsavelFilter)
				.addFilter("TarefaFilter", tarefaFilter);
		
		mappingJacksonValue.setFilters(filters);
		
		return ResponseEntity.ok(mappingJacksonValue);
	}
	
	@PostMapping
	public ResponseEntity<Tarefa> criarTarefa(@Valid @RequestBody TarefaNovaDTO tarefaNova) {
		Tarefa tarefa = tarefaService.salvar(tarefaNova);

		URI localizacao = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(tarefa.getId())
						.toUri();	

		return ResponseEntity.created(localizacao).build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletarTarefaPorId(@PathVariable int id) {
		tarefaService.deletar(id);
		
		return ResponseEntity.noContent().build();
	}

}
