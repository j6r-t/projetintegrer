package com.projetintegration.projetintegration.controller;

import com.projetintegration.projetintegration.entity.Utilisateur;
import com.projetintegration.projetintegration.service.UtilisateurService;
import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="UtilAct/")
public class UtilisateurController {


    @Autowired
    private  UtilisateurService utilisateurService;

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody String email, @RequestBody String mdp){
        String reponse = utilisateurService.login(email,mdp);
        if(reponse=="ok"){
            return ResponseEntity.ok("bienvenue");
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/register")
    public ResponseEntity <?> ajouter_util(@RequestBody Utilisateur utilisateur){
        String reponse = utilisateurService.AjouterUtilisateur(utilisateur);
        if(reponse=="email !?"){
            return ResponseEntity.notFound().build();
        }
        else if (reponse=="tel !?"){
            return  ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok("bienvenue");
        }

    }

}
