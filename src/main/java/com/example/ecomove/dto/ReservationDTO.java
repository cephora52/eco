package com.example.ecomove.dto;

import java.util.Date;

public class ReservationDTO {
    private Integer idReservation;
    private Date dateReservation;
    private String statusReservation;

    private Integer idUser;
    private Integer idTrajet;

    public ReservationDTO() {
    }

    public ReservationDTO(Integer idReservation, Date dateReservation, String statusReservation, Integer idUser, Integer idTrajet) {
        this.idReservation = idReservation;
        this.dateReservation = dateReservation;
        this.statusReservation = statusReservation;
        this.idUser = idUser;
        this.idTrajet = idTrajet;
    }

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public String getStatusReservation() {
        return statusReservation;
    }

    public void setStatusReservation(String statusReservation) {
        this.statusReservation = statusReservation;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdTrajet() {
        return idTrajet;
    }

    public void setIdTrajet(Integer idTrajet) {
        this.idTrajet = idTrajet;
    }
}
