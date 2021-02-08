package miage.bd;


import java.util.List;
import javax.persistence.Query;
import miage.bd.HibernateUtil;
import miage.metier.Disponibilite;
import miage.metier.Magasin;
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
public class Articles {

    public static List<Disponibilite> listeArticlesByMagasin(int id){
        /*----- Ouverture de la session -----*/
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
            
            Magasin m = session.get(Magasin.class, id);
            
            Query q = session.createQuery("from Disponibilite d where d.magasin = \""+m.getIdMagasin()+"\" and d.qte>0");
            
            List<Disponibilite> ldisponibilite = (List<Disponibilite>)q.getResultList();
            
//            for(Disponibilite d : ldisponibilite){
//                System.out.println(d.getArticle().getLibelleA());
//            }

            return ldisponibilite;
        }
    }

}
