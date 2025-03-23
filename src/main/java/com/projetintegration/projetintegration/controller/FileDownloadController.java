package com.projetintegration.projetintegration.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class FileDownloadController {
    private static final String UPLOAD_DIR = "uploads/";

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/uploads/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) throws Exception {
        // Decode the fileName to handle special characters
        fileName = java.net.URLDecoder.decode(fileName, "UTF-8");

        // Correct the path to prevent issues with absolute paths
        Path filePath = Paths.get(UPLOAD_DIR + fileName).normalize();  // Normalize the path to prevent path traversal issues
        Resource resource = new UrlResource(filePath.toUri());
        System.out.println("File path: " + filePath.toString());

        if (resource.exists() && resource.isReadable()) {
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } else {
            throw new Exception("File not found or not readable.");
        }
    }

}
