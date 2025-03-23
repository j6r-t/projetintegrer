package com.projetintegration.projetintegration.controller;

import com.projetintegration.projetintegration.entity.Document;
import com.projetintegration.projetintegration.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/upload")
public class FileUploadController {

    private static final String UPLOAD_DIR = "C:/uploads/";  // Absolute path for the upload directory

    @Autowired
    private DocumentRepository documentRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/documents")
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();  // Return all documents
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/cv")
    public ResponseEntity<String> uploadCV(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("File is empty, please upload a valid file.", HttpStatus.BAD_REQUEST);
        }

        try {
            // Ensure directory exists
            File directory = new File(UPLOAD_DIR);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Generate a unique file name (optional)
            String uniqueFileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Path filePath = Paths.get(UPLOAD_DIR + uniqueFileName);

            // Save the file to the server
            file.transferTo(filePath.toFile());

            // Save file metadata to the database
            Document document = new Document();
            document.setFileName(uniqueFileName);
            document.setFilePath(filePath.toString());
            document.setFileType(file.getContentType());

            documentRepository.save(document);

            return new ResponseEntity<>("File uploaded and metadata saved successfully!", HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error uploading file: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
