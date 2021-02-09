<%-- 
    Document   : navbar
    Created on : 9 févr. 2021, 11:46:38
    Author     : arsla
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" charset="utf-8"
        content="width=device-width, initial-scale=1.0">
        <title>Responsive Navbar</title>
        <link rel="stylesheet" href="../css/navbarStyle.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" 
        integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    </head>
    <body>
        <header>
            <a href="#" class="logo">LOGO</a>
            <div class="menu-toggle"></div>
            <nav>
                <ul>
                    <li><a href="#" class="active">Accueil</a>
                    <li><a href="#">Rayons</a></li>
                    <li><a href="#">Catégories</a></li>
                    <li><a href="#">Produits</a></li>
                    <li><a href="#">Connexion</a></li></li>
                </ul>
            </nav>
            <div class="clearfix"></div>
        </header>
        <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
        <script type="text/javascript">
            $(document).ready(function(){
                $('.menu-toggle').click(function(){
                    $('.menu-toggle').toggleClass('active')
                    $('nav').toggleClass('active')
                })
            })
        </script>
    </body>
</html>
