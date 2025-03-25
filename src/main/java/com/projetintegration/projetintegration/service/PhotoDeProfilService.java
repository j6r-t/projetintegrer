package com.projetintegration.projetintegration.service;

import com.projetintegration.projetintegration.repository.PhotoDeProfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoDeProfilService {
    @Autowired
    private PhotoDeProfilRepository photoDeProfilRepository;
}
