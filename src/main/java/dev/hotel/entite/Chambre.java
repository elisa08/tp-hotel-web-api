package dev.hotel.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Chambre extends BaseEntite {

    @Column(unique = true, nullable = false)
    private String code;

    private String numero;
    private Float surface;

    @ManyToOne
    private Hotel hotel;

    public Chambre() {
    }

    public Chambre(String numero, Float surface, Hotel hotel) {

        this.numero = numero;
        this.surface = surface;
        this.hotel = hotel;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Float getSurface() {
        return surface;
    }

    public void setSurface(Float surfaceEnM2) {
        this.surface = surfaceEnM2;
    }
}
