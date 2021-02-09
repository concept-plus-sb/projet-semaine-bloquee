/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.metier;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author  Afaf
 */
@Entity
@SuppressWarnings("PersistenceUnitPresent")
public class Nutriscore implements Serializable {
    
    //Propriétes. 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idN; 
    private String nutriscore;
    private String description;
    
    //Constructeurs. 
    public Nutriscore(){}
    public Nutriscore(String nutriscore, String description) {
        this.nutriscore = nutriscore;
        this.description = description;
    }
    
    
    
    //Références et relations. 
    @OneToMany(mappedBy = "nutriscore", fetch = FetchType.LAZY)
    private Set<Article> articles = new HashSet(0);
    
    //Getter et Setter.
    public int getIdN() {return idN;}
    public void setIdN(int idN) {this.idN = idN;}
    public String getNutriscore() {return nutriscore;}
    public void setNutriscore(String nutriscore) {this.nutriscore = nutriscore;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public Set<Article> getArticles() {return articles;}
    public void setArticles(Set<Article> articles) {this.articles = articles;}

   //HashCode et Equals. 
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.idN;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null) {return false;}
        if (getClass() != obj.getClass()) {return false;}
        final Nutriscore other = (Nutriscore) obj;
        if (this.idN != other.idN) {return false;}
        return true;
    }
    
    
    
}
