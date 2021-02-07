/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.metier;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author estel
 */
@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPhoto;
    private String lien;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="codeA")
    private Article article;
    
    //Constructeurs.
    public Photo(){}
    public Photo(int idPhoto, String lien, Article article) {
        this.idPhoto = idPhoto;
        this.lien = lien;
        this.article = article;
    }
    
    //Getter et Setter.
    public int getIdPhoto() {return idPhoto;}
    public void setIdPhoto(int idPhoto) {this.idPhoto = idPhoto;}
    public String getLien() {return lien;}
    public void setLien(String lien) {this.lien = lien;}
    public Article getArticle() {return article;}
    public void setArticle(Article article) {this.article = article;}
    
    //Equals et HashCode.
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idPhoto;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null) {return false;}
        if (getClass() != obj.getClass()) {return false;}
        final Photo other = (Photo) obj;
        if (this.idPhoto != other.idPhoto) {return false;}
        return true;
    }
    
}
