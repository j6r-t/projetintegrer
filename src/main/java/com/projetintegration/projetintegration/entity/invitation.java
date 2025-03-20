package com.projetintegration.projetintegration.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "invitation")
public class invitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_invitation", nullable = false)
    private Long id_invitation;

    @ManyToOne
    @JoinColumn (name = "id_envoyeur", nullable = false)
    private Utilisateur envoyeur;

    @ManyToOne
    @JoinColumn (name = "id_receveur", nullable = false)
    private Utilisateur receveur;
}
