<%-- 
    Document   : PageArticle
    Created on : 7 févr. 2021, 15:31:53
    Author     : Ismail
--%>

<%@page import="miage.bd.TestHibernate"%>
<%@page import="miage.metier.Article"%>
<%@page import="miage.metier.SousFamille"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="webapp/css/articleStyle.css"/>
        <title>Page article</title>
    </head>
    <body>
        
  <main class="container">
    
  <!-- Left Column / Headphones Image -->
  <div class="left-column">
    <img data-image="black" src="images/black.png" alt="">
  </div>
 
 
  <!-- Right Column -->
  <div class="right-column">
 
    <!-- Product Description -->
    <div class="product-description">
      <span><%Article a=new Article();
        a= (Article)request.getAttribute("objetArticle");
        out.print(a.getSousfamille()+"!!");
//   out.print("<h1>"+a.getSousfamille().getLibelleSF()+ "</h1>");
%></span>
         <% out.print("<h1>"+a.getLibelleA()+ "</h1>");%>
         <% out.print("<p>"+a.getComposition() +"</p>");
         %>       </div>

 
      <!-- label Configuration -->
      <div class="label-config">
        <span>Labels</span>
 
        <div class="label-view">
          <button disabled>Straight</button>
          <button disabled>Coiled</button>
          <button disabled>Long-coiled</button></br>
        </div>
 
      </div>
      
      <div class="nutriscore-config">
        <span>Nutriscore</span>
 
        <div class="nutriscore-view">
          <button disabled><% out.print(a.getNutriscore().getNutriscore()); %></button>
        </div> 
      </div>
    </div>
 
    <!-- Product Pricing -->
    <div class="product-price">
      <span>prix</span>
      <a href="#" class="cart-btn">Add to cart</a>
    </div>
  
</main>
        
    </body>
</html>
