package com.projetintegration.projetintegration.service;

import com.projetintegration.projetintegration.entity.annonce;
import com.projetintegration.projetintegration.entity.societe;
import com.projetintegration.projetintegration.repository.AnnonceRepository;
import com.projetintegration.projetintegration.repository.SocieteRepository;
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

    public String CreerAnnonce(annonce annonce){
        societe s=societeRepository.getReferenceById(annonce.getSociete().getId());
        if(s!=null){
            annonce.setDate_poste(LocalDate.now());
            annonceRepository.save(annonce);
            return"ok";
        }
        else{
            return "non";
        }
    }


}
