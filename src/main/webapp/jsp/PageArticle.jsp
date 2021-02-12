<%-- 
    Document   : PageArticle
    Created on : 7 févr. 2021, 15:31:53
    Author     : Ismail
--%>

<%@page import="miage.metier.Photo"%>
<%@page import="miage.metier.LabelQualite"%>
<%@page import="java.util.Set"%>
<%@page import="miage.bd.TestHibernate"%>
<%@page import="miage.metier.Article"%>
<%@page import="miage.metier.SousFamille"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="css/articleStyle.css"/>
        <title>Page article</title>
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
        
  <main class="container">
    <%
        Article a=new Article();
        a= (Article)request.getAttribute("objetArticle");
        Set<LabelQualite> labels= a.getLabel();
        Set<Photo> photos=a.getPhotos();
    %>
  <!-- Left Column / Headphones Image -->
  <div class="left-column">
      <div class="blocimages">
      <% for(Photo p: photos){ %>
        <div class="images" >
         <% out.print("<img data-image=\"\" src=\""+p.getLien()+"\" alt=\"\">");%>
        </div> <%} %>
     </div>
     <!-- Product Pricing -->
    
  </div>
  <!-- Right Column -->
  <div class="right-column">
 
    <!-- Product Description -->
    <div class="product-description">
        <%
            out.print("<span>"+a.getSousfamille().getLibelleSF()+ "</span>");
        %>
        <%  out.print("<h1>"+a.getLibelleA()+"-"+(int)a.getContenance()+" "+a.getUniteM()+ "</h1>");
            out.print("<p>"+a.getMarqueP()+"</p>");
            if(a.getNbDose()>0){
                out.print("<p>Nb de doses:"+a.getNbDose()+"</p>");
            }
            out.print("<p> Origine:"+a.getOrigine()+ "</p>");%>
         
        <% 
            out.print("<p>"+a.getComposition() +"</p>");
        %>       
    </div>
      
      <!-- label Configuration -->
      <div class="label-config">
        <span>Labels:</span>
 
        <div class="label-view">
        <% 
            for(LabelQualite l: labels){
                out.print("<button disabled>"+l.getLibelleLQ()+"</button>");
            }
        %>
        </div> 
 
      </div>
      
      <div class="nutriscore-config">
        <span>Nutriscore</span>
 
        <div class="nutriscore-view">
          <% switch((a.getNutriscore().getNutriscore())){
            case "A": %>
                  <img data-image="black" src="img/NutriscoreA.png" alt="" height="31" weight="51">
                <% break;
            case "B": %>
                   <img data-image="black" src="img/NutriscoreB.png" alt="" height="31" weight="51">
                 <%break;
            case "C":%>
                   <img data-image="black" src="img/NutriscoreC.png" alt="" height="31" weight="51">
                 <%break;
             case "D":%>
                  <img data-image="black" src="img/NutriscoreD.png" alt="" height="31" weight="51">
                 <%break;
             case "E":%>
                   <img data-image="black" src="img/NutriscoreE.png" alt="" height="31" weight="51">
                 <%break;
          }
          %>
          </div>
        </div> 
          <div class="product-price">
        <% out.print("<span> Prix :"+a.getPrixVente()+"€</span>");
        out.print("<span> Prix :"+((a.getPrixVente())/a.getContenance())*1000+" €/"+a.getUniteL() + "</span>"); %>
        
        <%
            out.println("<a href=\"CtrlAjouterArt?idA="+a.getCodeA()+"&page=art\" class=\"cart-btn\">");
            %>
      <!--<a href="CtrlAjouterArt" class="cart-btn">-->
          Ajouter au panier</a>
          
          <a href="CtrlListeArticles"> Retour </a> 
          <a href="CtrlPageChoixMagasin"> Magasin </a> 

    </div>
      </div>
    </div>
    
  
</main>
        
    </body>
</html>
