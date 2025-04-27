package com.projetintegration.projetintegration.service;

import com.projetintegration.projetintegration.DTO.SocieteDTO;
import com.projetintegration.projetintegration.entity.DemandeSociete;
import com.projetintegration.projetintegration.entity.Utilisateur;
import com.projetintegration.projetintegration.entity.societe;
import com.projetintegration.projetintegration.repository.DemandeSocieteRepository;
import com.projetintegration.projetintegration.repository.SocieteRepository;
import com.projetintegration.projetintegration.repository.UtilisateurRepository;
import jakarta.mail.MessagingException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class SocieteService {

    @Autowired
    private SocieteRepository societeRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private DemandeSocieteRepository demandeSocieteRepository;
    public static Long generateRandomLong() {
        Random random = new Random();
        long max = 9999999999L;
        return random.nextLong() % max;
    }
    @Transactional
    public String ajouter_societer(SocieteDTO societe) throws MessagingException {
        Long id = generateRandomLong();
        Optional<DemandeSociete> d = demandeSocieteRepository.findById(id);
        while(d.isPresent()){
            id = generateRandomLong();
            System.out.println(id);
            d=demandeSocieteRepository.findById(id);
        }
        Utilisateur existingUtilisateur = utilisateurRepository.findByEmail(societe.getIdhr());
        if(existingUtilisateur==null){
            return"utilisateur";
        }
        DemandeSociete societe1 = new DemandeSociete();
        societe1.setId(id);
        societe1.setStatus("en cours de traitement");
        societe1.setDescription(societe.getDescription());
        societe1.setEmail(societe.getEmail());
        societe1.setIdhr(existingUtilisateur);
        societe1.setNom(societe.getNom());
        societe1.setLocalisation(societe.getLocalisation());
        societe1.setProfilePic(societe.getProfilePic());
        societe1.setMdp(societe.getMdp());
        societe existsociete = societeRepository.findByNom(societe1.getNom());
        if (existsociete != null) {
            return "nom societe existe";
        }
        try {
            String body = "Bienvenue dans note platforme de recrutement, votre demande a été enregistré sur le numero :" + societe1.getId() + " Nous allons vous repondre aux plutot possible et merci !! ";
            emailService.sendEmail(societe1.getEmail(), "Votre demande d'ouvrir un compte societe ! ", body);
        }
        catch (MessagingException e){
            System.out.println(e);
            return "email";
        }
        demandeSocieteRepository.save(societe1);
        return "societe ajoute";
    }
}