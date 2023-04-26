package it.vincenzopicone.javaspringprod.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.vincenzopicone.javaspringprod.model.Utente;
import it.vincenzopicone.javaspringprod.service.UtenteService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/app")
public class UtenteController {
	
	@Autowired UtenteService utentiService;
	
	@GetMapping("/data1")
	public String testEndPoint() {
		return "Test Data1";
	}
	
	@GetMapping(value="/data2")
	public List<Utente> listaUtentiEndPoint() {
		return utentiService.getAllUtenti();
	}
	
	@GetMapping(value="/data3", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Utente> listaUtentiEndPointJson() {
		return utentiService.getAllUtenti();
	}

}
