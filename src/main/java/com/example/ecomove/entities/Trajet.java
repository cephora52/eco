package com.example.ecomove.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "trajet")
public class Trajet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTrajet")
    private Integer idTrajet;
    @Column(name = "depart")
    private String depart;
    @Column(name = "arriver")
    private String arriver;
    @Column(name = "place_disponible")
    private Integer placeDisponible;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "co2")
    private Double co2;
    @OneToMany(mappedBy = "idTrajet")
    private Collection<Reservation> reservationCollection;

    public Trajet() {
    }

    public Trajet(Integer idTrajet) {
        this.idTrajet = idTrajet;
    }

    public Integer getIdTrajet() {
        return idTrajet;
    }

    public void setIdTrajet(Integer idTrajet) {
        this.idTrajet = idTrajet;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getArriver() {
        return arriver;
    }

    public void setArriver(String arriver) {
        this.arriver = arriver;
    }

    public Integer getPlaceDisponible() {
        return placeDisponible;
    }

    public void setPlaceDisponible(Integer placeDisponible) {
        this.placeDisponible = placeDisponible;
    }

    public Double getCo2() {
        return co2;
    }

    public void setCo2(Double co2) {
        this.co2 = co2;
    }

    public Collection<Reservation> getReservationCollection() {
        return reservationCollection;
    }

    public void setReservationCollection(Collection<Reservation> reservationCollection) {
        this.reservationCollection = reservationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTrajet != null ? idTrajet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trajet)) {
            return false;
        }
        Trajet other = (Trajet) object;
        if ((this.idTrajet == null && other.idTrajet != null) || (this.idTrajet != null && !this.idTrajet.equals(other.idTrajet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.ecomove.Trajet[ idTrajet=" + idTrajet + " ]";
    }

}
