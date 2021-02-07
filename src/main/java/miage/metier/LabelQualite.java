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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author Afaf
 */
@Entity
@SuppressWarnings("PersistenceUnitPresent")
public class LabelQualite implements Serializable {
    
    //Propriétés.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLQ; 
    private String libelleLQ;
    
    //Constructeurs.
    public LabelQualite(){}
    
    public LabelQualite(int idLQ, String libelleLQ) {
        this.idLQ = idLQ;
        this.libelleLQ = libelleLQ;
    }
    
    //Références et relations.
    @ManyToMany
    @JoinTable(name = "Detenir",
    joinColumns = @JoinColumn(name = "idLQ"),
    inverseJoinColumns = @JoinColumn(name = "codeA"))
    private Set<Article> articles = new HashSet(0);
    
    //Getter et Setter. 
    public int getIdLQ() {return idLQ;}
    public void setIdLQ(int idLQ) {this.idLQ = idLQ;}
    public String getLibelleLQ() {return libelleLQ;}
    public void setLibelleLQ(String libelleLQ) {this.libelleLQ = libelleLQ;}
    
    //HashCode et Equals. 
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.idLQ;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null) {return false;}
        if (getClass() != obj.getClass()) {return false;}
        final LabelQualite other = (LabelQualite) obj;
        if (this.idLQ != other.idLQ) {return false;}
        return true;
    }
   
   
    
    
    
}
