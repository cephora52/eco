package com.example.ecomove.dto;

public class UtilisateurDTO {

    private Integer idUser;
    private String nom;
    private String telephone;
    private String role;
    private String password;

    public UtilisateurDTO() {
    }

    public UtilisateurDTO(Integer idUser, String nom, String telephone, String role, String password) {
        this.idUser = idUser;
        this.nom = nom;
        this.telephone = telephone;
        this.role = role;
        this.password = password;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}