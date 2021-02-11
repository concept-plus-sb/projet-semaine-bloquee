/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.bd;

import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpSession;
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
                        
                        int qte = a.getDispo().get(m).getQteDispo();
                        
                        if(qte <= 0){
                            indispo.add(a);
                            panier.remove(a);
                        }
                    }
                    return indispo;
                }
    }
}
