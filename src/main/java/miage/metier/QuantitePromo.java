/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.metier;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Ismail
 */
@Entity
public class QuantitePromo implements Serializable {
   
    @EmbeddedId
    private QuantitePromoId Id;
    //References
    @ManyToOne
    @JoinColumn(name="CodePromo")
    private Promotion promotion;
    
    @ManyToOne    
    @JoinColumn(name="CodeA")
    private Article article;
    
    //Constructeurs
    public QuantitePromo(){}
    public QuantitePromo(Promotion promotion, Article article) {
        this.promotion = promotion;
        this.article = article;
    }
    
    //Getters et Setters
    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
    
    //Hashcode et Equals

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.promotion);
        hash = 37 * hash + Objects.hashCode(this.article);
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
        final QuantitePromo other = (QuantitePromo) obj;
        if (!Objects.equals(this.promotion, other.promotion)) {
            return false;
        }
        if (!Objects.equals(this.article, other.article)) {
            return false;
        }
        return true;
    }
    
    
}
