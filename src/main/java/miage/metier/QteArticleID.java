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
    
    private int codeCom, codeCli;

    public QteArticleID() {
    }

    public int getCodeCom() {
        return codeCom;
    }

    public void setCodeCom(int codeCom) {
        this.codeCom = codeCom;
    }

    public int getCodeCli() {
        return codeCli;
    }

    public void setCodeCli(int codeCli) {
        this.codeCli = codeCli;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.codeCom;
        hash = 23 * hash + this.codeCli;
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
        final QteArticleID other = (QteArticleID) obj;
        if (this.codeCom != other.codeCom) {
            return false;
        }
        if (this.codeCli != other.codeCli) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
