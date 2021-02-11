<%-- 
    Document   : ChoixMagasin
    Created on : 10 févr. 2021, 15:20:57
    Author     : Ismail
--%>

<%@page import="miage.metier.Article"%>
<%@page import="java.util.HashMap"%>
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
