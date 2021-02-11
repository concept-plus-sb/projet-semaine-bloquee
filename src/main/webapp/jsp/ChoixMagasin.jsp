<%-- 
    Document   : ChoixMagasin
    Created on : 10 févr. 2021, 15:20:57
    Author     : Ismail
--%>

<%@page import="miage.metier.Client"%>
<%@page import="miage.metier.Magasin"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="css/css.css">
        <title>Choix magasin</title>
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
                    <a class="navbar-brand" href="#">
                        <img src="img/126083.png" alt="" width="40" height="34">
                    </a>
                </div>
            </div>
        </nav>
    <body>
        <% String l_s_libMagasin= ((Client)session.getAttribute("client")).getMagasin().getLibelleMagasin();
           int l_i_idMagasin= ((Client)session.getAttribute("client")).getMagasin().getIdMagasin();
            out.print("<p class='magdispo'>Votre magasin par défaut est :"+l_s_libMagasin+"</p>"); %>
            <br><p>Vous pouvez choisir un autre magasin de retrait</p>
            
        <form method="GET" action="CtrlChoixMagasin">
        <select name="idmagasin" id="idmagasin">
        <%
            ArrayList<Magasin> magasins = (ArrayList<Magasin>)request.getAttribute("liste");
            
            for(Magasin m:magasins){
                if(m.getIdMagasin()==l_i_idMagasin){
                    out.print("<option value=\""+m.getIdMagasin()+"\">"+m.getLibelleMagasin()+"</option>");
                }     
            }
            for(Magasin m:magasins){
                if(m.getIdMagasin()!=l_i_idMagasin){
                    out.print("<option value=\""+m.getIdMagasin()+"\">"+m.getLibelleMagasin()+"</option>");
                }     
            }
            out.print("</select>");
           
        %> 
           <input type="submit" value="Confirmer"> 
        </form>
        
    </body>
</html>
