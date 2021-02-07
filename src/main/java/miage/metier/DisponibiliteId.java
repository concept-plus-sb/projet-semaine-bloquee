/*
* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.metier;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author arsla
 */
@Embeddable
public class DisponibiliteId implements Serializable {
    private int codeA, idMagasin;
    
    //Constructeur
    public DisponibiliteId(){};
    
    //getters et setters
    public int getCodeA() {return codeA;}
    public int getIdMagasin() {return idMagasin;}
    public void setCodeA(int codeA) {this.codeA = codeA;}
    public void setIdMagasin(int idMagasin) {this.idMagasin = idMagasin;}
    
    //HashCode et Equals
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.codeA;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null) {return false;}
        if (getClass() != obj.getClass()) {return false;}
        final DisponibiliteId other = (DisponibiliteId) obj;
        if (this.codeA != other.codeA) {return false;}
        return true;
    }
    
}
