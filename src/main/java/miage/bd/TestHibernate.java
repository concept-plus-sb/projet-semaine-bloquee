package miage.bd;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import miage.metier.Article;
import org.hibernate.Session;

/**
 * Hibernate.
 */
public class TestHibernate
{
    public static SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    public static void enregistrerSousFamille(){
//        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession())
//            {
//            Transaction t = session.beginTransaction();
//            session.save(new SousFamille("ssf test 01"));
//            t.commit();
//            }
    }

    
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
                                List<Article> articles = ListeArticles.listeArticlesByMagasin(1);
                                
                                for(Article a : articles){
                                    System.out.println(a.getPhotos());
                                }
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
