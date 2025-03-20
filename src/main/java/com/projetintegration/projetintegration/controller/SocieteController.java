package com.projetintegration.projetintegration.controller;

import com.projetintegration.projetintegration.entity.societe;
import com.projetintegration.projetintegration.service.SocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/SocieteAct")
public class SocieteController {

    @Autowired
    private SocieteService societeService;

    @PostMapping("/ajout_societe")
    public ResponseEntity<?> ajoute_societe(@RequestBody societe societe) {
        String resp = societeService.ajouter_societer(societe);
        if (resp.equals("nom societe existe")) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok("societe ajoute");
        }
    }

}
