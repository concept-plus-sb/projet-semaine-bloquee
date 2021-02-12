/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.bd;

import miage.metier.Article;
import miage.metier.Magasin;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author estel
 */
public class AjouterArticle {
    
    /**
     * 
     * @param id
     * @return l'article possédant l'id passé en paramètre
     */
    public static Article recupArt(int id){
        Article a = null;
    
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            
            Transaction t=session.beginTransaction();
            
            a = session.get(Article.class, id);
            
        }
        return a;
    
    }

    
    public static boolean Disponible(Magasin m, Article a){   
        if(a.getDispo().get(m).getQteDispo()>0){
            return true;
        }else {
            return false;
        }   
    }
}
