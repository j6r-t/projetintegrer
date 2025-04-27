package com.projetintegration.projetintegration.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.*;

@Entity
@Table(name = "utilisateur")

public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilisateur", nullable = false)
    private Long id_utilisateur;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "role", nullable = false)
    private String role;

    @Column(name = "mdp", nullable = false)
    private String mdp;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "tel", nullable = false)
    private String tel;

    @Column(name = "profilepic", nullable = false)
    private String profilepic;

    public void setId(Long id) {
        this.id_utilisateur = id;
    }

    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public Long getId() {
        return id_utilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Long getId_utilisateur() {
        return id_utilisateur;
    }
}
