/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.bd;

import java.sql.Connection;
import java.util.List;
import javax.persistence.Query;
import miage.metier.Creneau;
import miage.metier.Magasin;
import org.hibernate.Session;

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

    

// public static ArrayList<Creneau> afficherCreneau(int id) throws ClassNotFoundException, SQLException
//        {
//            
//        // Espace de requête  à ouvrir
//            PreparedStatement st = cx.prepareStatement("SELECT * FROM Creneau WHERE idMagasin = ? AND NbPlaceOccupee<NbPlaceTotal");
//
//            // Exécution
//            ResultSet rs = st.executeQuery();
//
//            // On récupère les données.
//            ArrayList<Creneau> lesCreneaux = new ArrayList<>();
//
//            while (rs.next()) // Tant que c'est pas null 
//                    lesCreneaux.add(new Creneau(rs.getInt("idCreneau"), rs.getInt("HeureCreneau"), rs.getInt("NbPlaceTotal"),
//                                    EnumJourSemaine.valueOf((rs.getString("JourSemaine"))), rs.getInt("nbPlaceOccuppee"), (Magasin)rs.getObject("Magasin")));
//            
//        return lesCreneaux;
//        }     
////    
    
    public static void main (String[] args)
        {
        for(Creneau c : Bd.afficherCreneau(1))
            System.out.println("--> " + c.getHeureCreneau()+" le "+c.getJourSemaine());
        }
}
