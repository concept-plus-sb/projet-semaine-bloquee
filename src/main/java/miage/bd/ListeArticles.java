package miage.bd;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import miage.bd.HibernateUtil;
import miage.metier.Article;
import miage.metier.Disponibilite;
import miage.metier.Magasin;
import miage.metier.Photo;
import org.hibernate.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mamad
 */
public class ListeArticles {

    public static List<Article> listeArticlesByMagasin(int id){
        
        ArrayList<Article> articles = new ArrayList<>();
        
        /*----- Ouverture de la session -----*/
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            
            Magasin m = session.get(Magasin.class, id);
            
            Query q = session.createQuery("from Disponibilite d where d.magasin = \""+m.getIdMagasin()+"\" and d.qte>0");
            
            List<Disponibilite> ldisponibilite = (List<Disponibilite>)q.getResultList();
            
            for(Disponibilite d : ldisponibilite){
                articles.add(d.getArticle());
            }

            return articles;
        }
    }

        public static void PhotobyArticle(int codeA){
        /*----- Ouverture de la session -----*/
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            
            Article a = session.get(Article.class, codeA);
            
            Photo p = session.get(Photo.class, a.getCodeA());
            
//            for(Disponibilite d : ldisponibilite){
//                System.out.println(d.getArticle().getLibelleA());
//            }

        }
        }
}