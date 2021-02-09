/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.bd;

import java.text.ParseException;
import static miage.bd.TestHibernate.df;
import miage.metier.Article;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Ismail
 */
public class ClassArticle {
    
    
    //Chargement des infos d'une demande
    public static Article getArticle(int id){
                System.out.println(id);
                Article a =new Article();
        /*----- Ouverture de la session -----*/
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
			{  
                            session.beginTransaction();
                            a = session.get(Article.class,id);
                            return a;
                        }
                catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }  
                return null;
    }
}
