/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.metier;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author 21606937
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
    private String marque;
    
    //Constructeur

    public Article() {}
    
    public Article(int codeA, String libelleA, float contenance, String uniteM, String uniteL, EnumStockage typeStockage, int nbDose, String origine, String composition, String marque) {
        this.codeA = codeA;
        this.libelleA = libelleA;
        this.contenance = contenance;
        this.uniteM = uniteM;
        this.uniteL = uniteL;
        this.typeStockage = typeStockage;
        this.nbDose = nbDose;
        this.origine = origine;
        this.composition = composition;
        this.marque = marque;
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
    public String getMarque() {return marque;}
    public void setMarque(String marque) {this.marque = marque;}
    
    
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
