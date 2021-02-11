<%-- 
    Document   : CommandeEncours
    Created on : 11 févr. 2021, 19:53:53
    Author     : 21606937
--%>

<%@page import="java.util.List"%>
<%@page import="miage.metier.Commande"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Commande</title>
    </head>
    <body>
        <h1>Commande en cours</h1>
        
    
       
        <%
            List<Commande> l = (List<Commande>)request.getAttribute("commandes");
            out.println("<div class='dispo'><p>Vos commandes</p><table border=1>");
            out.println("<tr><th>N° Commande</th><th>Etat</th><th>Retrait</th></tr>");
            for(Commande c: l){
            out.println("<tr><td>"+c.getCodeCom()+"</td><td>"+c.getEtatCom()+"</td>");
            if(c.getCreneau()!= null){
             out.println("<td>"+c.getCreneau().getDateHeureCreneau()+"</td></tr></label>");
            }else{
            out.println("<td></td></tr>");
            }
            
            }  
            out.println("</table>");
            
            %>
    </body>
</html>
