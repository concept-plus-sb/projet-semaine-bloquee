/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.metier;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author estel
 */
@Entity
@SuppressWarnings("PersistenceUnitPresent")
public class Preparateur implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int codePrepa;
    private String emailPrepa;
    private String motDePassePrepa;
    
    @ManyToOne(fetch = FetchType.EAGER) 
    @JoinColumn(name="idMagasin")
    Magasin magasin;
    
    //Constructeurs. 
    
    public Preparateur() {}
    public Preparateur(String emailPrepa, String motDePassePrepa, Magasin magasin) {
        this.emailPrepa = emailPrepa;
        this.motDePassePrepa = motDePassePrepa;
        this.magasin = magasin;
    }
    
    //Getters & Setters. 
    public int getCodePrepa() {return codePrepa;}
    public void setCodePrepa(int codePrepa) {this.codePrepa = codePrepa;}
    public String getEmailPrepa() {return emailPrepa;}
    public void setEmailPrepa(String emailPrepa) {this.emailPrepa = emailPrepa;}
    public String getMotDePassePrepa() {return motDePassePrepa;}
    public void setMotDePassePrepa(String motDePassePrepa) {this.motDePassePrepa = motDePassePrepa;}
    public Magasin getMagasin() {return magasin;}
    public void setMagasin(Magasin magasin) {this.magasin = magasin;}
    
    //Equals & HashCode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.codePrepa;
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
        final Preparateur other = (Preparateur) obj;
        if (this.codePrepa != other.codePrepa) {
            return false;
        }
        return true;
    }
    
    
    
}
