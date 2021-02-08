<%-- 
    Document   : AfficherSession
    Created on : 8 févr. 2021, 13:20:31
    Author     : estel
--%>

<%@page import="miage.metier.Article"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Session</title>
    </head>
    <body>
        <h1>Afficher session</h1>
        
        <% 
            
            
            HashMap<Article,Integer> panier = new HashMap();
            panier = (HashMap<Article,Integer>)session.getAttribute("panier");

            for(HashMap.Entry<Article,Integer> map: panier.entrySet()){
               out.println(map.getKey().getCodeA()+"quantite : "+map.getValue());
            }

        %>
    </body>
</html>
