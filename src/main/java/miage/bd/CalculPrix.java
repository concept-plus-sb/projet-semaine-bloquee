/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.bd;

import java.util.HashMap;
import miage.metier.Article;

/**
 *
 * @author estel
 */
public class CalculPrix {
    public float calculTotalavecPromo(HashMap<Article,Integer> panier){
        float prixTotal = 0;
        int i;
        for(HashMap.Entry <Article,Integer> map: panier.entrySet()){
            if(map.getKey().getPromotion()==null){
                prixTotal = prixTotal + map.getKey().getPrixVente()*map.getValue();
            } else {
                for (i=1; i<=map.getValue()+1; i++){
                    if(map.getValue()%map.getKey().getPromotion().getNbArticlePromo()==0){
                        prixTotal = prixTotal + (map.getKey().getPrixVente()*(1-map.getKey().getPromotion().getPourcentagePromo()/100));
                    } else {
                        prixTotal = prixTotal + map.getKey().getPrixVente();
                    }
                }
            }    
        }
        return prixTotal;
    }
}
