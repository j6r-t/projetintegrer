package com.projetintegration.projetintegration.controller;

import com.projetintegration.projetintegration.DTO.LoginDTO;
import com.projetintegration.projetintegration.DTO.LoginResponseDTO;
import com.projetintegration.projetintegration.entity.Utilisateur;
import com.projetintegration.projetintegration.repository.UtilisateurRepository;
import com.projetintegration.projetintegration.service.UtilisateurService;
import com.projetintegration.projetintegration.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/UtilAct")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        String reponse = utilisateurService.login(loginDTO);
        if ("ok".equals(reponse)) {
            Utilisateur utilisateur = utilisateurRepository.findByEmail(loginDTO.getEmail());
            LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
            loginResponseDTO.setToken(JwtTokenUtil.generateToken(utilisateur));
            loginResponseDTO.setEmail(utilisateur.getEmail());
            loginResponseDTO.setRole(utilisateur.getRole());
            loginResponseDTO.setId(utilisateur.getId());
            loginResponseDTO.setProfilepic(utilisateur.getProfilepic());
            return ResponseEntity.ok(loginResponseDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> ajouter_util(@RequestBody Utilisateur utilisateur) {
        String reponse = utilisateurService.AjouterUtilisateur(utilisateur);
        if ("email !?".equals(reponse)) {
            return ResponseEntity.notFound().build();
        } else if ("tel !?".equals(reponse)) {
            return ResponseEntity.notFound().build();
        } else {
            Long userId = utilisateur.getId_utilisateur();
            return ResponseEntity.ok(userId);
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
            utilisateur.setId(id);
            utilisateurRepository.save(utilisateur);
            return ResponseEntity.ok("OK");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/login/{id}")
    public ResponseEntity<?> login(@PathVariable Long id) {
            Utilisateur utilisateur = utilisateurRepository.getById(id);
            if(utilisateur!=null) {
                LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
                loginResponseDTO.setProfilepic(utilisateur.getProfilepic());
                return ResponseEntity.ok(loginResponseDTO);
            }
         else {
            return ResponseEntity.notFound().build();
        }
    }
}
