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

/**
 *
 * @author mamad
 */
@Entity
public class QteArticle implements  Serializable{
    //Propriétes
    @EmbeddedId
    private QteArticleID id;
    private int NombreArticle;
    
    //Références et relations.
    @ManyToOne
    @JoinColumn(name = "codeA", insertable = false, updatable = false)
    private Article article;
    
    @ManyToOne
    @JoinColumn(name = "CodeCom", insertable = false, updatable = false)
    private Commande commande;

    //Constructeurs.
    public QteArticle() {}
    
    public QteArticle(int NombreArticle, Article article, Commande commande) {
        this.id = new QteArticleID(commande.getCodeCom(),article.getCodeA());
        this.NombreArticle = NombreArticle;
        this.article = article;
        this.commande = commande;
    }
    
    //Getter et setter.
    public QteArticleID getId() {return id;}
    public void setId(QteArticleID id) {this.id = id;}
    public int getNombreArticle() {return NombreArticle;}
    public void setNombreArticle(int NombreArticle) {this.NombreArticle = NombreArticle;}
    public Article getArticle() {return article;}
    public void setArticle(Article article) {this.article = article;}
    public Commande getCommande() {return commande;}
    public void setCommande(Commande commande) {this.commande = commande;}

    //HashCode et Equals.
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null) {return false;}
        if (getClass() != obj.getClass()) {return false;}
        final QteArticle other = (QteArticle) obj;
        if (!Objects.equals(this.id, other.id)) {return false;}
        return true;
    }
    
}
