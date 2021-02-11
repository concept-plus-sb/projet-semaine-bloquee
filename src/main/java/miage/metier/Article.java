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
    private float prixVente;
    private long ean;
    
    //Références et relations.
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @MapKeyJoinColumn(name = "idMagasin")
    private Map<Magasin, Disponibilite> dispo = new HashMap<>();
    
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    @MapKeyJoinColumn(name = "CodeCom")
    private Map<Commande, QteArticle> qteArticles = new HashMap<>();
    
    @ManyToOne(fetch = FetchType.EAGER) //ou @ManyToOne(fetch = FetchType.EAGER) => une seule requete pour charger l'objet et l (this is question8)
    @JoinColumn(name="IdSousFamille")
    private SousFamille sousfamille;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "IdMarque")
    private MarqueA marqueA;
    
    @ManyToMany(mappedBy = "articles",fetch = FetchType.EAGER)
    private Set<LabelQualite> label = new HashSet(0);
    
    @ManyToOne
    @JoinColumn(name = "idN")
    private Nutriscore nutriscore;
    
    @OneToMany(mappedBy = "article", fetch = FetchType.EAGER)
    private Set<Photo> photos = new HashSet(0);
    
    @ManyToOne
    @JoinColumn(name = "codePromo")
    private Promotion promotion;
    
    //Constructeur
    public Article() {}

    public Article(String libelleA, float contenance, String uniteM, String uniteL, EnumStockage typeStockage, int nbDose, String origine, String composition, String marqueP, float prixVente, long ean, SousFamille sousfamille, MarqueA marqueA, Nutriscore nutriscore, Promotion promotion) {
        this.libelleA = libelleA;
        this.contenance = contenance;
        this.uniteM = uniteM;
        this.uniteL = uniteL;
        this.typeStockage = typeStockage;
        this.nbDose = nbDose;
        this.origine = origine;
        this.composition = composition;
        this.marqueP = marqueP;
        this.prixVente = prixVente;
        this.ean = ean;
        this.sousfamille = sousfamille;
        this.marqueA = marqueA;
        this.nutriscore = nutriscore;
        this.promotion = promotion;
    }
    
    
    
        

    // Getter et Setter
    public Map<Magasin, Disponibilite> getDispo() {return dispo;}
    public void setDispo(Map<Magasin, Disponibilite> dispo) {this.dispo = dispo;}
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
    public MarqueA getMarqueProprietaire() {return marqueA;}
    public void setMarqueProprietaire(MarqueA marqueProprietaire) {this.marqueA = marqueProprietaire;}
    public Set<LabelQualite> getLabel() {return label;}
    public void setLabel(Set<LabelQualite> label) {this.label = label;}
    public float getPrixVente() {return prixVente;}
    public void setPrixVente(float prixVente) {this.prixVente = prixVente;}
    public Nutriscore getNutriscore() {return nutriscore;}
    public void setNutriscore(Nutriscore nutriscore) {this.nutriscore = nutriscore;}
    public Set<Photo> getPhotos() {return photos;}
    public void setPhotos(Set<Photo> photos) {this.photos = photos;}
    public Map<Commande, QteArticle> getQteArticles() {return qteArticles;}
    public void setQteArticles(Map<Commande, QteArticle> qteArticles) {this.qteArticles = qteArticles;}
    public SousFamille getSousfamille() {return sousfamille;}
    public void setSousfamille(SousFamille sousfamille) {this.sousfamille = sousfamille;}
    public Promotion getPromotion() {return promotion;}
    public void setPromotion(Promotion promotion) {this.promotion = promotion;}
    public long getEan() {return ean;}
    public void setEan(long ean) {this.ean = ean;}
    public MarqueA getMarqueA() {return marqueA;}
    public void setMarqueA(MarqueA marqueA) {this.marqueA = marqueA;}
    
    
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
