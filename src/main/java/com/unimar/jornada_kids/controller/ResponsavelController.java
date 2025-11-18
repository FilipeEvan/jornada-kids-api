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
import com.unimar.jornada_kids.model.dto.crianca.CriancaResumidaDTO;
import com.unimar.jornada_kids.model.dto.recompensa.RecompensaResumidaDTO;
import com.unimar.jornada_kids.model.dto.responsavel.ResponsavelDetalhadoDTO;
import com.unimar.jornada_kids.model.dto.responsavel.ResponsavelNovoDTO;
import com.unimar.jornada_kids.model.dto.responsavel.ResponsavelResumidoDTO;
import com.unimar.jornada_kids.model.dto.tarefa.TarefaResumidaDTO;
import com.unimar.jornada_kids.model.entity.Responsavel;
import com.unimar.jornada_kids.model.enumeration.PrioridadeTarefa;
import com.unimar.jornada_kids.model.enumeration.SituacaoRecompensa;
import com.unimar.jornada_kids.model.enumeration.SituacaoTarefa;
import com.unimar.jornada_kids.service.ResponsavelService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/responsaveis")
public class ResponsavelController {
	
	private ResponsavelService responsavelService;
	
	public ResponsavelController(ResponsavelService responsavelService) {
		this.responsavelService = responsavelService;
	}
	
	@GetMapping
	public ResponseEntity<MappingJacksonValue> listarResponsaveis() {
		List<ResponsavelResumidoDTO> responsaveis = responsavelService.listarTodos();
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(responsaveis);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAll();
		
		FilterProvider filters = 
				new SimpleFilterProvider().addFilter("ResponsavelFilter", filter );
		
		mappingJacksonValue.setFilters(filters);
		
		return ResponseEntity.ok(mappingJacksonValue);
	}
	
	@GetMapping("/{id}/criancas")
	public ResponseEntity<MappingJacksonValue> listarCriancasPorResponsavel(@PathVariable int id) {
	    List<CriancaResumidaDTO> criancas = responsavelService.listarCriancas(id);
	    
	    MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(criancas);
		
		SimpleBeanPropertyFilter filter = 
				SimpleBeanPropertyFilter.serializeAllExcept("responsavel");
		
		FilterProvider filters = 
				new SimpleFilterProvider().addFilter("CriancaFilter", filter );
		
		mappingJacksonValue.setFilters(filters);
	    
	    return ResponseEntity.ok(mappingJacksonValue);
	}
	
	@GetMapping("/{id}/tarefas")
	public ResponseEntity<MappingJacksonValue> listarTarefasPorResponsavel(
			@PathVariable int id, 
			@RequestParam(required = false) PrioridadeTarefa prioridade,
			@RequestParam(required = false) SituacaoTarefa situacao,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
		List<TarefaResumidaDTO> tarefas = responsavelService.listarTarefas(id, prioridade, situacao, data);
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(tarefas);
		
		SimpleBeanPropertyFilter criancaFilter = SimpleBeanPropertyFilter.serializeAllExcept("responsavel");
		SimpleBeanPropertyFilter responsavelFilter = SimpleBeanPropertyFilter.serializeAll();
		SimpleBeanPropertyFilter tarefaFilter = SimpleBeanPropertyFilter.serializeAllExcept("responsavel");
		
		FilterProvider filters = new SimpleFilterProvider()
				.addFilter("CriancaFilter", criancaFilter)
				.addFilter("ResponsavelFilter", responsavelFilter)
				.addFilter("TarefaFilter", tarefaFilter);
		
		mappingJacksonValue.setFilters(filters);
		
		return ResponseEntity.ok(mappingJacksonValue);
	}
	
	@GetMapping("/{id}/recompensas")
	public ResponseEntity<MappingJacksonValue> listarRecompensasPorResponsavel(
			@PathVariable int id, 
			@RequestParam(required = false) SituacaoRecompensa situacao) {
		List<RecompensaResumidaDTO> recompensas = responsavelService.listarRecompensas(id, situacao);
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(recompensas);
		
		SimpleBeanPropertyFilter criancaFilter = SimpleBeanPropertyFilter.serializeAllExcept("responsavel");
		SimpleBeanPropertyFilter responsavelFilter = SimpleBeanPropertyFilter.serializeAll();
		SimpleBeanPropertyFilter recompensaFilter = SimpleBeanPropertyFilter.serializeAllExcept("responsavel");
		
		FilterProvider filters = new SimpleFilterProvider()
				.addFilter("CriancaFilter", criancaFilter)
				.addFilter("ResponsavelFilter", responsavelFilter)
				.addFilter("RecompensaFilter", recompensaFilter);;
		
		mappingJacksonValue.setFilters(filters);
		
		return ResponseEntity.ok(mappingJacksonValue);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<ResponsavelDetalhadoDTO>> buscarResponsavelPorId(@PathVariable int id) {
		EntityModel<ResponsavelDetalhadoDTO> entityModel = EntityModel.of(responsavelService.buscarPorId(id));
		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).listarResponsaveis());
		entityModel.add(link.withRel("lista-de-responsaveis"));
		
		return ResponseEntity.ok(entityModel);
	}
	
	@GetMapping("/codigo/{codigo}")
	public ResponseEntity<EntityModel<ResponsavelDetalhadoDTO>> buscarResponsavelPorCodigo(@PathVariable String codigo) {
		EntityModel<ResponsavelDetalhadoDTO> entityModel = EntityModel.of(responsavelService.buscarPorCodigo(codigo));
		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).listarResponsaveis());
		entityModel.add(link.withRel("lista-de-responsaveis"));
		
		return ResponseEntity.ok(entityModel);
	}
	
	@PostMapping
	public ResponseEntity<Responsavel> criarResponsavel(@Valid @RequestBody ResponsavelNovoDTO responsavelNovo) {
		Responsavel responsavel = responsavelService.salvar(responsavelNovo);

		URI localizacao = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(responsavel.getId())
						.toUri();	

		return ResponseEntity.created(localizacao).build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletarResponsavelPorId(@PathVariable int id) {
		responsavelService.deletar(id);
		
		return ResponseEntity.noContent().build();
	}

}
