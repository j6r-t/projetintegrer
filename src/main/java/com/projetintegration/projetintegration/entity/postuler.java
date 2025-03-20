package com.projetintegration.projetintegration.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "postuler")
public class postuler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_postuler", nullable = false)
    private Long id_postuler;

    @ManyToOne
    @JoinColumn (name = "id_utilisateur", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn (name = "id_annonce", nullable = false)
    private annonce annonce;

    public Long getId_postuler() {
        return id_postuler;
    }

    public void setId_postuler(Long id_postuler) {
        this.id_postuler = id_postuler;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public com.projetintegration.projetintegration.entity.annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(com.projetintegration.projetintegration.entity.annonce annonce) {
        this.annonce = annonce;
    }
}
