/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.bd;

import miage.metier.Article;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author estel
 */
public class AjouterArticle {
    public static Article recupArt(int id){
        Article a = null;
    
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            
            Transaction t=session.beginTransaction();
            
            a = session.get(Article.class, id);
            
    }
        return a;
    
}
}
