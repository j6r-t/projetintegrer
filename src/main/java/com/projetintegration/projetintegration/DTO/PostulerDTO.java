package com.projetintegration.projetintegration.DTO;

public class PostulerDTO {
    private Long id_annonce;
    private Long id_utilisateur;

    public Long getId_annonce() {
        return id_annonce;
    }

    public void setId_annonce(Long id_annonce) {
        this.id_annonce = id_annonce;
    }

    public Long getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(Long id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }
}
