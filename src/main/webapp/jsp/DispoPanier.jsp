<%-- 
    Document   : DispoPanier
    Created on : 11 févr. 2021, 20:36:59
    Author     : 21606937
--%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="miage.metier.Article"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panier</title>
    </head>
    <body>
        <h1>Produits indisponibles</h1>
        
<%                      
                        List<Article> l = (List<Article>)request.getAttribute("dispo");
                        if(l.size()==1){
                            out.println("<p>Ce produit n'est malheureusement plus disponible</p><ul>");
                         }else{
                            out.println("<p>Ces produits ne sont malheureusement plus disponibles</p><ul>");
                        }
                        for(Article a: l){
                        out.println("<li>"+a.getLibelleA()+"</li>");
                         }
                         session = request.getSession(false);
                         HashMap<Article, Integer> panier = new HashMap<Article, Integer>();
                         panier = (HashMap<Article, Integer>)session.getAttribute("panier");
                         float prixTotal = 0;
                         
                         for(HashMap.Entry <Article, Integer> map: panier.entrySet()){
                         prixTotal+=  map.getKey().getPrixVente()*map.getValue();
                            }
                        out.println("</ul>");
                        out.println("<br>Le prix total de votre panier est désormais de: "+prixTotal+"€");
            
            %>
            <a href="CtrlDispoPanier"><input type="button" value="Valider mon panier"></a>
            <a href="CtrlListeArticles"><input type="button" value="Retourner à la page d'Accueil"></a>
    </body>
</html>
