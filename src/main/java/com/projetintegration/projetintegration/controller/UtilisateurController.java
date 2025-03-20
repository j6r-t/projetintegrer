package com.projetintegration.projetintegration.controller;

import com.projetintegration.projetintegration.entity.Utilisateur;
import com.projetintegration.projetintegration.repository.UtilisateurRepository;
import com.projetintegration.projetintegration.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="UtilAct/")
public class UtilisateurController {


    @Autowired
    private  UtilisateurService utilisateurService;
    private UtilisateurRepository utilisateurRepository;
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        // Initialize a new Utilisateur object to bind to the form
        model.addAttribute("utilisateur", new Utilisateur());
        return "register";  // "register" refers to the name of the Thymeleaf template (register.html)
    }
    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody String email, @RequestBody String mdp){
        String reponse = utilisateurService.login(email,mdp);
        if(reponse=="ok"){
            return ResponseEntity.ok("3aslema");
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/register")
    public ResponseEntity <?> ajouter_util(@ModelAttribute Utilisateur utilisateur){
        String reponse = utilisateurService.AjouterUtilisateur(utilisateur);
        if(reponse=="email !?"){
            return ResponseEntity.notFound().build();
        }
        else if (reponse=="tel !?"){
            return  ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok("3aslema");
        }
    }
    @DeleteMapping("/SupprimerUtilisateur/{id}")
    public ResponseEntity <?> SupprimerUtilisateur(@PathVariable Long id) {
        Utilisateur utilisateur = utilisateurRepository.getReferenceById(id);
        if (utilisateur != null) {
            utilisateurRepository.deleteById(id);
            return ResponseEntity.ok("ok");
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/ModifierUtilisateur/{id}")
    public ResponseEntity<?> ModifierUtilisateur(@PathVariable Long id,@RequestBody Utilisateur utilisateur){
        Utilisateur utilisateur1 = utilisateurRepository.getReferenceById(id);
        if(utilisateur1!=null){
            utilisateurRepository.save(utilisateur);
            return ResponseEntity.ok("ok");
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
