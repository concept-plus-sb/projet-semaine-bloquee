<%-- 
    Document   : panier
    Created on : 7 févr. 2021, 17:49:12
    Author     : luqil
--%>

<%@page import="miage.metier.QteArticle"%>
<%@page import="java.util.HashMap"%>
<%@page import="miage.metier.Article"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Mon panier</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="css/newcss.css" type="text/css" />
    </head>
    <body>
        <main>
            <div><img src="img/logo.JPG" width="200" alt="logo_concept_plus" /></div>
            <div class="title">Mon panier</div>
        </main>
        <div>
            <div id="all_articles">
            <%
                session = request.getSession(false);
                HashMap<Article, Integer> panier = new HashMap<Article, Integer>();
                panier = (HashMap<Article, Integer>)session.getAttribute("panier");
                int i=1;
                for(HashMap.Entry <Article,Integer> map: panier.entrySet()){
                    out.println("<div>");
                    out.println("<form methode='get' action='ctrlSupprimer'>");
                    out.println("<table>");
                    out.println("<tr><td rowspan='4'><img src='img/biscuits_1.JPG' width='200'/></td><td>"+map.getKey().getLibelleA()+"</td><td></td></tr>");
                    /*out.println("<tr><td rowspan='4'><img src='img/biscuits_1.JPG' width='200'/></td><td>"+map.getKey().getLibelleA()+"</td><td>"
                            + "<button type='submit' formaction='ctrlOperationArticlePanier' name = 'articlePanierBtn' id='btn_del'>supprimer</button></td></tr>");*/
                    out.println("<tr><td colspan='2'>"+map.getKey().getMarqueP()+"</td></tr>");
                    out.println("<tr><td colspan='2'>contenance: "+map.getKey().getContenance()+"</td></tr>");
                    out.println("<tr><td>prix unitaire: "+map.getKey().getPrixVente().getPrix()+"&euro;</td><td><span id='"+i+"'> quantité: "+map.getValue()+" </span></td></tr>");
                    /*out.println("<tr><td>prix unitaire: "+map.getKey().getPrixVente().getPrix()+"&euro;</td><td>"
                            + "<button type='submit' formaction='ctrlOperationArticlePanier' name = 'articlePanierBtn' id='btn_substract'>-</button>"
                            + "<span id='"+i+"'> "+map.getValue()+" </span>"
                            + "<button type='submit' formaction='ctrlOperationArticlePanier' name = 'articlePanierBtn' id='btn_add'>+</button></td></tr>");*/
                    out.println("</table></form></div>");
                    out.println("<div id='footer'><div id='price_total'>Prix total: "+map.getKey().getPrixVente().getPrix()*map.getValue()+"</div>");
                    /*<input type="button" value="Valider mon panier" id="btn_submit" />*/
                    out.println("</div></div></div>");
                }
            %>
        <input type="button" onclick="window.location.href='http://localhost:8080/projet-semaine-bloquee/newservlet';" value="retour"/>
        <input type="button" onclick="window.location.href='http://localhost:8080/projet-semaine-bloquee/newservlet';" value="valider"/>
    </body>
</html>
