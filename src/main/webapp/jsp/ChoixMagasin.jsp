<%-- 
    Document   : ChoixMagasin
    Created on : 10 févr. 2021, 15:20:57
    Author     : Ismail
--%>

<%@page import="miage.metier.Magasin"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Choix magasin</title>
    </head>
    <body>
        <h1>Veuillez selectionner un magasin :</h1>
        <select name="magasin" id="magasin-select">
        <%
            ArrayList<Magasin> magasins = (ArrayList<Magasin>)request.getAttribute("liste");
            for(Magasin m:magasins){
                   out.print("<option value=\""+m.getIdMagasin()+"\">"+m.getLibelleMagasin()+"</option>");
            }
            out.print("</select>");
        %> 
        
    </body>
</html>
