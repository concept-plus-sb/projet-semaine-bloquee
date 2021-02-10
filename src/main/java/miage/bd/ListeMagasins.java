/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.bd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import miage.dto.ArticleDto;
import miage.metier.Article;
import miage.metier.Disponibilite;
import miage.metier.Magasin;
import miage.metier.Photo;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Ismail
 */
public class ListeMagasins {
        public static List<Magasin> listeMagasins(){
                try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
                    System.out.println("test 3");
                 session.beginTransaction();
                 Query q=session.createQuery("from Magasin m", Magasin.class);
                 System.out.println("test 4");
                 List<Magasin> magasins=q.getResultList();
                                     System.out.println("test 5");

                 return magasins;
        }
        }
    
}
