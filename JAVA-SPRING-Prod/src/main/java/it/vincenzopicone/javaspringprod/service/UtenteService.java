package it.vincenzopicone.javaspringprod.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.vincenzopicone.javaspringprod.model.Utente;
import it.vincenzopicone.javaspringprod.repository.UtenteRepository;

@Service
public class UtenteService {
	
	@Autowired UtenteRepository repo;
	
	
	public List<Utente> getAllUtenti() {
		return (List<Utente>) repo.findAll();
	}
	


}
