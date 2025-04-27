package com.projetintegration.projetintegration.controller;

import com.projetintegration.projetintegration.DTO.AnnonceDTO;
import com.projetintegration.projetintegration.DTO.JobDto;
import com.projetintegration.projetintegration.entity.Annonce;
import com.projetintegration.projetintegration.repository.AnnonceRepository;
import com.projetintegration.projetintegration.repository.SocieteRepository;
import com.projetintegration.projetintegration.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/AnnonceAct")
public class AnnonceController {
    @Autowired
    private AnnonceService annonceService;
    @Autowired
    private AnnonceRepository annonceRepository;
    @Autowired
    private SocieteRepository societeRepository;
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/PosterAnnonce")
    public ResponseEntity<?> PosterAnnonce(@RequestBody AnnonceDTO annonce){
        Annonce annonce1= new Annonce(societeRepository.getById(annonce.getId_societe()),annonce.getDescription(),annonce.getLocalisation(),annonce.getNom());
        annonceRepository.save(annonce1);
        return ResponseEntity.ok("ok");
    }
    @DeleteMapping("/SupprimerAnnonce/{id}")
    public ResponseEntity<?> SupprimerAnnonce(@RequestParam Long id){
        Annonce annonce=annonceRepository.getByIdannonce(id);
        if(annonce!=null){
            annonceRepository.delete(annonce);
            return ResponseEntity.ok("ok");
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/liste")
    public List<AnnonceDTO> getAnnonces() {
        return annonceService.getAllAnnonces();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/listepromax")
    public List<JobDto> getAll(){
        List<Annonce> annonces = annonceRepository.findAll();
        List<JobDto> jobDtoList = new ArrayList<>();

        for (Annonce annonce : annonces) {
            JobDto dto = new JobDto();
            dto.setIdjob(annonce.getId_annonce());
            dto.setNom(annonce.getNomannonce());
            dto.setLocalisation(annonce.getLocalisation());
            dto.setSalaire(annonce.getSalaire());
            dto.setType(annonce.getType());
            dto.setSocieteImage(annonce.getSociete().getProfilePic());

            if (annonce.getSociete() != null) {
                dto.setSocieteName(annonce.getSociete().getNom());
                dto.setSocieteImage(annonce.getSociete().getProfilePic());
            }

            jobDtoList.add(dto);
        }

        return jobDtoList;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/annonce/{id}")
    public JobDto getann(@PathVariable Long id){
        Annonce annonce = annonceRepository.getByIdannonce(id);
            JobDto dto = new JobDto();
            dto.setIdjob(annonce.getId_annonce());
            dto.setNom(annonce.getNomannonce());
            dto.setLocalisation(annonce.getLocalisation());
            dto.setSalaire(annonce.getSalaire());
            dto.setType(annonce.getType());
            dto.setDescription(annonce.getDescription());

            if (annonce.getSociete() != null) {
                dto.setSocieteName(annonce.getSociete().getNom());
                dto.setSocieteImage(annonce.getSociete().getProfilePic());
            }
        return dto;

        }

    }

