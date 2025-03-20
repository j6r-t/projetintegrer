package com.projetintegration.projetintegration.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "annonce")
public class annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_annonce", nullable = false)
    private Long id_annonce;

    @ManyToOne
    @JoinColumn(name = "id_societe", nullable = false)
    private societe societe;

    @Column (name="description", nullable=false)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_poste", nullable = false, updatable = false)
    private Date date_poste;

}
