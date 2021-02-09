/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.bd;

import java.util.HashMap;
import javax.servlet.http.HttpSession;
import miage.metier.Article;
import miage.metier.Client;
import miage.metier.Creneau;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author estel
 */
public class ConfirmerCommande {
    public static void ajoutPlaceOccupee(int idCre){
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            
            Transaction t=session.beginTransaction();
            
                Creneau c = session.get(Creneau.class, idCre);
                c.setNbPlaceOccupee(c.getNbPlaceOccupee()+1);
                
                session.save(c);
                t.commit();
                
                
        }
    }
    
    public static void creerCommande(HashMap<Article,Integer> panier, Client c){
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            
            Transaction t=session.beginTransaction();
            
              
                //c.setNbPlaceOccupee(c.getNbPlaceOccupee()+1);
                
                session.save(c);
                
                 
                
                t.commit();
                
                
        }
    }
}
