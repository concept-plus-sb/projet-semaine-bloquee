<%-- 
    Document   : newArticles
    Created on : 9 févr. 2021, 16:23:09
    Author     : arsla
--%>

<%@page import="miage.metier.Article"%>
<%@page import="java.util.HashMap"%>
<%@page import="miage.dto.ArticleDto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" charset="utf-8"
        content="width=device-width, initial-scale=1.0">
        <title>Catalogue</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" 
        integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="css/css.css">
    </head>
    <body>
        <div>${msg_erreur}</div>
        
        
        <% 
            
            
            ArrayList<ArticleDto> articleDtos = (ArrayList<ArticleDto>)request.getAttribute("liste");
            
            /*out.print("<h2>");
            for(ArticleDto a : articleDtos){
                out.print(a.getPhoto());
            }
            out.print("</h2>");*/

        %>
        
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
                            <a class="nav-link active" aria-current="page" >Tous les articles</a>
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
        <br>
        
        <div class="container-fluid">
            <div class="row">
        <%for(ArticleDto a : articleDtos){
            out.print("<div class='col-sm-2'>");
                out.print("<div class='card'>");
                    out.print("<div class='card-body'>");
                        out.print("<h7 class='card-title'>"+a.getLibelle()+"</h7><br>");
                        out.print("<span>"+a.getPrixAuKilo()+"€/"+a.getUniteL()+"<span>");
                        out.println("<a href='CtrlPageArticle?article="+a.getCodeArticle()+"'>");
                        out.print("<img src='"+a.getPhoto()+"' alt='' class='img-fluid'>");
                        out.println("</a>");
                        out.print(a.getNutriscore());
                            out.print("<div class='row ajouter'>");            
                                if(a.getQteDisponible() <= 0){
                                    out.print("<h7 class='card-title'>Article bientôt disponible</h7>");                                      
                                }else{
                                    out.print("<input Style='width: 30%;height: 30px;' type='number' name='' id='' min='0'>");
                                    out.print("<a href='CtrlAjouterArt?idA="+a.getCodeArticle()+"&page=pageListe' class='btn btn-primary'><i class='bi bi-basket'></i></a>");
                                }
                            out.print("</div>");
                            out.print("<div class='row prix'>");
                                out.print("<h6 class='card-title'>"+a.getPrixUnitaire()+"<span> €</span></h6>"); 
                            out.print("</div>");

                    out.print("</div>");
                out.print("</div>");
            out.print("</div>");
        }%>
        </div>
        </div>
        
        
    </body>
</html>
