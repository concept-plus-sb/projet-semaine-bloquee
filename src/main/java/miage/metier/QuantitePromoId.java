/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.metier;

import java.io.Serializable;

/**
 *
 * @author Ismail
 */
public class QuantitePromoId implements Serializable{
    //Propriétes
    private int codePromo,codeA;

    //Getters et setters
    public int getCodePromo() {return codePromo;}
    public void setCodePromo(int codePromo) {this.codePromo = codePromo;}
    public int getCodeA() {return codeA;}
    public void setCodeA(int codeA) {this.codeA = codeA;}
    
    //Constructeur
    public QuantitePromoId(){}
    public QuantitePromoId(int codePromo, int codeA) {
        this.codePromo = codePromo;
        this.codeA = codeA;
    }
    
    //HashCode et Map
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + this.codePromo;
        hash = 73 * hash + this.codeA;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null) {return false;}
        if (getClass() != obj.getClass()) {return false;}
        final QuantitePromoId other = (QuantitePromoId) obj;
        if (this.codePromo != other.codePromo) {return false;}
        if (this.codeA != other.codeA) {return false;}
        return true;
    }
    
    
    
}
