<%-- 
    Document   : GoToPanierTemp
    Created on : 7 févr. 2021, 18:10:19
    Author     : luqil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GO TO PANIER</title>
    </head>
    <body>
        <div><a href="http://localhost:8080/projet-semaine-bloquee/newservlet">creer session</a></div>
        <div><a href="http://localhost:8080/projet-semaine-bloquee/viewPanier?action=showPanier">visualiser mon panier</a></div>
    	<!--msg erreur - 1er moyen si jamais le valeur de msg_error est null, il va le transformer en chaine caractère vide-->
    	<div>${msg_error}</div>
    </body>
</html>
