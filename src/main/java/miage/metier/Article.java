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
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Afaf
 */
@Entity
@SuppressWarnings("PersistenceUnitPresent")
public class Article implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codeA; 
    private String libelleA;
    private float contenance; 
    private String uniteM;
    private String uniteL;
    private EnumStockage typeStockage; 
    private int nbDose; 
    private String origine;
    private String composition; 
    private String marqueP;
    
    //Références et relations.
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    @MapKeyJoinColumn(name = "idMagasin")
    private Map<Magasin, Disponibilite> dispo = new HashMap<>();
    
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    @MapKeyJoinColumn(name = "CodeCom")
    private Map<Commande, QteArticle> qteArticles = new HashMap<>();
    
    @ManyToOne(fetch = FetchType.EAGER) //ou @ManyToOne(fetch = FetchType.EAGER) => une seule requete pour charger l'objet et l (this is question8)
    @JoinColumn(name="IdSousFamille")
    SousFamille sousfamille;
    
    @ManyToOne
    @JoinColumn(name = "IdMarque")
    private MarqueA marqueProprietaire; 
    
    @ManyToMany(mappedBy = "articles")
    private Set<LabelQualite> label = new HashSet(0);
    
    @ManyToOne
    @JoinColumn(name = "prixV")
    private PrixVente prixVente;
    
    @ManyToOne
    @JoinColumn(name = "idN")
    private Nutriscore nutriscore;
    
    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
    private Set<Photo> photos = new HashSet(0);

    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
    private Set<EAN> eans = new HashSet(0);

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    @MapKeyJoinColumn(name = "CodePromo")
    private Map<Promotion, QuantitePromo> qtePromo = new HashMap<>();
    
    
    //Constructeur
    public Article() {}
    public Article(int codeA, String libelleA, float contenance, String uniteM, String uniteL, EnumStockage typeStockage, int nbDose, String origine, String composition, String marqueP, SousFamille sousfamille, MarqueA marqueProprietaire, PrixVente prixVente, Nutriscore nutriscore) {
        this.codeA = codeA;
        this.libelleA = libelleA;
        this.contenance = contenance;
        this.uniteM = uniteM;
        this.uniteL = uniteL;
        this.typeStockage = typeStockage;
        this.nbDose = nbDose;
        this.origine = origine;
        this.composition = composition;
        this.marqueP = marqueP;
        this.sousfamille = sousfamille;
        this.marqueProprietaire = marqueProprietaire;
        this.prixVente = prixVente;
        this.nutriscore = nutriscore;
    }
    
    
    // Getter et Setter
    public int getCodeA() {return codeA;}
    public void setCodeA(int codeA) {this.codeA = codeA;}
    public String getLibelleA() {return libelleA;}
    public void setLibelleA(String libelleA) {this.libelleA = libelleA;}
    public float getContenance() {return contenance;}
    public void setContenance(float contenance) {this.contenance = contenance;}
    public String getUniteM() {return uniteM;}
    public void setUniteM(String uniteM) {this.uniteM = uniteM;}
    public String getUniteL() {return uniteL;}
    public void setUniteL(String uniteL) {this.uniteL = uniteL;}
    public EnumStockage getTypeStockage() {return typeStockage;}
    public void setTypeStockage(EnumStockage typeStockage) {this.typeStockage = typeStockage;}
    public int getNbDose() { return nbDose;}
    public void setNbDose(int nbDose) {this.nbDose = nbDose;}
    public String getOrigine() {return origine;}
    public void setOrigine(String origine) {this.origine = origine;}
    public String getComposition() {return composition;}
    public void setComposition(String composition) {this.composition = composition;}
    public String getMarqueP() {return marqueP;}
    public void setMarqueP(String marqueP) {this.marqueP = marqueP;}
    public MarqueA getMarqueProprietaire() {return marqueProprietaire;}
    public void setMarqueProprietaire(MarqueA marqueProprietaire) {this.marqueProprietaire = marqueProprietaire;}
    public Set<LabelQualite> getLabel() {return label;}
    public void setLabel(Set<LabelQualite> label) {this.label = label;}
    public PrixVente getPrixVente() {return prixVente;}
    public void setPrixVente(PrixVente prixVente) {this.prixVente = prixVente;}
    public Nutriscore getNutriscore() {return nutriscore;}
    public void setNutriscore(Nutriscore nutriscore) {this.nutriscore = nutriscore;}
    public Set<Photo> getPhotos() {return photos;}
    public void setPhotos(Set<Photo> photos) {this.photos = photos;}
    public Set<EAN> getEans() {return eans;}
    public void setEans(Set<EAN> eans) {this.eans = eans;}
    public Map<Promotion, QuantitePromo> getQtePromo() {return qtePromo;}
    public void setQtePromo(Map<Promotion, QuantitePromo> qtePromo) {this.qtePromo = qtePromo;}
    public Map<Commande, QteArticle> getQteArticles() {return qteArticles;}
    public void setQteArticles(Map<Commande, QteArticle> qteArticles) {this.qteArticles = qteArticles;}
    public SousFamille getSousfamille() {return sousfamille;}
    public void setSousfamille(SousFamille sousfamille) {this.sousfamille = sousfamille;}
    
    
    //HashCode et Equals
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.codeA;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null) {return false;}
        if (getClass() != obj.getClass()) {return false;}
        final Article other = (Article) obj;
        return true;
    }
   
    
    
}
