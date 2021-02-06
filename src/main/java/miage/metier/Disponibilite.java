/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.metier;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author arsla
 */
@Entity
public class Disponibilite implements  Serializable{
    @EmbeddedId
    private DisponibiliteId id;
    
    private boolean disponible;
    
    @OneToMany
    @JoinColumn(name = "codeA", insertable = false, updatable = false)
    private Article article;
    
    @OneToMany
    @JoinColumn(name = "idMagasin", insertable = false, updatable = false)
    private Magasin idMagasin;
    
    //constructeur
    public Disponibilite() {}

    public Disponibilite(boolean disponible) {
        this.disponible = disponible;        
    }
    
    //Getter et setter

    public DisponibiliteId getId() {
        return id;
    }
    public boolean isDisponible() {
        return disponible;
    }
    public Article getArticle() {
        return article;
    }
    public Magasin getIdMagasin() {
        return idMagasin;
    }

    public void setId(DisponibiliteId id) {
        this.id = id;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    public void setArticle(Article article) {
        this.article = article;
    }
    public void setIdMagasin(Magasin idMagasin) {
        this.idMagasin = idMagasin;
    }
    
    //HashCode et Equals
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Disponibilite other = (Disponibilite) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
}

