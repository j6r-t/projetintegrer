package com.projetintegration.projetintegration.service;

import com.projetintegration.projetintegration.DTO.PostulerDTO;
import com.projetintegration.projetintegration.entity.Utilisateur;
import com.projetintegration.projetintegration.entity.Annonce;
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
    public String PostulerDemande(PostulerDTO postuler){
        Utilisateur utilisateur = utilisateurRepository.getById(postuler.getId_utilisateur());
        Annonce annonce = annonceRepository.getByIdannonce(postuler.getId_annonce());
        postuler postuler1=postulerRepository.getByUtilisateurAndAnnonce(utilisateur,annonce);
        if(utilisateur!=null && annonce!=null){
            if(postuler1==null){
                postuler postuler2 = new postuler(utilisateur,annonce);
                postulerRepository.save(postuler2);
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
