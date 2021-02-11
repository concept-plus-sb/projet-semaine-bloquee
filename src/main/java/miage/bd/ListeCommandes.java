package miage.bd;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import miage.bd.HibernateUtil;
import miage.dto.ArticleDto;
import miage.dto.ArticlePromoDto;
import miage.metier.Article;
import miage.metier.Commande;
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
 * @author Ismail
 */
public class ListeCommandes {

    public static List<Commande> listeCommandesByMagasin(int id){
        
        List<Integer> liste=new ArrayList<Integer>();
        /*----- Ouverture de la session -----*/
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();
           
            Query q=session.createQuery("SELECT c.CodeCom from Commande c, Creneau r where r.idCreneau=c.creneau and r.magasin= \""+id+"\" ORDER BY r.DateHeureCreneau");
  
            liste=(List<Integer>)q.getResultList();
            System.out.println("Voila voila");
            for(Integer c:liste){
            System.out.println(c);
        }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        List<Commande> commandes=CommandesByMagasin(liste) ;
        return commandes;
    }
    
      public static List<Commande> CommandesByMagasin(List<Integer> liste){
        
         List<Commande> commandes= new ArrayList<Commande>();
         
        /*----- Ouverture de la session -----*/
        try ( Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            session.beginTransaction();

            for(Integer i:liste){
                commandes.add(session.get(Commande.class, i));
        }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return commandes;
    }
    
  


}
