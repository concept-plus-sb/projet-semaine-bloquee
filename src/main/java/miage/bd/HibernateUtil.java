package miage.bd;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 * Chargement de la configuration et création de la SessionFactory.
 * (hibernate.cfg.xml)
 */
public class HibernateUtil
{
	private static final SessionFactory SESSION_FACTORY;

	static
		{
		try	{
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            System.out.println("Hibernate Configuration loaded");

			/**
			 * Ajout des classes.
			 * Pour miage.metier.Employe le fichier ressource hbm.xml
			 * attaché est miage/metier/Employe.hbm.xml.
			 */
//			configuration.addClass(miage.metier.Employe.class);

			/**
			 * Entité.
			 */
			//configuration.addAnnotatedClass(miage.metier.Employe.class);
                        
                        configuration.addAnnotatedClass(miage.metier.EAN.class);
                        configuration.addAnnotatedClass(miage.metier.Calendrier.class);
                        configuration.addAnnotatedClass(miage.metier.Photo.class);
                        configuration.addAnnotatedClass(miage.metier.Article.class);
                        configuration.addAnnotatedClass(miage.metier.EnumStockage.class);
			configuration.addAnnotatedClass(miage.metier.LabelQualite.class);
                        configuration.addAnnotatedClass(miage.metier.Nutriscore.class);
                        configuration.addAnnotatedClass(miage.metier.PrixVente.class);
                        configuration.addAnnotatedClass(miage.metier.Article.class);
                        configuration.addAnnotatedClass(miage.metier.Commande.class);
                        configuration.addAnnotatedClass(miage.metier.QteArticle.class);
                        configuration.addAnnotatedClass(miage.metier.Client.class);
                        configuration.addAnnotatedClass(miage.metier.Promotion.class);
                        configuration.addAnnotatedClass(miage.metier.QuantitePromo.class);
                        configuration.addAnnotatedClass(miage.metier.MarqueProprietaire.class);

			configuration.addAnnotatedClass(miage.metier.SousFamille.class);
			configuration.addAnnotatedClass(miage.metier.Famille.class);
			configuration.addAnnotatedClass(miage.metier.Rayon.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            System.out.println("Hibernate serviceRegistry created");

            SESSION_FACTORY = configuration.buildSessionFactory(serviceRegistry);
			}
		catch (HibernateException ex)
			{
			/*----- Exception -----*/
			System.err.println("Initial SessionFactory creation failed.\n" + ex);
			throw new ExceptionInInitializerError(ex);
			}
		}


	public static SessionFactory getSessionFactory () { return SESSION_FACTORY; }

} /*----- Fin de la classe HibernateUtil -----*/
