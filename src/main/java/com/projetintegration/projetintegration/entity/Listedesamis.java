package com.projetintegration.projetintegration.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "listedesamis")
public class Listedesamis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_liste", nullable = false)
    private Long id_liste;

    @ManyToOne
    @JoinColumn (name = "id_utilisateur1", nullable = false)
    private Utilisateur utilisateur1;

    @ManyToOne
    @JoinColumn (name = "id_utilisateur2", nullable = false)
    private Utilisateur utilisateur2;
}
