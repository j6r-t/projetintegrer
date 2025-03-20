package com.projetintegration.projetintegration.service;

import com.projetintegration.projetintegration.entity.Utilisateur;
import com.projetintegration.projetintegration.entity.annonce;
import com.projetintegration.projetintegration.entity.postuler;
import com.projetintegration.projetintegration.repository.AnnonceRepository;
import com.projetintegration.projetintegration.repository.PostulerRepository;
import com.projetintegration.projetintegration.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostulerService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private AnnonceRepository annonceRepository;
    @Autowired
    private PostulerRepository postulerRepository;
    public String PostulerDemande(postuler postuler){
        Utilisateur utilisateur = utilisateurRepository.getById(postuler.getUtilisateur().getId_utilisateur());
        annonce annonce = annonceRepository.getById_annonce(postuler.getAnnonce().getId_annonce());
        postuler postuler1=postulerRepository.getByUtilisateurAndAnnonce(utilisateur,annonce);
        if(utilisateur!=null && annonce!=null){
            if(postuler1==null){
                postulerRepository.save(postuler);
                return "oui";
            }
            else{
                return "non";
            }
        }
        else{
            return "non";
        }

    }
}
