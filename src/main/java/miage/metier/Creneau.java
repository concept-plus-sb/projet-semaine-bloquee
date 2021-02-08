/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.metier;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author arsla
 */
@Entity
@Table(name="Creneau")
@SuppressWarnings("PersistenceUnitPresent")
public class Creneau implements Serializable{
    
    //Propriétes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCreneau")
    private int idCreneau;
    private String heureCreneau;
    private int nbPlaceTotal;
    private EnumJourSemaine jourSemaine;
    private int nbPlaceOccupee;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idMagasin")
    private Magasin magasin;

    //Constructeur
    public Creneau() {}    
    public Creneau(int idCreneau, String heureCreneau, int nbPlaceTotal, EnumJourSemaine jourSemaine, int nbPlaceOccupee, Magasin magasin) {
        this.idCreneau = idCreneau;
        this.heureCreneau = heureCreneau;
        this.nbPlaceTotal = nbPlaceTotal;
        this.jourSemaine = jourSemaine;
        this.nbPlaceOccupee = nbPlaceOccupee;
        this.magasin = magasin;
    }

    //Getter et setter
    public Magasin getMagasin() {return magasin;}
    public void setMagasin(Magasin magasin) {this.magasin = magasin;}
    public int getIdCreneau() {return idCreneau;}
    public String getHeureCreneau() {return heureCreneau;}
    public int getNbPlaceTotal() {return nbPlaceTotal;}
    public EnumJourSemaine getJourSemaine() {return jourSemaine;}
    public int getNbPlaceOccupee() {return nbPlaceOccupee;}
    public void setIdCreneau(int idCreneau) {this.idCreneau = idCreneau;}
    public void setHeureCreneau(String heureCreneau) {this.heureCreneau = heureCreneau;}
    public void setNbPlaceTotal(int nbPlaceTotal) {this.nbPlaceTotal = nbPlaceTotal;}
    public void setJourSemaine(EnumJourSemaine jourSemaine) {this.jourSemaine = jourSemaine;}
    public void setNbPlaceOccupee(int nbPlaceOccupee) {this.nbPlaceOccupee = nbPlaceOccupee;}

    //HashCode et Equals
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.idCreneau;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null) {return false;}
        if (getClass() != obj.getClass()) {return false;}
        final Creneau other = (Creneau) obj;
        if (this.idCreneau != other.idCreneau) {return false;}
        return true;
    }
    
}
