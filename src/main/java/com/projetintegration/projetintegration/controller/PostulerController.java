package com.projetintegration.projetintegration.controller;

import com.projetintegration.projetintegration.entity.postuler;
import com.projetintegration.projetintegration.repository.PostulerRepository;
import com.projetintegration.projetintegration.service.PostulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/PostulerAct")
public class PostulerController {
    @Autowired
    private PostulerService postulerService;
    @PostMapping("/PostulerDemande")
    public ResponseEntity<?> PostulerDemande(@RequestBody postuler postuler){
        String reponse=postulerService.PostulerDemande(postuler);
        if(reponse.equals("oui")){
            return ResponseEntity.ok("ok");
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
