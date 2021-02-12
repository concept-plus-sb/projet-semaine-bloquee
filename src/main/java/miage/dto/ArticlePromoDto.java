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
public class ArticlePromoDto implements Serializable {
    
    private int CodeArticle;
    private String photo, nutriscore, libelle, libellePromo, uniteL;
    //point = contenance + unité de mesure
    private String point;
    private float prixUnitaire, prixAuKilo, prixUnitairePromo;
    private int qteDisponible;
    private int pourcentage, rang;

    public ArticlePromoDto() {
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

    public String getLibellePromo() {
        return libellePromo;
    }

    public void setLibellePromo(String libellePromo) {
        this.libellePromo = libellePromo;
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

    public int getQteDisponible() {
        return qteDisponible;
    }

    public void setQteDisponible(int qteDisponible) {
        this.qteDisponible = qteDisponible;
    }

    public int getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }

    public float getPrixUnitairePromo() {
        return prixUnitairePromo;
    }

    public void setPrixUnitairePromo(float prixUnitairePromo) {
        this.prixUnitairePromo = prixUnitairePromo;
    }

    public String getUniteL() {
        return uniteL;
    }

    public void setUniteL(String uniteL) {
        this.uniteL = uniteL;
    }
    
    
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.CodeArticle;
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
        final ArticlePromoDto other = (ArticlePromoDto) obj;
        if (this.CodeArticle != other.CodeArticle) {
            return false;
        }
        return true;
    }
    
    
    
    
}
