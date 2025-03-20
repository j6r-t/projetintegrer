package com.projetintegration.projetintegration.service;

import com.projetintegration.projetintegration.entity.Utilisateur;
import com.projetintegration.projetintegration.entity.societe;
import com.projetintegration.projetintegration.repository.SocieteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocieteService {
    @Autowired
    private SocieteRepository SocieteRepository;
    @Transactional
    public String ajouter_societer( societe societe){
        societe existsocieter = SocieteRepository.findByNom(societe.getNom());
        if (existsocieter!=null){
            return "nom societe existe";
        }
        else{
            SocieteRepository.save(societe);
            return "societe ajoute";
        }
    }
}
