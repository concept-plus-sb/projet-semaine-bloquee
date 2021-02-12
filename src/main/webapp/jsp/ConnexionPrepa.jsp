
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
        <link rel="stylesheet" href="css/css.css">
        
        <title>Connexion préparateur</title>
    </head>
    <body>
    
        <form method="GET" action="http://localhost:8080/projet-semaine-bloquee/CtrlConnexionPrepa">
            <table>
                <tr>
                    <td> Email : </td>
                    <td> <input type="email" name="txtEmail"> </td>
                </tr>
                <tr>
                    <td> Mot de passe :  </td>
                    <td> <input type="password" name="txtMdp" value=""> </td>
                </tr>
                <tr> 
                    <td> <input type="submit" value="Connexion"> </td>
                </tr>
            </table>
        </form>
        
    </body>
</html>
