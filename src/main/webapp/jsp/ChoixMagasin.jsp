<%-- 
    Document   : ChoixMagasin
    Created on : 10 févr. 2021, 15:20:57
    Author     : Ismail
--%>

<%@page import="miage.metier.Client"%>
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
        <% String l_s_libMagasin= ((Client)session.getAttribute("client")).getMagasin().getLibelleMagasin();
           int l_i_idMagasin= ((Client)session.getAttribute("client")).getMagasin().getIdMagasin();
            out.print("<h1>Votre magasin par défaut est :"+l_s_libMagasin+"</h1>"); %>
        <h1>Veuillez selectionner un magasin :</h1>
        <form method="GET" action="CtrlChoixMagasin">
        <select name="idmagasin" id="idmagasin">
        <%
            ArrayList<Magasin> magasins = (ArrayList<Magasin>)request.getAttribute("liste");
            
            for(Magasin m:magasins){
                if(m.getIdMagasin()==l_i_idMagasin){
                    out.print("<option value=\""+m.getIdMagasin()+"\">"+m.getLibelleMagasin()+"</option>");
                }     
            }
            for(Magasin m:magasins){
                if(m.getIdMagasin()!=l_i_idMagasin){
                    out.print("<option value=\""+m.getIdMagasin()+"\">"+m.getLibelleMagasin()+"</option>");
                }     
            }
            out.print("</select>");
           
        %> 
           <input type="submit" value="Confirmer"> 
        </form>
        
    </body>
</html>
