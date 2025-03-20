package com.projetintegration.projetintegration.repository;

import com.projetintegration.projetintegration.entity.annonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceRepository extends JpaRepository<annonce, Long> {
    public annonce getById_annonce(Long id);

}
