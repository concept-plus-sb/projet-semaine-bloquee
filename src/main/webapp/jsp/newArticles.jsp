<%-- 
    Document   : newArticles
    Created on : 9 févr. 2021, 16:23:09
    Author     : arsla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" charset="utf-8"
        content="width=device-width, initial-scale=1.0">
        <title>Catalogue</title>
        <link rel="stylesheet" href="../css/articles.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" 
        integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <div class="box">
                <h3>Product four</h3>
                <img src="../img/biscuits_1.jpg" alt="biscuits">
                <div class="addToCart">          
                    <form>
                        <input type="number" id="btnPanier" name="btnPanier" min="0" max="100">
                    </form>
                    <p class="prix">Prix<span>€</span></p>
                </div>
            </div>
        </div>
    </body>
</html>
