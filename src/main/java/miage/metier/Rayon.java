package miage.metier;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@SuppressWarnings("PersistanceUnitPresent")
@Entity
@Table(name="Rayon")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Rayon")
/**
 *
 * @author luqil
 */
public class Rayon implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idR;
    private String libelleR;
    
    //Références
    @OneToMany(mappedBy = "rayon", fetch = FetchType.EAGER)
    Set<Famille> familles = new HashSet<>(0);
    
    //constructor
    public Rayon() {}
    public Rayon(String libelleR) {
        this.libelleR = libelleR;
    }
    
    //getter and setter
    public int getIdR() {return idR;}
    public void setIdR(int idR) {this.idR = idR;}
    public String getLibelleR() {return libelleR;}
    public void setLibelleR(String libelleR) {this.libelleR = libelleR;}
    public Set<Famille> getFamilles() {return familles;}
    public void setFamilles(Set<Famille> familles) {this.familles = familles;}

    //equals and hash
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.idR;
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null)return false;
        if (getClass() != obj.getClass())return false;
        final Rayon other = (Rayon) obj;
        if (this.idR != other.idR)return false;
        return true;
    }
    
}
