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
import java.util.ArrayList;
import java.util.List;

@Service
public class AnnonceService {
    private final AnnonceRepository annonceRepository;
    private final SocieteRepository societeRepository;
    public AnnonceService(AnnonceRepository annonceRepository, SocieteRepository societeRepository) {
        this.annonceRepository = annonceRepository;
        this.societeRepository = societeRepository;
    }
    public List<AnnonceDTO> getAllAnnonces() {
        List<Annonce> annonces = annonceRepository.findAll();
        List<AnnonceDTO> annonceDTOs = new ArrayList<>();
        for (Annonce annonce : annonces) {
            annonceDTOs.add(new AnnonceDTO(
                    annonce.getId_annonce(),
                    annonce.getNomannonce(),
                    annonce.getLocalisation(),
                    annonce.getDescription(),
                    annonce.getSociete().getNom() // Accessing the Societe name
            ));
        }
        return annonceDTOs;
    }


}
