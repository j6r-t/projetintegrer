package com.projetintegration.projetintegration.controller;

import com.projetintegration.projetintegration.DTO.PostulerDTO;
import com.projetintegration.projetintegration.entity.postuler;
import com.projetintegration.projetintegration.repository.PostulerRepository;
import com.projetintegration.projetintegration.service.PostulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/PostulerAct")
public class PostulerController {
    @Autowired
    private PostulerService postulerService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/postuler")
    public ResponseEntity<?> PostulerDemande(@RequestBody PostulerDTO postuler){
        String reponse=postulerService.PostulerDemande(postuler);
        if(reponse.equals("oui")){
            return ResponseEntity.ok("");
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

}
