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
	<link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="css/css.css">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
                    <img src="img/E.png" alt="" width="60" height="54">
                </a>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Accueil</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Rayons
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#">Action</a></li>
                                <li><a class="dropdown-item" href="#">Another action</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="#">Something else here</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <div class="d-flex">
                    <a class="navbar-brand" href="#">
                        <img src="img/126083.png" alt="" width="40" height="34">
                    </a>
                </div>
            </div>
        </nav>
        <div>
            <div id="all_articles">
                
            <%
                session = request.getSession(false);
                HashMap<Article, Integer> panier = new HashMap<Article, Integer>();
                panier = (HashMap<Article, Integer>)session.getAttribute("panier");
                int i=1;
                float prixTotal = 0;
                for(HashMap.Entry <Article,Integer> map: panier.entrySet()){
                    out.println("<div>");
                    out.println("<form methode='get' action='ctrlSupprimer'>");
                    out.println("<table>");
                    out.println("<tr><td rowspan='4'><img src='img/biscuits_1.jpg' alt='img-biscuits' width='200'/></td><td>"+map.getKey().getLibelleA()+"</td><td></td></tr>");
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
                    prixTotal = prixTotal + map.getKey().getPrixVente().getPrix()*map.getValue();
                }
                    out.println("<div id='footer'><div id='price_total'>Prix total: "+prixTotal+"</div>");
                    /*<input type="button" value="Valider mon panier" id="btn_submit" />*/
                    out.println("</div></div></div>");
            %>
        <input type="button" onclick="window.location.href='http://localhost:8080/projet-semaine-bloquee/newservlet';" value="retour"/>
        <input type="button" onclick="window.location.href='http://localhost:8080/projet-semaine-bloquee/ServletCreneau';" value="valider"/>
    </body>
</html>
