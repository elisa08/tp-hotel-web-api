package dev.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.hotel.entite.Client;

public interface ClientERepository extends JpaRepository<Client, Integer>{
	
	Client findByNumero(String numero);
	List<Client> findByNom(String nom);

}
