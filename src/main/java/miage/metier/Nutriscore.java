/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.metier;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 21606937
 */
@Entity
@SuppressWarnings("PersistenceUnitPresent")
public class Nutriscore implements Serializable {
    
    //Propriétes. 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codeN; 
    private String description;
    
    //Constructeurs. 
    public Nutriscore(){}
    public Nutriscore(int codeN, String description) {
        this.codeN = codeN;
        this.description = description;
    }
    
    //Getter et Setter.
    public int getCodeN() {return codeN;}
    public void setCodeN(int codeN) {this.codeN = codeN;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    
    //HashCode et Equals. 

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.codeN;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null) {return false;}
        if (getClass() != obj.getClass()) {return false;}
        final Nutriscore other = (Nutriscore) obj;
        if (this.codeN != other.codeN) {return false;}
        return true;
    }
   
    
    
}
