/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.bd;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import miage.metier.Article;
import miage.metier.Client;
import miage.metier.Commande;
import miage.metier.Creneau;
import miage.metier.EnumEtatCom;
import miage.metier.Magasin;
import miage.metier.QteArticle;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Afaf
 */
public class ConfirmerCommande {
    
    /**
     * On incrémente le nombre de place occuppée du créneau
     * @param idCre 
     */
    public static void ajoutPlaceOccupee(int idCre){
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            
            Transaction t=session.beginTransaction();
            
                Creneau c = session.get(Creneau.class, idCre);
                c.setNbPlaceOccupee(c.getNbPlaceOccupee()+1);
                
                session.save(c);
                t.commit();
        }
    }
    
 
    /**
     * 
     * @param panier
     * @param cli
     * @param idcre 
     */
    public static void creerCommande(HashMap<Article,Integer> panier, Client cli, Creneau idcre){
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()){
            
            Transaction t=session.beginTransaction();
//            HashMap<Article,Integer> panier= new HashMap<Article,Integer>();
//            Client cli = session.get(Client.class, 1);
//            Creneau idcre = session.get(Creneau.class, 1);
//            
//            Article a1 = session.get(Article.class, 1);
//            panier.put(a1,3);
    
            //Je récupère le magasin du client
            Magasin m = cli.getMagasin();
            //Je crée la commande 
            Commande c = new Commande(EnumEtatCom.encours, cli, idcre);
            session.save(c);

            //Je récupère la hashmap de la commande que j'ai crée (qui est vide)
            Map<Article, QteArticle> cmd = c.getQteArticles();
            
            //Je parcours la hashmap du panier pour récupérer l'article et la quantité. 
            for(HashMap.Entry <Article, Integer> map: panier.entrySet()){
                Article a = map.getKey();
                int qte = map.getValue();
                
                // Je récupère la disponbilité de l'article et je la décrémente
                a.getDispo().get(m).decQteDispo(qte);
                session.update(a);
                
                // Je crée la class QteArticle pour une commande
                QteArticle q = new QteArticle(qte,a,c);
               
                //J'alimente la hashmap de la commande avec pour chaque article du panier et sa quantité
                cmd.put(a, q);
            }

            t.commit();
        }
    }
    
    
}
