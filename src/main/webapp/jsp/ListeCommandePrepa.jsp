<%-- 
    Document   : ListeCommandePrepa
    Created on : 11 févr. 2021, 11:32:02
    Author     : Ismail
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="miage.metier.Commande"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="css/css.css">
        <title>Commandes à préparer</title>
    </head>
    <h1> La liste des commandes à préparer </h1>
        <%  ArrayList<Commande> commandes = (ArrayList<Commande>)request.getAttribute("commandes");
        out.print("<table border=6 cellspacing=12 cellpadding=20>");%>
        <tr>
        <th>n° Commande</th>
        <th>Créneau de récupération</th>
        <th>Client</th>
        </tr>
      <% for(Commande c:commandes){
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = new Date();
            if(c.getCreneau().getDateHeureCreneau().compareTo(date) >0){
            out.print("<tr>");
            out.print("<td><a href=\"CtrlPageCommande?id="+c.getCodeCom()+"\">"+c.getCodeCom()+"</a></td>");
            out.print("<td>"+c.getCreneau().getDateHeureCreneau()+"</td>");
            out.print("<td>"+c.getClient().getEmail()+"</td>");
            out.print("</tr>");}
        }
            out.print("</table>");
        %>
    
    <body>
    </body>
</html>
