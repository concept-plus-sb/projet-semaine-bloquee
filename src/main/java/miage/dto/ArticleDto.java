/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.dto;

import java.io.Serializable;

/**
 *
 * @author mamad
 */
public class ArticleDto implements Serializable {
    
    private int CodeArticle;
    private String photo, nutriscore, libelle;
    //point = contenance + unité de mesure
    private String point;
    private float prixUnitaire, prixAuKilo;

    public ArticleDto() {
    }    

    public int getCodeArticle() {
        return CodeArticle;
    }

    public void setCodeArticle(int CodeArticle) {
        this.CodeArticle = CodeArticle;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNutriscore() {
        return nutriscore;
    }

    public void setNutriscore(String nutriscore) {
        this.nutriscore = nutriscore;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public float getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(float prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public float getPrixAuKilo() {
        return prixAuKilo;
    }

    public void setPrixAuKilo(float prixAuKilo) {
        this.prixAuKilo = prixAuKilo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.CodeArticle;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ArticleDto other = (ArticleDto) obj;
        if (this.CodeArticle != other.CodeArticle) {
            return false;
        }
        return true;
    }
    
    
    
}
