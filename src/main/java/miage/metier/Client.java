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
 * @author mamad
 */
@Entity
@Table(name = "client")
@SuppressWarnings("PersistenceUnitPresent")
public class Client implements Serializable{
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="codecli")
    private int codeCli;
    private String email, motDePasse;
    
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    Set<Commande> commandes =  new HashSet<>();
    
    @ManyToOne(fetch = FetchType.EAGER) 
    @JoinColumn(name="idMagasin")
    Magasin magasin;

    //Constructeurs.
    public Client() {}
    public Client(String email, String motDePasse, Magasin magasin) {
        this.email = email;
        this.motDePasse = motDePasse;
        this.magasin = magasin;
    }
    
    //Setter et Getter.
    public Magasin getMagasin() {return magasin;}
    public void setMagasin(Magasin magasin) {this.magasin = magasin;}
    public Set<Commande> getCommandes() {return commandes;}
    public void setCommandes(Set<Commande> commandes) {this.commandes = commandes;}
    public int getCodeCli() {return codeCli;}
    public void setCodeCli(int codeCli) {this.codeCli = codeCli;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getMotDePasse() {return motDePasse;}
    public void setMotDePasse(String motDePasse) {this.motDePasse = motDePasse;}

    
    

    //HashCode et Equals.
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.codeCli;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null) {return false;}
        if (getClass() != obj.getClass()) {return false;}
        final Client other = (Client) obj;
        if (this.codeCli != other.codeCli) {return false;}
        return true;
    }
    
}
