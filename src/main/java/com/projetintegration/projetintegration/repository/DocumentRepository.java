package com.projetintegration.projetintegration.repository;

import com.projetintegration.projetintegration.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
