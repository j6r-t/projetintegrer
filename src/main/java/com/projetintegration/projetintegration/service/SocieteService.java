package com.projetintegration.projetintegration.service;

import com.projetintegration.projetintegration.entity.Utilisateur;
import com.projetintegration.projetintegration.entity.societe;
import com.projetintegration.projetintegration.repository.SocieteRepository;
import com.projetintegration.projetintegration.repository.UtilisateurRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocieteService {

    @Autowired
    private SocieteRepository societeRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Transactional
    public String ajouter_societer(societe societe) {

        Utilisateur existingUtilisateur = utilisateurRepository.findById(societe.getIdhr().getId_utilisateur())
                .orElseThrow(() -> new RuntimeException("Utilisateur n'esxiste pas"));
        societe.setIdhr(existingUtilisateur);
        societe existsociete = societeRepository.findByNom(societe.getNom());
        if (existsociete != null) {
            return "nom societe existe";
        }
        societeRepository.save(societe);
        return "societe ajoute";
    }
}