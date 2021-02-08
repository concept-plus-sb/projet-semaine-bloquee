<%-- 
    Document   : Creneau
    Created on : 7 févr. 2021, 15:10:21
    Author     : 21606937
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="miage.metier.Creneau"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creneau</title>
    </head>
    <body>
        <h1>Les creneaux</h1>
        
        <div>${msg_erreur}</div>
        <form action="Confirmation">
            
        <%
            // Méthode getAttribute retourne un objet, or on souhaite une arrayList donc il faut le caster
             List<Creneau> l = (List<Creneau>)request.getAttribute("liste");
               out.println("<div><table>");
            for(Creneau c: l)
            out.println("<tr><td><input type='radio' id='idradio' value="+c.getIdCreneau()+"+ name= 'radio'><label></td><td>"+c.getJourSemaine()+" à "+c.getHeureCreneau()+"</td></tr></label>");
            out.println("</div></table>");
        %>
        
        <!--<div>${requestScope.liste}</div>-->
        
        <input type="submit" value="Confirmer le choix"> 
        </form>
    </body>
</html>
