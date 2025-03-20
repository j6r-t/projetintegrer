package com.projetintegration.projetintegration.repository;

import com.projetintegration.projetintegration.entity.Utilisateur;
import com.projetintegration.projetintegration.entity.invitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvitationRepository extends JpaRepository<invitation, Long> {
}
