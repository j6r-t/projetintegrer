package com.projetintegration.projetintegration.controller;

import com.projetintegration.projetintegration.DTO.AnnonceDTO;
import com.projetintegration.projetintegration.entity.Annonce;
import com.projetintegration.projetintegration.repository.AnnonceRepository;
import com.projetintegration.projetintegration.repository.SocieteRepository;
import com.projetintegration.projetintegration.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/AnnonceAct")
public class AnnonceController {
    @Autowired
    private AnnonceService annonceService;
    @Autowired
    private AnnonceRepository annonceRepository;
    @Autowired
    private SocieteRepository societeRepository;
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/PosterAnnonce")
    public ResponseEntity<?> PosterAnnonce(@RequestBody AnnonceDTO annonce){
        Annonce annonce1= new Annonce(societeRepository.getById(annonce.getId_societe()),annonce.getDescription(),annonce.getLocalisation(),annonce.getNom());
        annonceRepository.save(annonce1);
        return ResponseEntity.ok("ok");
    }
    @DeleteMapping("/SupprimerAnnonce/{id}")
    public ResponseEntity<?> SupprimerAnnonce(@RequestParam Long id){
        Annonce annonce=annonceRepository.getByIdannonce(id);
        if(annonce!=null){
            annonceRepository.delete(annonce);
            return ResponseEntity.ok("ok");
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/liste")
    public List<AnnonceDTO> getAnnonces() {
        return annonceService.getAllAnnonces();
    }

}
