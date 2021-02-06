/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.metier;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author mamad
 */
@Entity
@Table(name = "commande")
@SuppressWarnings("PersistenceUnitPresent")
public class Commande implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="codecom")
    private int CodeCom;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="codeCli")
    private Client client;
    
    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
    @MapKeyJoinColumn(name = "codeA")
    private Map<Article, QteArticle> qteArticles = new HashMap<>();

    public Commande() {
    }

    public Commande(Client client) {
        this.client = client;
    }
    
    

    public int getCodeCom() {
        return CodeCom;
    }

    public void setCodeCom(int CodeCom) {
        this.CodeCom = CodeCom;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Map<Article, QteArticle> getQteArticles() {
        return qteArticles;
    }

    public void setQteArticles(Map<Article, QteArticle> qteArticles) {
        this.qteArticles = qteArticles;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.CodeCom;
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
        final Commande other = (Commande) obj;
        if (this.CodeCom != other.CodeCom) {
            return false;
        }
        return true;
    }
    
    
    
}
