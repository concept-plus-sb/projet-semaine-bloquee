/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.metier;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Ismail
 */
@Entity
@SuppressWarnings("PersistenceUnitPresent")
public class Promotion implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int codePromo;
    private EnumTypePromo typePromo;
    private int pourcentagePromo;
    private String libellePromo;
    private int nbArticlePromo;
    
    @OneToMany(mappedBy = "promotion", fetch = FetchType.EAGER)
    Set<Article> articles =  new HashSet<>();
    
    //Constructeur 

    public Promotion() {}

    public Promotion(EnumTypePromo typePromo, int pourcentagePromo, String libellePromo, int nbArticlePromo) {
        this.typePromo = typePromo;
        this.pourcentagePromo = pourcentagePromo;
        this.libellePromo = libellePromo;
        this.nbArticlePromo = nbArticlePromo;
    }
    
    
    //Getters & Setters
    public int getCodePromo() {return codePromo;}
    public void setCodePromo(int codePromo) {this.codePromo = codePromo;}
    public EnumTypePromo getTypePromo() {return typePromo;}
    public void setTypePromo(EnumTypePromo typePromo) {this.typePromo = typePromo;}
    public int getPourcentagePromo() {return pourcentagePromo;}
    public void setPourcentagePromo(int pourcentagePromo) {this.pourcentagePromo = pourcentagePromo;}
    public String getLibellePromo() {return libellePromo;}
    public void setLibellePromo(String libellePromo) {this.libellePromo = libellePromo;}
    public int getNbArticlePromo() {return nbArticlePromo;}
    public void setNbArticlePromo(int nbArticlePromo) {this.nbArticlePromo = nbArticlePromo;}
    public Set<Article> getArticles() {return articles;}
    public void setArticles(Set<Article> articles) {this.articles = articles;}
    
    //HashCode et equals. 
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.codePromo;
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
        final Promotion other = (Promotion) obj;
        if (this.codePromo != other.codePromo) {
            return false;
        }
        return true;
    }
    
}
