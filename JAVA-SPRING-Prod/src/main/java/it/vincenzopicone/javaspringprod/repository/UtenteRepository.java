package it.vincenzopicone.javaspringprod.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.vincenzopicone.javaspringprod.model.Utente;

@Repository
public interface UtenteRepository extends CrudRepository<Utente, Long> {

}
