package it.vincenzopicone.javaspringcons.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/os")
public class ClassConsumer {
	@GetMapping("/get-string")
	public String test() {
		RestTemplate rt = new RestTemplate();
		String url = "http://localhost:8081/app/data1";
		ResponseEntity<String> response = rt.getForEntity(url, String.class);
		return "Test consumer: " + response.getBody();
	}

	@GetMapping("/get-people")
	public Object listaUtenti() {
		RestTemplate rt = new RestTemplate();
		String url = "http://localhost:8081/app/data2";
		Object response = rt.getForObject(url, Object.class);
		return response;
	}
	@GetMapping("/get-people-json")
	public Object listaUtentiJson() {
		RestTemplate rt = new RestTemplate();
		String url = "http://localhost:8081/app/data3";
		Object response = rt.getForObject(url, Object.class);
		return response;
	}

}
