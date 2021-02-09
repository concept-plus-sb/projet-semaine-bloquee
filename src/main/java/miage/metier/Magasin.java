/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.metier;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author arsla
 */
@Entity
@Table(name = "magasin")
@SuppressWarnings("PersistenceUnitPresent")
public class Magasin implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idMagasin")
    private int idMagasin;
    private String libelleMagasin;
    
    @OneToMany(mappedBy = "magasin", cascade = CascadeType.ALL)
    @MapKeyJoinColumn(name = "codeA")
    private Map<Article, Disponibilite> dispo = new HashMap<>();
    
    @OneToMany(mappedBy = "magasin", cascade = CascadeType.ALL)
    Set<Creneau> creneaux =  new HashSet<>();
    
    @OneToMany(mappedBy = "magasin", cascade = CascadeType.ALL)
    Set<Client> clients =  new HashSet<>();
    
    //Constructeur
    public Magasin() {}
    public Magasin(int idMagasin, String libelleMagasin) {
        this.idMagasin = idMagasin;
        this.libelleMagasin = libelleMagasin;
    }
    


    //Getters et setters
        public Map<Article, Disponibilite> getDispo() {return dispo;}

    public void setDispo(Map<Article, Disponibilite> dispo) {
        this.dispo = dispo;
    }

    public Set<Client> getClients() {
        return clients;
    }
    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Set<Creneau> getCreneaux() {
        return creneaux;
    }
    public void setCreneaux(Set<Creneau> creneaux) {this.creneaux = creneaux;}
    public int getIdMagasin() {return idMagasin;}
    public String getLibelleMagasin() {return libelleMagasin;}
    public void setIdMagasin(int idMagasin) {this.idMagasin = idMagasin;}
    public void setLibelleMagasin(String libelleMagasin) {this.libelleMagasin = libelleMagasin;}
    
    //HashCode et Equals
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.idMagasin;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null) {return false;}
        if (getClass() != obj.getClass()) {return false;}
        final Magasin other = (Magasin) obj;
        if (this.idMagasin != other.idMagasin) {return false;}
        return true;
    }
    
    
}
