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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.unimar.jornada_kids.model.dto.aplicativo.AplicativoBloqueadoDTO;
import com.unimar.jornada_kids.model.dto.aplicativo.AplicativoDetalhadoDTO;
import com.unimar.jornada_kids.model.dto.aplicativo.AplicativoNovoDTO;
import com.unimar.jornada_kids.model.dto.aplicativo.AplicativoResumidoDTO;
import com.unimar.jornada_kids.model.dto.aplicativo.AplicativoUsadoDTO;
import com.unimar.jornada_kids.model.entity.Aplicativo;
import com.unimar.jornada_kids.model.enumeration.PlataformaAplicativo;
import com.unimar.jornada_kids.service.AplicativoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/aplicativos")
public class AplicativoController {
	
	private AplicativoService aplicativoService;

	public AplicativoController(AplicativoService aplicativoService) {
		super();
		this.aplicativoService = aplicativoService;
	}
	
	@GetMapping
	public ResponseEntity<MappingJacksonValue> listarAplicativos(
			@RequestParam(required = false) PlataformaAplicativo plataforma,
			@RequestParam(required = false) Boolean bloqueado) {
		List<AplicativoResumidoDTO> aplicativos = aplicativoService.listarTodas(plataforma, bloqueado);
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(aplicativos);
		
		SimpleBeanPropertyFilter criancaFilter = SimpleBeanPropertyFilter.serializeAllExcept("responsavel");
		SimpleBeanPropertyFilter responsavelFilter = SimpleBeanPropertyFilter.serializeAll();
		
		
		FilterProvider filters = new SimpleFilterProvider()
				.addFilter("CriancaFilter", criancaFilter)
				.addFilter("ResponsavelFilter", responsavelFilter);
		
		mappingJacksonValue.setFilters(filters);
		
		return ResponseEntity.ok(mappingJacksonValue);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MappingJacksonValue> buscarAplicativoPorId(@PathVariable int id) {
		EntityModel<AplicativoDetalhadoDTO> entityModel = EntityModel.of(aplicativoService.buscarPorId(id));
		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).listarAplicativos(null, null));
		entityModel.add(link.withRel("lista-de-aplicativos"));
		
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
	public ResponseEntity<Aplicativo> criarAplicativo(
			@Valid @RequestBody AplicativoNovoDTO aplicativoNovo) {
		Aplicativo aplicativo = aplicativoService.salvar(aplicativoNovo);

		URI localizacao = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(aplicativo.getId())
						.toUri();	

		return ResponseEntity.created(localizacao).build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletarAplicativoPorId(@PathVariable int id) {
		aplicativoService.deletar(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}/bloquear")
	public ResponseEntity<Aplicativo> bloquearAplicativo(@PathVariable int id,
			@Valid @RequestBody AplicativoBloqueadoDTO aplicativoBloqueado) {
		aplicativoService.bloquear(id, aplicativoBloqueado);

		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Aplicativo> atualizarAplicativo(@PathVariable int id,
			@Valid @RequestBody AplicativoUsadoDTO aplicativoUsado) {
		aplicativoService.atualizar(id, aplicativoUsado);

		return ResponseEntity.ok().build();
	}

}
