package com.projetintegration.projetintegration.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "annonce")
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_annonce", nullable = false)
    private Long idannonce;

    @ManyToOne
    @JoinColumn(name = "id_societe", nullable = false)
    private societe societe;

    @Column (name="description", nullable=false)
    private String description;

    @Column(name = "date_poste", nullable = false, updatable = false)
    private LocalDate date_poste;

    public Annonce() {
    }

    public Annonce(com.projetintegration.projetintegration.entity.societe societe, String description) {
        this.societe = societe;
        this.description = description;
        this.date_poste=LocalDate.now();
    }

    public Long getId_annonce() {
        return idannonce;
    }

    public void setId_annonce(Long id_annonce) {
        this.idannonce = id_annonce;
    }

    public com.projetintegration.projetintegration.entity.societe getSociete() {
        return societe;
    }

    public void setSociete(com.projetintegration.projetintegration.entity.societe societe) {
        this.societe = societe;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate_poste() {
        return date_poste;
    }

    public void setDate_poste(LocalDate date_poste) {
        this.date_poste = date_poste;
    }
}
