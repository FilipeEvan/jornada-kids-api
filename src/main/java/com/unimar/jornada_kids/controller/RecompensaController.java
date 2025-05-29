package com.unimar.jornada_kids.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.unimar.jornada_kids.model.dto.recompensa.RecompensaDetalhadaDTO;
import com.unimar.jornada_kids.model.dto.recompensa.RecompensaNovaDTO;
import com.unimar.jornada_kids.model.dto.recompensa.RecompensaResumidaDTO;
import com.unimar.jornada_kids.model.entity.Recompensa;
import com.unimar.jornada_kids.service.RecompensaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/recompensas")
public class RecompensaController {
	
	private RecompensaService recompensaService;
	
	public RecompensaController(RecompensaService recompensaService) {
		this.recompensaService = recompensaService;
	}
	
	@GetMapping
	public ResponseEntity<MappingJacksonValue> listarRecompensas() {
		List<RecompensaResumidaDTO> recompensas = recompensaService.listarTodas();
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(recompensas);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAll();
		
		FilterProvider filters = 
				new SimpleFilterProvider().addFilter("ResponsavelFilter", filter );
		
		mappingJacksonValue.setFilters(filters);
		
		return ResponseEntity.ok(mappingJacksonValue);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<RecompensaDetalhadaDTO>> buscarRecompensaPorId(@PathVariable int id) {
		EntityModel<RecompensaDetalhadaDTO> entityModel = EntityModel.of(recompensaService.buscarPorId(id));
		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).listarRecompensas());
		entityModel.add(link.withRel("lista-de-recompensas"));
		
		return ResponseEntity.ok(entityModel);
	}
	
	@PostMapping
	public ResponseEntity<Recompensa> criarRecompensa(@Valid @RequestBody RecompensaNovaDTO recompensaNova) {
		Recompensa recompensa = recompensaService.salvar(recompensaNova);

		URI localizacao = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}")
						.buildAndExpand(recompensa.getId())
						.toUri();	

		return ResponseEntity.created(localizacao).build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletarRecompensaPorId(@PathVariable int id) {
		recompensaService.deletar(id);
		
		return ResponseEntity.noContent().build();
	}

}
