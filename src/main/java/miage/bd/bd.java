/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import miage.metier.QteArticle;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author luqil
 */
public class bd {
	//propriété de connexion
	private static final String URL ="jdbc:mysql://localhost:3306/db_21912400";
	private static final String LOGIN ="21912400";
	private static final String PASSWORD ="U01U75";
	private static Connection CX;
        
	private static void connexion () throws Exception{
    	//chargement du driver.
            try {Class.forName("com.mysql.jdbc.Driver");}
            catch(ClassNotFoundException cnfe){
                    //renvoyer l'erreur
                    throw new Exception ("bd.connexion() - " + cnfe.getMessage());
            }
            System.out.println("flag: chargement du driver réussi.");
            //ouverture de la connexion
            try {CX = DriverManager.getConnection(URL,LOGIN,PASSWORD);}
            catch (SQLException sql) {
                    //renvoyer l'erreur
                    throw new Exception("bd.connexion() - " + sql.getMessage());
            }
            System.out.println("flag: ouverture de la connexion réussi.");
	}
    
  /*      public static ArrayList<QteArticle> augmentQteArticlePanier() throws Exception{
            if(CX==null)bd.connexion();
            //espace de requete
            PreparedStatement st=CX.prepareStatement("UPDATE QteArticle SET nombreArticle=nombreArticle+1 WHERE Country='Mexico';");
            st.setInt(1, 1059);//1059 = id_cmd 
            //executer requete
            ResultSet rs = st.executeQuery();
            //recuperer des données
            ArrayList<QteArticle> lst= new ArrayList<>();
            while (rs.next())
                lst.add(new QteArticle(id, rs.getInt("nombreArticle"), article, commande))
                lst.add(new QteArticle(rs.getInt("codeA"),rs.getInt("codeCom"),rs.getInt("nombreArticle")));
            return lst;
	}*/
    
	// programme de test
	public static void main(String[] s){
    	try{
            	System.out.println("test1");
                bd.connexion();
        	System.out.println("Connexion réussie!");
       	 
        	/*ArrayList<CloneQteArticle> liste= bd.showPanierArticles();
                
            	System.out.println("test2");
        	for(CloneQteArticle m : liste)
            	System.out.println(m);*/
    	}
    	catch(Exception e){
        	System.out.println(e.getMessage());
    	}
	}

}
