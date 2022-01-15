package dev.hotel.entite;

import java.time.LocalDate;
import java.util.List;

public class DtoReservation {
	
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private String numeroClient;
	private List<String> chambres;
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	public String getNumeroClient() {
		return numeroClient;
	}
	public void setNumeroClient(String numeroClient) {
		this.numeroClient = numeroClient;
	}
	public List<String> getChambres() {
		return chambres;
	}
	public void setChambres(List<String> chambres) {
		this.chambres = chambres;
	}
	
	

}
