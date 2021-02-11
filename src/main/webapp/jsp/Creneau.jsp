<%-- 
    Document   : Creneau
    Created on : 7 févr. 2021, 15:10:21
    Author     : Afaf
--%>

<%@page import="miage.metier.Article"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="miage.metier.Creneau"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="css/css.css">
        <title>Creneau</title>
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
                            <a class="nav-link active" aria-current="page" href="CtrlListeArticlesAccueil">% Promotions</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="CtrlListeArticles">Tous les articles</a>
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
            
            <div  class="creneaux">
            <h1>Les creneaux</h1>

                
                    <form action="ServletCreneau" method="post">

                    <%
                        DateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
                        DateFormat formatHeure = new SimpleDateFormat("HH:mm");
                        // Méthode getAttribute retourne un objet, or on souhaite une arrayList donc il faut le caster
                        List<Creneau> l = (List<Creneau>)request.getAttribute("liste");
                           out.println("<div class='dispo'><p>Créneaux disponibles</p><table>");
                        for(Creneau c: l)
                        
                        out.println("<tr><td><input type='radio' value="+c.getIdCreneau()+" name='btnradio'><label></td><td>"+formatDate.format(c.getDateHeureCreneau())+" à "+formatHeure.format(c.getDateHeureCreneau())+"</td><td class='nbplaces'>"+c.getNbPlaceOccupee()+"/"+c.getNbPlaceTotal()+" places occupées</td></tr></label>");
                        out.println("</table>");
                    %>

                    <input type="submit" class="btnvalider" name="action" value="valider">
                    <input type="submit" name="action" value="retour">
                    </form>
                    <div>${msg_erreur}</div>
                    
                </div>

                    <%
                        List<Creneau> indispo = (List<Creneau>)request.getAttribute("listeIndispo");
                           out.println("<div class='indispo'><p>Créneaux  indisponibles</p><table>");
                        for(Creneau c: indispo)
                        out.println("<tr><td>"+formatDate.format(c.getDateHeureCreneau())+" à "+formatHeure.format(c.getDateHeureCreneau())+"</td></tr>");
                        out.println("</table></div>");
                    %>
        </div>

    </body>
</html>
