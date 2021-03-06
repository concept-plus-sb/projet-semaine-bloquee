package miage.bd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import miage.dto.ArticleDto;
import miage.dto.ArticlePromoDto;
import miage.metier.Article;
import miage.metier.Client;
import miage.metier.Commande;
import miage.metier.Photo;
import miage.metier.QteArticle;
import miage.metier.SousFamille;
import org.hibernate.Session;

/**
 * Hibernate.
 */
public class TestHibernate
{
    public static SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//    public static void enregistrerSousFamille(){
//        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
//            {
//            Transaction t = session.beginTransaction();
//            session.save(new SousFamille("ssf test 01"));
//            t.commit();
//            }
//    }

    
   /* public static ArrayList<QteArticle> showPanierArticles(HashMap<Article,Integer> panier){
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
            {
            Transaction t = session.beginTransaction();
            String hql = "FROM QteArticle Q WHERE Q.codeCom = 1101";
            Query<CloneQteArticle> query = session.createQuery(hql, CloneQteArticle.class);
            ArrayList<CloneQteArticle> qteArticleList = (ArrayList<CloneQteArticle>) query.list();
            return qteArticleList;
            }
    }  */  
    
	public static void main(String[] args) throws ParseException
		{
		/*----- Format de date -----*/
//		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

		/*----- Ouverture de la session -----*/
		try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
			{
			/*----- enregistrement des employés -----*/
                            
                        /*----- liste articles -----*/
                            try{
                                List<ArticleDto> articleDtos = ListeArticles.listeArticlesByMagasin(1);
                                
//                                for(ArticleDto a : articleDtos){
//                                    System.out.println(a.getCodeArticle());
//                                    System.out.println(a.getLibelle());
//                                    System.out.println(a.getPhoto());
//                                    System.out.println(a.getQteDisponible());
//                                    System.out.println(a.getNutriscore());
//                                    System.out.println(a.getPrixAuKilo());
//                                    System.out.println(a.getUniteL());
//                                }
                           // ConfirmerCommande.creerCommande();
                                //System.out.println(AjouterArticle.Disponible(3,2));
                            //ConfirmerCommande.creerCommande();
                            
                         
                                
                            }catch(Exception e){
                                System.out.println(e.getMessage());
                            }
			}

		/*----- Exit -----*/
		System.exit(0);
		}


	/**
	 * Affichage d'une liste de tableaux d'objets.
	 */
	private static void affichage (List l)
		{
		Iterator e = l.iterator();
		while (e.hasNext())
			{
			Object[] tab_obj = ((Object[]) e.next());

			for (Object obj : tab_obj)
				System.out.print(obj + " ");

			System.out.println("");
			}
		}

} /*----- Fin de la classe TestHibernate -----*/
