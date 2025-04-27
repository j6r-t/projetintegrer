package com.projetintegration.projetintegration.service;

import com.projetintegration.projetintegration.DTO.LoginDTO;
import com.projetintegration.projetintegration.entity.Utilisateur;
import com.projetintegration.projetintegration.repository.UtilisateurRepository;
import jakarta.transaction.Transactional;
import jdk.jshell.execution.Util;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
    @Transactional
    public String AjouterUtilisateur(Utilisateur utilisateur){
        Utilisateur u1 = utilisateurRepository.findByEmail(utilisateur.getEmail());
        Utilisateur u2 = utilisateurRepository.findByTel(utilisateur.getTel());
        if(u1!=null){
            return "email";
        }
        else if (u2!=null) {
            return "tel !?";
        }
        else{
            utilisateur.setMdp(passwordEncoder.encode(utilisateur.getMdp()));
            utilisateurRepository.save(utilisateur);
            return"ok";
        }
    }

    public String login (LoginDTO loginDTO) {
        Utilisateur u = utilisateurRepository.findByEmail(loginDTO.getEmail());
        if (u != null && passwordEncoder.matches(loginDTO.getMdp(), u.getMdp())) {
            return "ok";
        }
        else return "non";
    }
}
