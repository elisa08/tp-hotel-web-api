package dev.hotel.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.entite.Client;
import dev.hotel.repository.ClientERepository;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	private ClientERepository clientRepo;

	public ClientController(ClientERepository clientRepo) {
		super();
		this.clientRepo = clientRepo;
	}

	@GetMapping()
	public List<Client> listerClient(@RequestParam Integer start, @RequestParam Integer size) {
		PageRequest pagination = PageRequest.of(start, size);
		List<Client> clients = clientRepo.findAll(pagination).toList();

		return clients;
	}

	@GetMapping("/{numero}")

	public ResponseEntity<?> numeroClient(@PathVariable String numero) {

		Client client = clientRepo.findByNumero(numero);

		if (client == null) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Le numéro n'existe pas");
			
		}

		return ResponseEntity.status(HttpStatus.OK).body(client);
	}

	@PostMapping()

	public ResponseEntity<?> nomClient(@RequestBody Client client) {

		if (client.getNom().length() < 2) {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Le nom est trop court");
		}
		Client cli = new Client();
		cli.setNom(client.getNom());
		cli.setPrenoms(client.getPrenoms());
		cli.setNumero("C" + new Date().getTime());
		clientRepo.save(cli);
		return ResponseEntity.status(HttpStatus.OK).body(cli);

	}

}
