package com.projetintegration.projetintegration.repository;

import com.projetintegration.projetintegration.entity.Annonce;
import com.projetintegration.projetintegration.entity.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
    Annonce getByIdannonce(Long id);
}
