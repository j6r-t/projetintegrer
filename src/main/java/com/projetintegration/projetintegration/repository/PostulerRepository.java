package com.projetintegration.projetintegration.repository;

import com.projetintegration.projetintegration.entity.Annonce;
import com.projetintegration.projetintegration.entity.Utilisateur;
import com.projetintegration.projetintegration.entity.Annonce;
import com.projetintegration.projetintegration.entity.postuler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostulerRepository extends JpaRepository<postuler, Long> {
    public postuler getByUtilisateurAndAnnonce(Utilisateur utilisateur, Annonce annonce);
}
