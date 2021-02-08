
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
        <title>Connexion</title>
    </head>
    <body>
        <h1>Se connecter</h1>
    
        <form method="GET" action="http://localhost:8080/TpRtt/CtrlConnexion">
            <table>
                <tr>
                    <td> Email : </td>
                    <td> <input type="email" name="txtEmail" 
                                value=${param.txtEmail}> </td>
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
            
            <div>${erreursaisie} </div>
            <div>${erreur}</div>
                
    </body>
</html>
