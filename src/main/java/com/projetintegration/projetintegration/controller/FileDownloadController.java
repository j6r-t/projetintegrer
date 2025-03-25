package com.projetintegration.projetintegration.controller;

import com.projetintegration.projetintegration.entity.Document;
import com.projetintegration.projetintegration.repository.DocumentRepository;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLConnection;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/files")
public class FileDownloadController {

    private final DocumentRepository documentRepository;

    public FileDownloadController(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resource> viewFile(@PathVariable Long id) throws Exception {
        // 🔥 Fetch file metadata from the database using the document ID
        Optional<Document> documentOpt = documentRepository.findById(id);

        if (documentOpt.isEmpty()) {
            throw new Exception("File not found in database.");
        }

        Document document = documentOpt.get();
        String filePathString = document.getFilePath(); // Get file path from database

        // Normalize the file path (for security)
        Path filePath = Paths.get(filePathString).normalize();
        Resource resource = new UrlResource(filePath.toUri());

        if (resource.exists() && resource.isReadable()) {
            // Detect MIME type (PDF, images, etc.)
            String mimeType = URLConnection.guessContentTypeFromName(document.getFileName());
            if (mimeType == null) {
                mimeType = "application/octet-stream"; // Default if unknown
            }

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(mimeType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } else {
            throw new Exception("File not found or not readable.");
        }
    }
}
