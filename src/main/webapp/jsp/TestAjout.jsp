<%-- 
    Document   : Test
    Created on : 8 févr. 2021, 11:57:09
    Author     : estel
--%>

<%@page import="miage.metier.Article"%>
<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <a href="http://localhost:8080/TpRtt/ajout?idA=1"> AjoutArticle1 </a>
        
        
        <% 
            
            
            HashMap<Article,Integer> panier = new HashMap();
            panier = (HashMap<Article,Integer>)session.getAttribute("panier");
            
            if(panier!=null){
                for(HashMap.Entry<Article,Integer> map: panier.entrySet()){
                    out.println("<div>"+map.getKey().getCodeA()+"quantite : "+map.getValue()+"</div>");
                }
            }

        %>
        
        <a href="http://localhost:8080/TpRtt/ajout?idA=2"> AjoutArticle1 </a>
        
    </body>
</html>
