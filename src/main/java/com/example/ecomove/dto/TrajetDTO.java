package com.example.ecomove.dto;

public class TrajetDTO {


        private Integer idTrajet;
        private String depart;
        private String arriver;
        private Integer placeDisponible;
        private Double co2;

        public TrajetDTO() {
        }

        public TrajetDTO(Integer idTrajet, String depart, String arriver, Integer placeDisponible, Double co2) {
            this.idTrajet = idTrajet;
            this.depart = depart;
            this.arriver = arriver;
            this.placeDisponible = placeDisponible;
            this.co2 = co2;
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
}
