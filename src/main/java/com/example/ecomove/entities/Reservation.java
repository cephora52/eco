package com.example.ecomove.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idReservation")
    private Integer idReservation;
    @Column(name = "dateReservation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReservation;
    @Column(name = "statusReservation")
    private String statusReservation;
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne
    private Utilisateur idUser;
    @JoinColumn(name = "idTrajet", referencedColumnName = "idTrajet")
    @ManyToOne
    private Trajet idTrajet;

    public Reservation() {
    }

    public Reservation(Integer idReservation) {
        this.idReservation = idReservation;
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

    public Utilisateur getIdUser() {
        return idUser;
    }

    public void setIdUser(Utilisateur idUser) {
        this.idUser = idUser;
    }

    public Trajet getIdTrajet() {
        return idTrajet;
    }

    public void setIdTrajet(Trajet idTrajet) {
        this.idTrajet = idTrajet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReservation != null ? idReservation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservation)) {
            return false;
        }
        Reservation other = (Reservation) object;
        if ((this.idReservation == null && other.idReservation != null) || (this.idReservation != null && !this.idReservation.equals(other.idReservation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.ecomove.Reservation[ idReservation=" + idReservation + " ]";
    }

}
