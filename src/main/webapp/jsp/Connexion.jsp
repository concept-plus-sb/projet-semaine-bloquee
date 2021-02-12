
<%-- 
    Document   : Connexion
    Created on : 7 févr. 2021, 15:32:34
    Author     : estel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="./css/connexionStyle.css">
        
        <title>Connexion</title>
    </head>
    <body>
        <form class="box" method="GET" action="CtrlConnexion">
            <h1>Se connecter</h1>
            <input type="email" name="txtEmail" placeholder="Email" value=${param.txtEmail}>
            <input type="password" name="txtMdp" value="" placeholder="Password">
            <input type="submit" value="Connexion">
        </form>
            
            <div>${erreursaisie} </div>
            <div>${erreur}</div>
                
    </body>
</html>
