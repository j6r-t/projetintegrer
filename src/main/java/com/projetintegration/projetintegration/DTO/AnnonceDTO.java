package com.projetintegration.projetintegration.DTO;

public class AnnonceDTO {
    private Long id_societe;
    private String description;
    private String nom;
    private String localisation;
    private String societeName;

    public AnnonceDTO(Long id_societe, String description, String nom, String localisation, String societeName) {
        this.id_societe = id_societe;
        this.description = description;
        this.nom = nom;
        this.localisation = localisation;
        this.societeName = societeName;
    }

    public String getSocieteName() {
        return societeName;
    }

    public void setSocieteName(String societeName) {
        this.societeName = societeName;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Long getId_societe() {
        return id_societe;
    }

    public void setId_societe(Long id_societe) {
        this.id_societe = id_societe;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
