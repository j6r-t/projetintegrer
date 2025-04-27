package com.projetintegration.projetintegration.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "societe")

public class societe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_societe", nullable = false)
    private Long id_societe;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "localisation", nullable = false)
    private String localisation;

    @Column(name = "profile_pic")
    private String profilePic;  // Add this to store profile picture URL
    @Column(name = "mdp")
    private String mdp;  // Add this to store profile picture URL
    @ManyToOne
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur", nullable = false)
    private Utilisateur idhr;

    public String getProfilePic() {
        return profilePic;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public void setId(Long id) {
        this.id_societe = id;
    }


    public Long getId() {
        return id_societe;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Utilisateur getIdhr() {
        return idhr;
    }

    public void setIdhr(Utilisateur idhr) {
        this.idhr = idhr;
    }
}
