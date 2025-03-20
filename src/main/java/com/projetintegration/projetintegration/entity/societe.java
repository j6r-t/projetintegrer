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

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur", nullable = false)
    private Utilisateur idhr;



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
