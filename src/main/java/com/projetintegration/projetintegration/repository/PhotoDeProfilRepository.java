package com.projetintegration.projetintegration.repository;

import com.projetintegration.projetintegration.entity.Listedesamis;
import com.projetintegration.projetintegration.entity.PhotoDeProfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoDeProfilRepository  extends JpaRepository<PhotoDeProfil,Long> {
    PhotoDeProfil findByUtilisateurId(Long id);
}
