package miage.metier;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@SuppressWarnings("PersistanceUnitPresent")
/**
 *
 * @author luqil
 */
public class SousFamille implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSF;
    private String libelleSF;
    
    @ManyToMany(mappedBy = "sousfamilles")
    Set<Famille> familles = new HashSet<>(0);
    
  //  @OneToMany(mappedBy = "sousfamille", cascade = CascadeType.ALL)
  //  Set<Article> articles = new HashSet<>(0);
    
    //constructor
    public SousFamille() {}
    public SousFamille(String libelleSF) {
        this.libelleSF = libelleSF;
    }

    //getter and setter
    public int getIdSF() {return idSF;}
    public void setIdSF(int idSF) {this.idSF = idSF;}
    public String getLibelleSF() {return libelleSF;}
    public void setLibelleSF(String libelleSF) {this.libelleSF = libelleSF;}
    public Set<Famille> getFamilles() {return familles;}
    public void setFamilles(Set<Famille> familles) {this.familles = familles;}

    //equals and hash
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.idSF;
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null)return false;
        if (getClass() != obj.getClass()) return false;
        final SousFamille other = (SousFamille) obj;
        if (this.idSF != other.idSF)return false;
        return true;
    }

    
}
