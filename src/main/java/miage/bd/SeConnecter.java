/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.bd;

import java.util.List;
import javax.persistence.Query;
import miage.metier.Client;
import org.hibernate.Session;

/**
 *
 * @author estel
 */
public class SeConnecter {
    
    
    public static boolean verifierConnexion(String p_s_email, String p_s_mdp) 
            throws Exception{
        boolean p_b_result=false;
        try (Session session = HibernateUtil.getSessionFactory().
                getCurrentSession()){
            
            session.beginTransaction();
            
            
            Query q = session.createQuery("from Client c where c.email=\""+
                    (p_s_email)+"\" and c.motDePasse=\""+p_s_mdp+"\"");
            List<Client> l = (List<Client>)q.getResultList();
           
            
            if (!l.isEmpty()){
               p_b_result=true;
            }
        } catch (Exception e){
            throw new Exception ("verifierConnexion()"+e.getMessage());
        }
        return p_b_result;
    }
    
    
    public static Client recupClient(String p_s_email, String p_s_mdp) 
            throws Exception {
        Client p_c_client=null;
        try (Session session = HibernateUtil.getSessionFactory().
                getCurrentSession()){

            session.beginTransaction();
            
            Query q = session.createQuery("from Client c where c.email='"+
                    (p_s_email)+"' and c.motDePasse='"+p_s_mdp+"'");
            List<Client> l = (List<Client>)q.getResultList();
            p_c_client = l.get(0);
            
        } catch (Exception e){
            throw new Exception ("recupClient()"+e.getMessage());
        }
        return p_c_client;
    }
    
    


}
