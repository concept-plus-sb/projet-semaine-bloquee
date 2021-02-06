/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.metier;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author estel
 */
@Entity
public class Photo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPhoto;
    private String lien;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="codeA")
    private Article article;
    
    //@OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
    //private Set<Photo> photos = new HashSet(0);
    
    
}
