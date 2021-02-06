/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.metier;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Ismail
 */
@Entity
@SuppressWarnings("PersistenceUnitPresent")
public class MarqueProprietaire implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int IdMarque; 
    private String Marque;
    
    //References
    @OneToMany
     @JoinColumn(name="CodeA")
    Set<Article> articles= new HashSet<>(0);
    
    //Constructeurs
    public MarqueProprietaire(){}
    public MarqueProprietaire(int IdMarque, String Marque) {
        this.IdMarque = IdMarque;
        this.Marque = Marque;
    }
    
    //Getters et Setters

    public int getIdMarque() {
        return IdMarque;
    }

    public void setIdMarque(int IdMarque) {
        this.IdMarque = IdMarque;
    }

    public String getMarque() {
        return Marque;
    }

    public void setMarque(String Marque) {
        this.Marque = Marque;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }
    
    //Hashcode et Equals

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.IdMarque;
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
        final MarqueProprietaire other = (MarqueProprietaire) obj;
        if (this.IdMarque != other.IdMarque) {
            return false;
        }
        return true;
    }
    
    
}
