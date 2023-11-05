package com.microservicioDatos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservicioDatos.Service.AgendaService;
import com.microservicioDatos.model.Contacto;


@RestController
public class Agendacontroller {

ResponseEntity<?> response = null;
	
	@Autowired
	private AgendaService agendaService;
	
	
	@GetMapping(value="/agenda/{email}", produces= MediaType.APPLICATION_JSON_VALUE)
	private Contacto getUsuario(@PathVariable("email") String email) {
	
		Contacto contacto = agendaService.recupearContacto(email);
		return contacto;
	}


	@GetMapping(value="/agenda", produces= MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	private List<Contacto> getUsuario() {
	
		List<Contacto> listaUsuario = agendaService.devolverContactos();
		return listaUsuario;
	}
	
	@PostMapping(value="/agenda",consumes= MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	private String save(@RequestBody Contacto contacto) {
		
		String messae="Guardado";
		try {
			agendaService.agregarContacto(contacto);

		} catch (Exception e) {
			 messae="Ocurrio error";
		}
	

		return messae;

	}

	@PutMapping(value="/agenda",consumes= MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
	@CrossOrigin(origins = "*")
	private String update(@RequestBody Contacto contacto) {
		
		String messae="Guardado";
		try {
			agendaService.agregarContacto(contacto);

		} catch (Exception e) {
			 messae="Ocurrio error";
		}
	

		return messae;
	}
}
