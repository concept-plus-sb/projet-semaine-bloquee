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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author arsla
 */
@Entity
public class Disponibilite implements  Serializable{
    @EmbeddedId
    private DisponibiliteId id;
    
    private int qteDispo;
    
    @ManyToOne
    @JoinColumn(name = "codeA", insertable = false, updatable = false)
    private Article article;
    
    @ManyToOne
    @JoinColumn(name = "idMagasin", insertable = false, updatable = false)
    private Magasin magasin;
    
    //constructeur
    public Disponibilite() {}
    public Disponibilite(int qte, Article article, Magasin idMagasin) {
        this.id = new DisponibiliteId(article.getCodeA(),idMagasin.getIdMagasin());
        this.qteDispo = qte;
        this.article = article;
        this.magasin = idMagasin;
    }
    
    //Getter et setter
    public DisponibiliteId getId() {return id;}
    public void setId(DisponibiliteId id) {this.id = id;}
    public int getQteDispo() {return qteDispo;}
    public void setQteDispo(int qte) {this.qteDispo = qte;}
    //A TESTER AFAF
    public void decQteDispo(int qte) {this.qteDispo = this.qteDispo-qte;}
    public Article getArticle() {return article;}
    public void setArticle(Article article) {this.article = article;}
    public Magasin getIdMagasin() {return magasin;}
    public void setIdMagasin(Magasin idMagasin) {this.magasin = idMagasin;}

    //HashCode et Equals
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null) {return false;}
        if (getClass() != obj.getClass()) {return false;}
        final Disponibilite other = (Disponibilite) obj;
        if (!Objects.equals(this.id, other.id)) {return false;}
        return true;
    }

    
}

