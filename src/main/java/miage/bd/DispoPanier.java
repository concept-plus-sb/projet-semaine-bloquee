/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.bd;

import java.util.ArrayList;
import java.util.HashMap;
import miage.metier.Article;
import miage.metier.Magasin;
import org.hibernate.Session;

/**
 *
 * @author Afaf
 */
public class DispoPanier {
    
    public static ArrayList<Article> afficherIndispo(int idMagasin, HashMap<Article,Integer> panier){
        
         ArrayList<Article> indispo = new ArrayList<>();
         try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
                {
                    session.beginTransaction();
                    
                    Magasin m = session.get(Magasin.class, idMagasin);
                   
                    for(HashMap.Entry <Article, Integer> map: panier.entrySet()){
                        Article a = map.getKey();
                        int qteCom = map.getValue();
                        int qte = a.getDispo().get(m).getQteDispo();
                        
                        //Si la quantité commandé est inférieur à la quantité en stock
                        if(qteCom > qte){
                            indispo.add(a);
                        }
                    }
                    for(Article l: indispo){
                        panier.remove(l);
                    }
                    return indispo;
                }
    }
}
