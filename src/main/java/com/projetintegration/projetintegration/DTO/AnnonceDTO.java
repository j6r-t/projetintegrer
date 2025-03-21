package com.projetintegration.projetintegration.DTO;

public class AnnonceDTO {
    private Long id_societe;
    private String description;

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
