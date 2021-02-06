/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.metier;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import org.hibernate.annotations.ManyToAny;

/**
 *
 * @author estel
 */
@Entity
public class EAN {
    @Id
    private long EAN;
    private String Description;
    
    @ManyToMany
    @JoinTable(name = "AvoirDate",
            joinColumns = @JoinColumn(name="EAN"), 
            inverseJoinColumns = @JoinColumn(name = "dateDebut"))
    private Set<Calendrier> calendriers = new HashSet(0);
    
    
    //Getters & Setters

    public long getEAN() {
        return EAN;
    }

    public void setEAN(long EAN) {
        this.EAN = EAN;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Set<Calendrier> getCalendriers() {
        return calendriers;
    }

    public void setCalendriers(Set<Calendrier> calendriers) {
        this.calendriers = calendriers;
    }
    
    //Constructeurs

    public EAN() {
    }

    public EAN(long EAN, String Description) {
        this.EAN = EAN;
        this.Description = Description;
    }
    
    //hashCode & equals 

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (this.EAN ^ (this.EAN >>> 32));
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
        final EAN other = (EAN) obj;
        if (this.EAN != other.EAN) {
            return false;
        }
        return true;
    }
    
    
    
}
