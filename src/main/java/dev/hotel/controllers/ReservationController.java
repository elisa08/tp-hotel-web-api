package dev.hotel.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.hotel.entite.Chambre;
import dev.hotel.entite.Client;
import dev.hotel.entite.DtoReservation;
import dev.hotel.entite.Reservation;
import dev.hotel.repository.ChambreRepository;
import dev.hotel.repository.ClientERepository;
import dev.hotel.repository.ReservationRepository;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
	
	private ReservationRepository reservationRepo;
	private ClientERepository clientRepo;
	private ChambreRepository chambreRepository;
	
	
	public ReservationController(ReservationRepository reservationRepo, ClientERepository clientRepo,
			ChambreRepository chambreRepository) {
		super();
		this.reservationRepo = reservationRepo;
		this.clientRepo = clientRepo;
		this.chambreRepository = chambreRepository;
	}


	@PostMapping()	
	public ResponseEntity<?> nouvelleReservation(@RequestBody DtoReservation reservation){
		
		String numeroClient="";
		String codeChambre="";
		
		Client client= clientRepo.findByNumero(reservation.getNumeroClient());
		
		
			
			if(client != null) {
				
				numeroClient= reservation.getNumeroClient();
				
			}else {
				
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Le client n'existe pas");
			}
			
		
		List<Chambre> chambres= new ArrayList<>();
			
		
		List<String> chambrReserv= reservation.getChambres();
		
		
			for (String string : chambrReserv) {
				
				Chambre ch= chambreRepository.findByCode(string);
				
				if(ch != null) {
					
					codeChambre= string;
					chambres.add(ch);
					
				}else {
					
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cette chambre n'existe pas");
				}
			}
			
		Reservation reservationSauvee= new Reservation();
		reservationSauvee.setDateDebut(reservation.getDateDebut());
		reservationSauvee.setDateFin(reservation.getDateFin());
		reservationSauvee.setClient(client);
		reservationSauvee.setChambres(chambres);
		reservationRepo.save(reservationSauvee);
		
		return ResponseEntity.status(HttpStatus.OK).body(reservationSauvee);
		
	}

}
