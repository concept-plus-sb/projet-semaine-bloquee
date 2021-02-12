<%-- 
    Document   : PageCommande
    Created on : 11 févr. 2021, 16:39:17
    Author     : Ismail
--%>

<%@page import="java.util.Set"%>
<%@page import="miage.metier.Famille"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.HashMap"%>
<%@page import="miage.metier.QteArticle"%>
<%@page import="java.util.Map"%>
<%@page import="miage.metier.Article"%>
<%@page import="miage.metier.Commande"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Page commande :</h1>
        <%
        Commande c= (Commande)request.getAttribute("objetCommande");
        System.out.println(c.getClient());
        Map<Article, QteArticle> articles=c.getQteArticles();
         System.out.println(c.getQteArticles());
         Map<Article, QteArticle> frais= new HashMap<>();
         Map<Article, QteArticle> congele= new HashMap<>();
         Map<Article, QteArticle> normal= new HashMap<>();

         for (Map.Entry mapentry : articles.entrySet()) {
             switch(((Article)mapentry.getKey()).getTypeStockage().toString()){
                 case ("frais") :
                    frais.put((Article)mapentry.getKey(), (QteArticle)mapentry.getValue());
                    break;
                 case("congele"):
                    congele.put((Article)mapentry.getKey(), (QteArticle)mapentry.getValue());
                     break;
                 case("normal"):
                    normal.put((Article)mapentry.getKey(), (QteArticle)mapentry.getValue());
                     break;
             }         }
         
         out.print("<h2>Rayon normal:</h2>");
          out.print("<table border=6 cellspacing=12 cellpadding=20>");%>

         <tr><td>Article</td>
        <td>Quantité </td>
        <td>EAN</td>
        <td>Rayon</td></tr>
        <% 
          for (Map.Entry mapentry : normal.entrySet()) {
              out.print("<tr><td>"+((Article)mapentry.getKey()).getLibelleA()+"</td>");
              out.print("<td>"+((QteArticle)mapentry.getValue()).getNombreArticle()+"</td>");
              out.print("<td>"+((Article)mapentry.getKey()).getEan()+"</td></tr>");          }
          out.print("</table>");
         out.print("<h2>Rayon frais:</h2>");
         out.print("<table border=6 cellspacing=12 cellpadding=20>");%>
         
        <tr><td>Article</td>
        <td>Quantité </td>
        <td>EAN</td>
        <td>Rayon</td></tr>

       <%   for (Map.Entry mapentry : frais.entrySet()) {
              out.print("<tr><td>"+((Article)mapentry.getKey()).getLibelleA()+"</td>");
              out.print("<td>"+((QteArticle)mapentry.getValue()).getNombreArticle()+"</td>");
              out.print("<td>"+((Article)mapentry.getKey()).getEan()+"</td></tr>");
           } 
          out.print("</table>");
          out.print("<h2>Rayon surgelé: </h2>");
          out.print("<table border=6 cellspacing=12 cellpadding=20>");%>
          <tr><td>Article</td>
           <td>Quantité </td>
           <td>EAN</td>
          <td>Rayon</td></tr>

          <% for (Map.Entry mapentry : congele.entrySet()) {
              out.print("<tr><td>"+((Article)mapentry.getKey()).getLibelleA()+"</td>");
              out.print("<td>"+((QteArticle)mapentry.getValue()).getNombreArticle()+"</td>");
              out.print("<td>"+((Article)mapentry.getKey()).getEan()+"</td>");  
              Set<Famille> hset=((Article)mapentry.getKey()).getSousfamille().getFamilles();
              String rayon="";
              for(Famille s : hset){
                 rayon =s.getRayon().getLibelleR();
                 System.out.println(s);
              }
              out.print("<td>"+rayon+"</td></tr>");}
          out.print("</table>");

         
    %>
    </body>
</html>
