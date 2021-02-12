/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.bd;

import java.util.List;
import javax.persistence.Query;
import miage.metier.Client;
import miage.metier.Preparateur;
import org.hibernate.Session;

/**
 *
 * @author estel
 */
public class SeConnecter {
    
    /**
     * 
     * @param p_s_email email 
     * @param p_s_mdp mot de passe
     * @return true si le mdp et l'email sont valides false si le mdp et l'email sont invalides
     * @throws Exception 
     */
    public static boolean verifierConnexion(String p_s_email, String p_s_mdp) 
            throws Exception{
        boolean p_b_result=false;
        try (Session session = HibernateUtil.getSessionFactory().
                getCurrentSession()){
            
            //Ouvrir session.
            session.beginTransaction();
            
            //Interroger la bd. 
            Query q = session.createQuery("from Client c where c.email=\""+
                    (p_s_email)+"\" and c.motDePasse=\""+p_s_mdp+"\"");
            List<Client> l = (List<Client>)q.getResultList();
           
            //Si ce qui est récupéré n'est pas vide --> alors le compte existe
            if (!l.isEmpty()){
               p_b_result=true;
            }
        } catch (Exception e){
            throw new Exception ("verifierConnexion()"+e.getMessage());
        }
        return p_b_result;
    }
    public static boolean verifierConnexionPrepa(String p_s_email, String p_s_mdp) 
            throws Exception{
        boolean p_b_result=false;
        try (Session session = HibernateUtil.getSessionFactory().
                getCurrentSession()){
            
            //Ouvrir session.
            session.beginTransaction();
            
            //Interroger la bd. 
            Query q = session.createQuery("from Preparateur p where p.emailPrepa=\""+
                    (p_s_email)+"\" and p.motDePassePrepa=\""+p_s_mdp+"\"");
            List<Preparateur> l = (List<Preparateur>)q.getResultList();
           
            //Si ce qui est récupéré n'est pas vide --> alors le compte existe
            if (!l.isEmpty()){
               p_b_result=true;
            }
        } catch (Exception e){
            throw new Exception ("verifierConnexion()"+e.getMessage());
        }
        return p_b_result;
    }
    
    /**
     * 
     * @param p_s_email
     * @param p_s_mdp
     * @return le client qui possède l'email et le mdp passés en paramètres
     * @throws Exception 
     */
    public static Client recupClient(String p_s_email, String p_s_mdp) 
            throws Exception {
        Client p_c_client=null;
        try (Session session = HibernateUtil.getSessionFactory().
                getCurrentSession()){

            //Ouverture de la session.
            session.beginTransaction();
            
            //Interrogation de la BD
            Query q = session.createQuery("from Client c where c.email='"+
                    (p_s_email)+"' and c.motDePasse='"+p_s_mdp+"'");
            List<Client> l = (List<Client>)q.getResultList();
            p_c_client = l.get(0);
            
        } catch (Exception e){
            throw new Exception ("recupClient()"+e.getMessage());
        }
        return p_c_client;
    }
    public static Preparateur recupPreparateur(String p_s_email, String p_s_mdp) 
            throws Exception {
        Preparateur p_o_preparateur=null;
        try (Session session = HibernateUtil.getSessionFactory().
                getCurrentSession()){

            //Ouverture de la session.
            session.beginTransaction();
            
            //Interrogation de la BD
            Query q = session.createQuery("from Preparateur p where p.emailPrepa='"+
                    (p_s_email)+"' and p.motDePassePrepa='"+p_s_mdp+"'");
            List<Preparateur> l = (List<Preparateur>)q.getResultList();
            p_o_preparateur = l.get(0);
            
        } catch (Exception e){
            throw new Exception ("recupClient()"+e.getMessage());
        }
        return p_o_preparateur;
    }
}
