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
}
