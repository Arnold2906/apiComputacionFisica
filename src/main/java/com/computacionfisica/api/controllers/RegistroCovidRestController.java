package com.computacionfisica.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.computacionfisica.api.models.entity.RegistroCovid;
import com.computacionfisica.api.models.service.IRegistroCovidService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api")
public class RegistroCovidRestController {

	@Autowired 
	private IRegistroCovidService registroCovidService;
	 

	@GetMapping("/registro")
	public List<RegistroCovid> index() {
		return registroCovidService.findAll();
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<?> registrarIngreso(@RequestBody Map<String, Object> ingreso){
		Map<String, Object> response = new HashMap<>();
		System.out.println(ingreso);
		List<Object[]> registroLast;
		String codigo=String.valueOf(ingreso.get("codigo"));
		
		if(codigo=="" || codigo==" ") {
			response.put("mensaje", "Codigo vacío");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		String fecha=String.valueOf(ingreso.get("fecha"));
		String hora=String.valueOf(ingreso.get("hora"));
		try {
			 registroLast = registroCovidService.registrarHorario(codigo, fecha, hora);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		
		response.put("mensaje", "registro guardado");
		response.put("registro", ingreso);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK );
	}
	
	
	
	

	@PostMapping("/mostrar/{temperatura}")
	public ResponseEntity<?> mostrarxUrl(@PathVariable float temperatura){
		Map<String, Object> response = new HashMap<>();
		List<Object[]> registroLast;
		try {
			 registroLast = registroCovidService.mostrar(temperatura);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		response.put("mensaje", "temperatura guardada");
		response.put("registro", registroLast);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK );
	}
	
	@PostMapping("/temperatura")
	public ResponseEntity<?> mostrar(@RequestBody Map<String, Object> temperatura) {
		Map<String, Object> response = new HashMap<>();
		List<Object[]> registroLast;
		String cadena=String.valueOf(temperatura.get("temperatura"));
		float temperaturafloat = Float.parseFloat(cadena);
		System.out.println(temperaturafloat);
		try {
			 registroLast = registroCovidService.mostrar(temperaturafloat);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		response.put("mensaje", "temperatura guardada");
		response.put("registro", registroLast);
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK );
	}
	
}
