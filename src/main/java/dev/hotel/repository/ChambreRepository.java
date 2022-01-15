package dev.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.hotel.entite.Chambre;

public interface ChambreRepository extends JpaRepository<Chambre, Integer>{
	
	Chambre findByCode(String code);

}
