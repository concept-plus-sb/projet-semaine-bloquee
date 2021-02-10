/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.metier;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author estel
 */
@Entity
public class EAN {
    @Id
    private long EAN;
    private String DescriptionEAN;
    
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="codeA")
    private Article article;
 
    
    //Constructeurs
    public EAN() {}
    public EAN(long EAN, String Description, Article article) {
        this.EAN = EAN;
        this.DescriptionEAN = Description;
        this.article = article;
    }
    
    //Getters & Setters
    public Article getArticle() {return article;}
    public void setArticle(Article article) {this.article = article;}
    public long getEAN() {return EAN;}
    public void setEAN(long EAN) {this.EAN = EAN;}
    public String getDescriptionEAN() {return DescriptionEAN;}
    public void setDescriptionEAN(String Description) {this.DescriptionEAN = Description;}
    

    //hashCode & equals 
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (this.EAN ^ (this.EAN >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null) {return false;}
        if (getClass() != obj.getClass()) {return false;}
        final EAN other = (EAN) obj;
        if (this.EAN != other.EAN) {return false;}
        return true;
    }
    
}
