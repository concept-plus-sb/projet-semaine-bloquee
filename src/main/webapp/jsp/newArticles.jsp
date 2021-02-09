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
        <link rel="stylesheet" href="articles.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" 
        integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar">
            
        </nav>
        <div class="container">
            <div class="box">
                <h3>Product one</h3>
                <img src="bueno.jpg" alt="">    
                <div class="addToCart">                   
                    <p class="prix">Prix<span>€</span></p>
                    <form>
                        <div class="value-button" id="decrease" onclick="decreaseValue()" value="Decrease Value">-</div>
                        <input type="number" id="number" value="0" />
                        <div class="value-button" id="increase" onclick="increaseValue()" value="Increase Value">+</div>
                    </form>
                </div> 
            </div>

            <div class="box">
                <h3>Product two</h3>
                <img src="bueno.jpg" alt="">
                <div class="addToCart"> 
                    <p class="prix">Prix<span>€</span></p>
                    <form>
                        <div class="value-button" id="decrease" onclick="decreaseValue()" value="Decrease Value">-</div>
                        <input type="number" id="number" value="0" />
                        <div class="value-button" id="increase" onclick="increaseValue()" value="Increase Value">+</div>
                    </form>
                </div>
            </div>

            <div class="box">                
                <h3>Product three</h3>
                <img src="bueno.jpg" alt="">
                <div class="addToCart">           
                    <p class="prix">Prix<span>€</span></p>
                    <form>
                        <div class="value-button" id="decrease" onclick="decreaseValue()" value="Decrease Value">-</div>
                        <input type="number" id="number" value="0" />
                        <div class="value-button" id="increase" onclick="increaseValue()" value="Increase Value">+</div>
                    </form>
                </div>
            </div>

            <div class="box">
                <h3>Product four</h3>
                <img src="bueno.jpg" alt="">
                <div class="addToCart">           
                    <p class="prix">Prix<span>€</span></p>
                    <form>
                        <div class="value-button" id="decrease" onclick="decreaseValue()" value="Decrease Value">-</div>
                        <input type="number" id="number" value="0" />
                        <div class="value-button" id="increase" onclick="increaseValue()" value="Increase Value">+</div>
                    </form>
                </div>
            </div>
        </div>
        <script>
            function increaseValue() {
                var value = parseInt(document.getElementById('number').value, 10);
                value = isNaN(value) ? 0 : value;
                value++;
                document.getElementById('number').value = value;
            }

            function decreaseValue() {
                var value = parseInt(document.getElementById('number').value, 10);
                value = isNaN(value) ? 0 : value;
                value < 1 ? value = 1 : '';
                value--;
                document.getElementById('number').value = value;
            }
        </script>
    </body>
</html>
