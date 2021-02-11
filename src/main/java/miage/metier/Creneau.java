/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.metier;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
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
import javax.persistence.Temporal;

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
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date DateHeureCreneau;
    private int nbPlaceTotal;
    private int nbPlaceOccupee;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idMagasin")
    private Magasin magasin;
    
    @OneToMany(mappedBy = "creneau", fetch = FetchType.EAGER)
    private Set<Commande> commandes = new HashSet(0);


    //Constructeur
    public Creneau() {}    

    public Creneau(Date DateHeureCreneau, int nbPlaceTotal, int nbPlaceOccupee, Magasin magasin) {
        this.DateHeureCreneau = DateHeureCreneau;
        this.nbPlaceTotal = nbPlaceTotal;
        this.nbPlaceOccupee = nbPlaceOccupee;
        this.magasin = magasin;
    }
    

    //Getter et setter
    public Magasin getMagasin() {return magasin;}
    public void setMagasin(Magasin magasin) {this.magasin = magasin;}
    public int getIdCreneau() {return idCreneau;}
    public int getNbPlaceTotal() {return nbPlaceTotal;}
    public int getNbPlaceOccupee() {return nbPlaceOccupee;}
    public void setIdCreneau(int idCreneau) {this.idCreneau = idCreneau;}
    public void setNbPlaceTotal(int nbPlaceTotal) {this.nbPlaceTotal = nbPlaceTotal;}
    public void setNbPlaceOccupee(int nbPlaceOccupee) {this.nbPlaceOccupee = nbPlaceOccupee;}
    public Set<Commande> getCommandes() {return commandes;}
    public void setCommandes(Set<Commande> commandes) {this.commandes = commandes;}
    public Date getDateHeureCreneau() {return DateHeureCreneau;}
    public void setDateHeureCreneau(Date DateHeureCreneau) {this.DateHeureCreneau = DateHeureCreneau;}
    

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
