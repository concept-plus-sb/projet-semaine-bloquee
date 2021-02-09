<%-- 
    Document   : GoToPanierTemp
    Created on : 7 févr. 2021, 18:10:19
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="../css/css.css">
        <title>GO TO PANIER</title>
        
    </head>
    <body>
        
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
                    <img src="../img/E.png" alt="" width="60" height="54">
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
                    <a href="http://localhost:8080/projet-semaine-bloquee/viewPanier?action=showPanier">
                        <img src="../img/126083.png" alt="" width="40" height="34"></a>
                        
                    </a>
                    <%//si la session existe, calcule prix total
                        if (session.getAttribute("panier")!=null){
                            session = request.getSession(false);
                            HashMap<Article, Integer> panier = new HashMap<Article, Integer>();
                            panier = (HashMap<Article, Integer>)session.getAttribute("panier");
                            float prixTotal = 0;
                            for(HashMap.Entry <Article,Integer> map: panier.entrySet()){
                                prixTotal = prixTotal + map.getKey().getPrixVente().getPrix()*map.getValue();
                            }

                            out.println("<span id='prixPanier'>"+prixTotal+"&euro;</span>");
                        }else{
                            out.println(0);
                        }
                    %>
                </div>
            </div>
        </nav>
        
        <!-- cliquez d'abord sur "creer session" -->
        <div><a href="http://localhost:8080/projet-semaine-bloquee/newservlet">creer session</a></div>
        <!-- puis cliquez sur "visualiser mon panier" -->
    	<!--msg erreur - 1er moyen si jamais le valeur de msg_error est null, il va le transformer en chaine caractère vide-->
    	<div>${msg_error}</div>
    </body>
</html>
