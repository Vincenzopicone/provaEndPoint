package it.vincenzopicone.javaspringprod.runner;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import it.vincenzopicone.javaspringprod.model.Utente;
import it.vincenzopicone.javaspringprod.repository.UtenteRepository;

@Component
public class UtenteRunner implements ApplicationRunner {

	@Autowired UtenteRepository repo;
	@Override
	public void run(ApplicationArguments args) throws Exception {
	System.out.println("RUUUUUUUUN");
		for(int i = 0; i < 10; i++) {
			//creaUtentiFake();
		}
		

	}
	
	private void creaUtentiFake() {
		Faker fake = Faker.instance(new Locale("it-IT"));
		repo.save(Utente.builder()
				.nome(fake.name().firstName())
				.cognome(fake.name().lastName())
				.indirizzo(fake.address().city() 
						+ ", " 
						+ fake.address().streetName() 
						+ ", " 
						+ fake.address().streetAddressNumber()).build());
	}

}
