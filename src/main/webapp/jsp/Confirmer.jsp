<%-- 
    Document   : TestConfirmation
    Created on : 8 févr. 2021, 15:30:53
    Author     : Afaf
--%>

<%@page import="miage.metier.Creneau"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation</title>
    </head>
    <body>
        <h1>Confirmation</h1>
        <!--<a href="CtrlConfirmer?idCre=1"> Confirmer votre commande </a> -->
        
        <form action="ServletCreneau" method="post">
        <%
        String creneau = (String)session.getAttribute("radio");
        
        out.print("<H3>Vous avez choisit un retrait le: "+creneau+"</H3>");
        
        %>
       
        <button type="submit" name="action" value="confirmer">Confirmer</button>
        <button type="submit" name="action" value="annuler">Retour</button>
        </form>
    </body>
</html>
