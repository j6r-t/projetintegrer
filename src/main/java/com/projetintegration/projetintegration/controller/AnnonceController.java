package com.projetintegration.projetintegration.controller;

import com.projetintegration.projetintegration.entity.annonce;
import com.projetintegration.projetintegration.repository.AnnonceRepository;
import com.projetintegration.projetintegration.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/AnnonceAct")
public class AnnonceController {
    @Autowired
    private AnnonceService annonceService;
    @Autowired
    private AnnonceRepository annonceRepository;
    @PostMapping("/PosterAnnonce")
    public ResponseEntity<?> PosterAnnonce(@RequestBody annonce annonce){
        String reponse =annonceService.CreerAnnonce(annonce);
        if(reponse.equals("ok")){
            return ResponseEntity.ok("ok");
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/SupprimerAnnonce/{id}")
    public ResponseEntity<?> SupprimerAnnonce(@RequestParam Long id){
        annonce annonce=annonceRepository.getReferenceById(id);
        if(annonce!=null){
            annonceRepository.delete(annonce);
            return ResponseEntity.ok("ok");
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

}
