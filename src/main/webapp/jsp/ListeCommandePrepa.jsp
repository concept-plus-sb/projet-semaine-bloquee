<%-- 
    Document   : ListeCommandePrepa
    Created on : 11 févr. 2021, 11:32:02
    Author     : Ismail
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="miage.metier.Commande"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Commandes à préparer</title>
    <h1> La liste des commandes à préparer </h1>
        <%  ArrayList<Commande> commandes = (ArrayList<Commande>)request.getAttribute("commandes");
        out.print("<table border=6 cellspacing=12 cellpadding=20>");%>
        <tr>
        <td>n° Commande</td>
        <td>Créneau de récupération</td>
        <td>Client</td>
        </tr>
      <% for(Commande c:commandes){
            out.print("<tr>");
            out.print("<td><a>"+c.getCodeCom()+"</a></td>");
            out.print("<td>"+c.getCreneau().getDateHeureCreneau()+"</td>");
            out.print("<td>"+c.getClient().getEmail()+"</td>");
            out.print("</tr>");

        }
            out.print("</table>");
        %>
    </head>
    <body>
    </body>
</html>
