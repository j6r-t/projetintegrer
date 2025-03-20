package com.projetintegration.projetintegration.controller;

import com.projetintegration.projetintegration.entity.Utilisateur;
import com.projetintegration.projetintegration.repository.UtilisateurRepository;
import com.projetintegration.projetintegration.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "UtilAct/")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private UtilisateurRepository utilisateurRepository;  // Ensure that this is injected

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        // Initialize a new Utilisateur object to bind to the form
        model.addAttribute("utilisateur", new Utilisateur());
        return "register";  // "register" refers to the name of the Thymeleaf template (register.html)
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String mdp) {
        String reponse = utilisateurService.login(email, mdp);
        if ("ok".equals(reponse)) {
            return ResponseEntity.ok("Bienvenue");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> ajouter_util(@ModelAttribute Utilisateur utilisateur) {
        String reponse = utilisateurService.AjouterUtilisateur(utilisateur);
        if ("email !?".equals(reponse)) {
            return ResponseEntity.notFound().build();
        } else if ("tel !?".equals(reponse)) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok("3aslema");
        }
    }

    @DeleteMapping("/SupprimerUtilisateur/{id}")
    public ResponseEntity<?> SupprimerUtilisateur(@PathVariable Long id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElse(null);
        if (utilisateur != null) {
            utilisateurRepository.deleteById(id);
            return ResponseEntity.ok("OK");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/ModifierUtilisateur/{id}")
    public ResponseEntity<?> ModifierUtilisateur(@PathVariable Long id, @RequestBody Utilisateur utilisateur) {
        Utilisateur utilisateur1 = utilisateurRepository.findById(id).orElse(null);
        if (utilisateur1 != null) {
            utilisateur.setId(id);  // Ensure the ID is set before saving
            utilisateurRepository.save(utilisateur);
            return ResponseEntity.ok("OK");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
