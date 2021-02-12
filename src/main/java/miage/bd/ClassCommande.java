/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.bd;

import java.text.ParseException;
import static miage.bd.TestHibernate.df;
import miage.metier.Article;
import miage.metier.Commande;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ismail
 */
public class ClassCommande {
    
    
    //Chargement des infos d'une demande
    public static Commande getCommande(int id){
                Commande c =new Commande();
        /*----- Ouverture de la session -----*/
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
			{  
                            session.beginTransaction();
                            c = session.get(Commande.class,id);
                            return c;
                        }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }  
                return null;
    }
}
