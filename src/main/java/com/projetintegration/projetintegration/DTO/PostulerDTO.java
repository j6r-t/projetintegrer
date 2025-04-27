package com.projetintegration.projetintegration.DTO;

public class PostulerDTO {
    private Long id_annonce;
    private Long id_utilisateur;
    private String cvurl;
    private String lettreurl;
    public Long getId_annonce() {
        return id_annonce;
    }

    public String getCvurl() {
        return cvurl;
    }

    public void setCvurl(String cvurl) {
        this.cvurl = cvurl;
    }

    public String getLettreurl() {
        return lettreurl;
    }

    public void setLettreurl(String lettreurl) {
        this.lettreurl = lettreurl;
    }

    public void setId_annonce(Long id_annonce) {
        this.id_annonce = id_annonce;
    }

    public Long getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(Long id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }
}
