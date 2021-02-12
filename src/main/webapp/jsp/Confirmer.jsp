<%-- 
    Document   : TestConfirmation
    Created on : 8 févr. 2021, 15:30:53
    Author     : Afaf
--%>

<%@page import="java.util.HashMap"%>
<%@page import="miage.metier.Article"%>
<%@page import="miage.metier.Article"%>
<%@page import="miage.metier.Creneau"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="css/css.css">
        <title>Confirmation</title>
    </head>
     <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
                    <img src="img/E.png" alt="" width="60" height="54">
                </a>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="CtrlListeArticlesAccueil">% Promotions</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="CtrlListeArticles">Tous les articles</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="CtrlCmdEncours">Mes commandes</a>
                        </li>
                    </ul>
                </div>
                <div class="d-flex">
                    <a class="navbar-brand" href="Deconnexion">
                        <img src="img/deco.png" alt="" width="40" height="34">
                    </a>
                    <a class="navbar-brand" href="panier">
                        <img src="img/126083.png" alt="" width="40" height="34">
                    </a>
                    <%//si la session existe, calcule le prix total
                        if (session.getAttribute("panier")!=null){
                            session = request.getSession(false);
                            HashMap<Article, Integer> panier = new HashMap<Article, Integer>();
                            panier = (HashMap<Article, Integer>)session.getAttribute("panier");
                            float prixTotal = 0;
                            
                            for(HashMap.Entry <Article,Integer> map: panier.entrySet()){
                                prixTotal = prixTotal + map.getKey().getPrixVente()*map.getValue();
                            }
                            out.println("<span id='prixPanier'>"+Math.round(((float)prixTotal)*100.)/100.+"&euro;</span>");
                        }else{//sinon affiche 0
                            out.println(0);
                        }
                    %>
                </div>
                <div> 
                    
                </div>
            </div>
        </nav>
    <body>
        <h1>Confirmation</h1>
        <!--<a href="CtrlConfirmer?idCre=1"> Confirmer votre commande </a> -->
        
        <form action="ServletCreneau" method="post">
        <%
        String creneau = (String)session.getAttribute("radio");
        
        out.print("<H3>Vous avez choisit un retrait le: "+creneau+"</H3>");
        
        %>
       
        <button type="submit" name="action" value="confirmer">Confirmer</button>
        <button type="submit" name="action" value="annuler">Retour</button>
        </form>
    </body>
</html>
