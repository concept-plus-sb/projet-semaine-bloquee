/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.bd;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import miage.metier.Creneau;
import miage.metier.Magasin;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Afaf
 */
public class AfficherCreneau {
private static Connection cx = null;

/**
 * Les créneaux disponibles
 * @param id
 * @return
 */

    public static List<Creneau> afficherCreneau(int id){
        
        /*----- Ouverture de la session -----*/
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
			{
                            session.beginTransaction();
                            DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                            Date date = new Date();
                            Magasin m = session.get(Magasin.class, id);
                            System.out.println(m.getLibelleMagasin());
                            
                            Query q= session.createQuery("from Creneau c where c.magasin =\""+m.getIdMagasin()+"\" and c.nbPlaceOccupee<c.nbPlaceTotal");
                            
                            List<Creneau> l = (List<Creneau>)q.getResultList();
                            List<Creneau> list = new ArrayList<Creneau>();
                            
                            for(Creneau c: l){
                                if(c.getDateHeureCreneau().compareTo(date) >0){
                                    list.add(c);
                                }
                            }
                            
                            return list; 
                        }
        
    }
    
    /**
     * Les créneaux indisponibles
     * @param id
     * @return List 
     */
        public static List<Creneau> afficherCreneauINDISPO(int id){
        
        /*----- Ouverture de la session -----*/
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
			{
                            session.beginTransaction();
                            
                            Magasin m = session.get(Magasin.class, id);
                            DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                            Date date = new Date();       
                            System.out.println(format.format(date));
                            Query q= session.createQuery("from Creneau c where c.magasin =\""+m.getIdMagasin()+"\" and c.nbPlaceOccupee=c.nbPlaceTotal");
                            
                            // Je récupère tout les créneaux
                            List<Creneau> l = (List<Creneau>)q.getResultList();
                            
                            //Je crée une liste qui va stocker les créneaux supérieur à la date courante. 
                            List<Creneau> list = new ArrayList<Creneau>();
                            for(Creneau c: l){
                                if(c.getDateHeureCreneau().compareTo(date) >0){
                                    list.add(c);
                                }
                            }
                            
                            return list; 
                        }
    }
}
