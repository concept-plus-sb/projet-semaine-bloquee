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
 * @author mamad
 */
@Embeddable
public class QteArticleID implements Serializable {
    //Propriétes
    private int codeCom, codeA;

    //Constructeurs.
    public QteArticleID() { }
    public QteArticleID(int codeCom, int codeA) {
        this.codeCom = codeCom;
        this.codeA = codeA;
    }

    //Setter et Getter.
    public int getCodeCom() {return codeCom;}
    public void setCodeCom(int codeCom) {this.codeCom = codeCom;}
    public int getCodeA() {return codeA;}
    public void setCodeA(int codeA) {this.codeA = codeA;}

    //HashCode et Equals.
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.codeCom;
        hash = 31 * hash + this.codeA;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null) {return false;}
        if (getClass() != obj.getClass()) {return false;}
        final QteArticleID other = (QteArticleID) obj;
        if (this.codeCom != other.codeCom) {return false;}
        if (this.codeA != other.codeA) {return false;}
        return true;
    }
    
    
}
