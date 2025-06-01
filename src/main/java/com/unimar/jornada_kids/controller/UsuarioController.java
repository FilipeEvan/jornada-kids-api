package com.unimar.jornada_kids.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.unimar.jornada_kids.model.dto.usuario.UsuarioAutenticadoDTO;
import com.unimar.jornada_kids.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/usuarios")
public class UsuarioController {
	
	private UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@PostMapping("/autenticar")
	public ResponseEntity<MappingJacksonValue> autenticarUsuario(@Valid @RequestBody UsuarioAutenticadoDTO usuarioAutenticado) {	
		Object dto = usuarioService.autenticar(usuarioAutenticado);
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(dto);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.serializeAll();
		
		FilterProvider filters = new SimpleFilterProvider()
				.addFilter("CriancaFilter", filter);
		
		mappingJacksonValue.setFilters(filters);
		
		return ResponseEntity.ok(mappingJacksonValue);
	}
	
}
