<%-- 
    Document   : Creneau
    Created on : 7 févr. 2021, 15:10:21
    Author     : 21606937
--%>

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
        <h1>Les creneaux</h1>
        
        <div>${msg_erreur}</div>
        <form action="Confirmation">
            
        <%
            // Méthode getAttribute retourne un objet, or on souhaite une arrayList donc il faut le caster
             List<Creneau> l = (List<Creneau>)request.getAttribute("liste");
               out.println("<div><table>");
            for(Creneau c: l)
            out.println("<tr><td><input type='radio' id='idradio' value="+c.getIdCreneau()+"+ name= 'radio'><label></td><td>"+c.getJourSemaine()+" à "+c.getHeureCreneau()+"</td></tr></label>");
            out.println("</div></table>");
        %>
        
        <!--<div>${requestScope.liste}</div>-->
        
        <input type="submit" value="Confirmer le choix"> 
        </form>
    </body>
</html>