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
        <link rel="stylesheet" href="css/articleStyle.css"/>
        <title>Page article</title>
    </head>
    <body>
        
  <main class="container">
    <%Article a=new Article();
        a= (Article)request.getAttribute("objetArticle");
        Set<LabelQualite> labels= a.getLabel();
        Set<Photo> photos=a.getPhotos();%>
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
         <% out.print("<h1>"+a.getLibelleA()+"-"+(int)a.getContenance()+" "+a.getUniteM()+ "</h1>");
          out.print("<p>"+a.getMarqueP()+"</p>");
         if(a.getNbDose()>0){
           out.print("<p>Nb de doses:"+a.getNbDose()+"</p>");
         }
            out.print("<p> Origine:"+a.getOrigine()+ "</p>");%>
         
         <% out.print("<p>"+a.getComposition() +"</p>");
         %>       
    </div>
      
      <!-- label Configuration -->
      <div class="label-config">
        <span>Type stockage</span>
 
        <div class="label-view">
        <% for(LabelQualite l: labels){
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
        <% out.print("<span> Prix :"+a.getPrixVente().getPrix()+"€</span>");
        out.print("<span> Prix :"+((a.getPrixVente().getPrix())/a.getContenance())*1000+" €/"+a.getUniteL() + "</span>"); %>

      <a href="#" class="cart-btn">Ajouter au panier</a>
    </div>
      </div>
    </div>
    
  
</main>
        
    </body>
</html>
