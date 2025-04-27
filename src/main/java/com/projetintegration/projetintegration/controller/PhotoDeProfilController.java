package com.projetintegration.projetintegration.controller;

import com.projetintegration.projetintegration.entity.PhotoDeProfil;
import com.projetintegration.projetintegration.entity.Utilisateur;
import com.projetintegration.projetintegration.repository.PhotoDeProfilRepository;
import com.projetintegration.projetintegration.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/photo-profil")
public class PhotoDeProfilController {

    private static final String UPLOAD_DIR = "C:/uploads/";

    @Autowired
    private PhotoDeProfilRepository photoDeProfilRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @PostMapping("/upload/{userId}")
    public ResponseEntity<String> uploadPhoto(@PathVariable Long userId, @RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is empty, please upload a valid file.");
        }

        Optional<Utilisateur> utilisateurOpt = utilisateurRepository.findById(userId);
        if (utilisateurOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("User not found.");
        }

        try {
            // Ensure directory exists
            File directory = new File(UPLOAD_DIR);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Generate a unique file name
            String uniqueFileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIR + uniqueFileName);

            // Save file to the server
            file.transferTo(filePath.toFile());

            // Save file metadata to the database
            PhotoDeProfil photo = new PhotoDeProfil();
            photo.setFileName(uniqueFileName);
            photo.setFilePath(filePath.toString());
            photo.setFileType(file.getContentType());
            photo.setUtilisateur(utilisateurOpt.get());
            photoDeProfilRepository.save(photo);

            return ResponseEntity.ok("");

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error uploading file: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> viewPhoto(@PathVariable Long id) throws Exception {
        PhotoDeProfil photoOpt = photoDeProfilRepository.findByUtilisateurId(id);

        if (photoOpt==null) {
            throw new Exception("Photo not found in database.");
        }

        PhotoDeProfil photo = photoOpt;
        String filePathString = photo.getFilePath();

        Path filePath = Paths.get(filePathString).normalize();
        Resource resource = new UrlResource(filePath.toUri());

        if (resource.exists() && resource.isReadable()) {
            String mimeType = URLConnection.guessContentTypeFromName(photo.getFileName());
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(mimeType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } else {
            throw new Exception("Photo not found or not readable.");
        }
    }
}