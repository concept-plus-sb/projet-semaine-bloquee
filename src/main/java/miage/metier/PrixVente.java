/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.metier;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author 21606937
 */
@Entity
@SuppressWarnings("PersistenceUnitPresent")
public class PrixVente implements Serializable {
    
    //Propriétes. 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private float prix;
    
    //Références et relations. 
    @OneToMany(mappedBy = "prixVente", fetch = FetchType.LAZY)
    private Set<Article> articles = new HashSet(0);
    
    //Constructeurs.
    public PrixVente(){}
    public PrixVente(float prix) {
        this.prix = prix;
    }
    
    //Getter et Setter. 
    public float getPrix() {return prix;}
    public void setPrix(float prix) {this.prix = prix;}
    
    //HashCode et Equals.

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Float.floatToIntBits(this.prix);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null) {return false;}
        if (getClass() != obj.getClass()) {return false;}
        final PrixVente other = (PrixVente) obj;
        if (Float.floatToIntBits(this.prix) != Float.floatToIntBits(other.prix)) {return false;}
        return true;
    }
    
    
  
    
}
