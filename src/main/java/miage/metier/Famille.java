package miage.metier;
import java.io.Serializable;
import javax.persistence.*;
import java.util.*;

@Entity
@SuppressWarnings("PersistanceUnitPresent")
/**
 *
 * @author luqil
 */
public class Famille implements Serializable{
     //propriétés
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idF;
    private String libelleF;
   
    
    //constructor
    public Famille() {}
    public Famille(int idF, String libelleF, Rayon rayon) {
        this.idF = idF;
        this.libelleF = libelleF;
        this.rayon = rayon;
    }
    
    //relations
    //ajouter colonne étrangère dans Demande.
    //pas besoin de préciser le type du colonne. il va chercher.
    @ManyToOne(fetch = FetchType.LAZY) //ou @ManyToOne(fetch = FetchType.EAGER) => une seule requete pour charger l'objet et l (this is question8)
    @JoinColumn(name="IdRayon")
    Rayon rayon;
    
    @ManyToMany
    @JoinTable(name="Dependre",
            joinColumns = @JoinColumn(name = "CodeFamille"),
            inverseJoinColumns = @JoinColumn(name = "CodeSouFamille"))
    Set<SousFamille> sousfamilles = new HashSet<>(0);
    
    
    //getter and setter
    public int getIdF() {return idF;}
    public void setIdF(int idF) {this.idF = idF;}
    public String getLibelleF() {return libelleF;}
    public void setLibelleF(String libelleF) {this.libelleF = libelleF;}
    public Rayon getRayon() {return rayon;}
    public void setRayon(Rayon rayon) {this.rayon = rayon;}
    public Set<SousFamille> getSousfamilles() {return sousfamilles;}
    public void setSousfamilles(Set<SousFamille> sousfamilles) {this.sousfamilles = sousfamilles;}

    //equals and hash
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idF;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null) {return false;}
        if (getClass() != obj.getClass()) {return false;}
        final Famille other = (Famille) obj;
        if (this.idF != other.idF) {return false;}
        return true;
    }

    
}
