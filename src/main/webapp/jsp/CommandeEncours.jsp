<%-- 
    Document   : CommandeEncours
    Created on : 11 févr. 2021, 19:53:53
    Author     : Afaf
--%>

<%@page import="java.util.HashMap"%>
<%@page import="miage.metier.Article"%>
<%@page import="java.util.List"%>
<%@page import="miage.metier.Commande"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="css/css.css">
        
        <title>Commande</title>
    </head>
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
                            out.println("<span id='prixPanier'>"+prixTotal+"&euro;</span>");
                        }else{//sinon affiche 0
                            out.println(0);
                        }
                    %>
                </div>
            </div>
        </nav>
    <body>
        <h1>Commande en cours</h1>
        
    
       
        <%
            List<Commande> l = (List<Commande>)request.getAttribute("commandes");
            out.println("<div class='dispo'><p>Vos commandes</p><table border=1>");
            out.println("<tr><th>N° Commande</th><th>Etat</th><th>Retrait</th></tr>");
            for(Commande c: l){
            out.println("<tr><td>"+c.getCodeCom()+"</td><td>"+c.getEtatCom()+"</td>");
            if(c.getCreneau()!= null){
             out.println("<td>"+c.getCreneau().getDateHeureCreneau()+"</td></tr></label>");
            }else{
            out.println("<td></td></tr>");
            }
            
            }  
            out.println("</table>");
            
            %>
    </body>
</html>
