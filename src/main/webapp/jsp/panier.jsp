<%-- 
    Document   : panier
    Created on : 7 févr. 2021, 17:49:12
    Author     : luqil
--%>

<%@page import="miage.metier.Photo"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.Map"%>
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
        <div>
            <div id="all_articles">
  <!-- Left Column / Headphones Image -->
  <div class="left-column">
      
            <%
                session = request.getSession(false);
                HashMap<Article, Integer> panier = new HashMap<Article, Integer>();
                panier = (HashMap<Article, Integer>)session.getAttribute("panier");
                if(panier.isEmpty()){
                    out.println("<div> Mon panier est vide.</div>"); 
                }else{
                    int i=1;
                    float prixTotal = 0;
                    ListIterator<Map.Entry<Article, Integer>> lst = new ArrayList<Map.Entry<Article, Integer>>(panier.entrySet()).listIterator(panier.size());
                    while(lst.hasPrevious()) {  
                        Map.Entry<Article, Integer> entry = lst.previous();  
                        Set<Photo> photos=entry.getKey().getPhotos();
                        out.println("<div>");
                        out.println("<form methode='get' action='CtrlPageChoixMagasin'>");
                        out.println("<table>");
                        out.println("<tr><td rowspan='4'><img data-image='' src='"+photos.iterator().next().getLien()+"' alt='' width='60' height='54'></td><td colspan='2'>"+entry.getKey().getLibelleA()+"</td><td></td></tr>");
                        //out.println("<tr><td rowspan='4'><img src='img/biscuits_1.jpg' alt='img-biscuits' width='200'/></td><td colspan='2'>"+entry.getKey().getLibelleA()+"</td><td></td></tr>");
                        /*out.println("<tr><td rowspan='4'><img src='img/biscuits_1.JPG' width='200'/></td><td>"+map.getKey().getLibelleA()+"</td><td>"
                                + "<button type='submit' formaction='ctrlOperationArticlePanier' name = 'articlePanierBtn' id='btn_del'>supprimer</button></td></tr>");*/
                        
                        out.println("<tr><td colspan='2'>"+entry.getKey().getMarqueA().getMarque()+"</td></tr>");
                        out.println("<tr><td colspan='2'>contenance : "+entry.getKey().getContenance()+" "+entry.getKey().getUniteM() +"</td></tr>");
                        out.println("<tr><td>prix unitaire : "+entry.getKey().getPrixVente()+"&euro;</td><td><span id='"+i+"'> quantité : "+entry.getValue()+" </span></td></tr>");
                        /*out.println("<tr><td>prix unitaire: "+map.getKey().getPrixVente().getPrix()+"&euro;</td><td>"
                                + "<button type='submit' formaction='ctrlOperationArticlePanier' name = 'articlePanierBtn' id='btn_substract'>-</button>"
                                + "<span id='"+i+"'> "+map.getValue()+" </span>"
                                + "<button type='submit' formaction='ctrlOperationArticlePanier' name = 'articlePanierBtn' id='btn_add'>+</button></td></tr>");*/
                        out.println("</table><form></div><br/>");
                        prixTotal = prixTotal + entry.getKey().getPrixVente()*entry.getValue();
                        i++;
                    }
                    out.println("<div id='footer'><div id='price_total'>Prix total: "+Math.round(((float)prixTotal)*100.)/100.+"&euro;</div>");
                    /*<input type="button" value="Valider mon panier" id="btn_submit" />*/
                    out.println("</div></div></div>");
                    out.println("<form method='post' action='ServletCreneau'>");
                    out.println("<button type='submit'>Confirmer</button></form>");
                }
            %>
        <input type="button" onclick="window.location.href='http://localhost:8080/projet-semaine-bloquee/CtrlListeArticles';" value="retour"/>
    </body>
</html>
