package com.projetintegration.projetintegration.service;

import com.projetintegration.projetintegration.DTO.AnnonceDTO;
import com.projetintegration.projetintegration.entity.Annonce;
import com.projetintegration.projetintegration.entity.societe;
import com.projetintegration.projetintegration.repository.AnnonceRepository;
import com.projetintegration.projetintegration.repository.SocieteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class AnnonceService {
    private final AnnonceRepository annonceRepository;
    private final SocieteRepository societeRepository;
    public AnnonceService(AnnonceRepository annonceRepository, SocieteRepository societeRepository) {
        this.annonceRepository = annonceRepository;
        this.societeRepository = societeRepository;
    }
    @Transactional
    public String CreerAnnonce(AnnonceDTO annonce){
        System.out.println(annonce.getId_societe());
        societe societe= societeRepository.getById(annonce.getId_societe());
        Annonce annonce1 = new Annonce(societe,annonce.getDescription());
        annonceRepository.save(annonce1);
        return"ok";
    }


}
