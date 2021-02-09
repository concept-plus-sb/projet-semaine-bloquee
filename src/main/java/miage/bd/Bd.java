/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.bd;

import java.sql.Connection;
import java.util.List;
import miage.metier.Creneau;
import miage.metier.Magasin;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Afaf
 */
public class Bd {
private static Connection cx = null;

    public static List<Creneau> afficherCreneau(int id){
        
        /*----- Ouverture de la session -----*/
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
			{
                            session.beginTransaction();
                            
                            Magasin m = session.get(Magasin.class, id);
                            System.out.println(m.getLibelleMagasin());
                            
                            Query q= session.createQuery("from Creneau c where c.magasin =\""+m.getIdMagasin()+"\" and c.nbPlaceOccupee<c.nbPlaceTotal");
                            
                            List<Creneau> l = (List<Creneau>)q.getResultList();
//                            System.out.println(l.size());
//                            for(Creneau c: l){
//                                System.out.println(c.getHeureCreneau()+" le "+c.getJourSemaine());
//                            }
                            
                            return l;
                            
                        }
        
      
    }
}
