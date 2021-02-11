<%-- 
    Document   : PageArticle
    Created on : 7 févr. 2021, 15:31:53
    Author     : Ismail
--%>

<%@page import="miage.metier.EnumStockage"%>
<%@page import="miage.metier.Client"%>
<%@page import="miage.metier.Magasin"%>
<%@page import="miage.bd.AjouterArticle"%>
<%@page import="miage.metier.Photo"%>
<%@page import="miage.metier.LabelQualite"%>
<%@page import="java.util.Set"%>
<%@page import="miage.bd.TestHibernate"%>
<%@page import="miage.metier.Article"%>
<%@page import="miage.metier.SousFamille"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/articleStyle.css"/>
        <title>Page article</title>
    </head>
    <body>
        
  <main class="container">
    <%
        Article a=new Article();
        a= (Article)request.getAttribute("objetArticle");
        Set<LabelQualite> labels= a.getLabel();
        Set<Photo> photos=a.getPhotos();
        
        session = request.getSession(true);
        Client cli = (Client)session.getAttribute("client");
        Magasin m = cli.getMagasin();

    %>
  <!-- Left Column / Headphones Image -->
  <div class="left-column">
      <div class="blocimages">
      <% for(Photo p: photos){ %>
        <div class="images" >
         <% out.print("<img data-image=\"\" src=\""+p.getLien()+"\" alt=\"\">");%>
        </div> <%} %>
     </div>
     <!-- Product Pricing -->
    
  </div>
  <!-- Right Column -->
  <div class="right-column">
 
    <!-- Product Description -->
    <div class="product-description">
        <%
            out.print("<span>"+a.getSousfamille().getLibelleSF()+ "</span>");
        %>
        <%  out.print("<h1>"+a.getLibelleA()+"-"+(int)a.getContenance()+" "+a.getUniteM()+ "</h1>");
            if (a.getMarqueP()!=null){
                out.print("<p> Marque propriétaire : "+a.getMarqueP()+"</p>");
            }
            if (a.getMarqueA()!=null){
                out.println("Marque de l'article : "+a.getMarqueA().getMarque());
            }
            
            if (a.getTypeStockage()==EnumStockage.frais){
                out.print("<img data-image=\"black\" src=\"img/1.jpg\" alt=\"\" height=\"31\" weight=\"51\">");
            } else if(a.getTypeStockage()==EnumStockage.congele){
                out.print("<img data-image=\"black\" src=\"img/2.jpg\" alt=\"\" height=\"31\" weight=\"51\">");
            }
         
        
            if(a.getNbDose()>0){
                out.print("<p>Nombre de doses : "+a.getNbDose()+"</p>");
            }
           
            out.print("<p> Origine : "+a.getOrigine()+ "</p>");
            
            %>
         
        <%  if(a.getComposition()!=null){
                out.print("<p> Composition : "+a.getComposition() +"</p>");
            }
        %>       
    </div>
      
      <!-- label Configuration -->
      <div class="label-config">
        <span>Labels : </span>
 
        <div class="label-view">
        <% 
            if(labels.size()!=0){
                
                for(LabelQualite l: labels){
                    out.print("<button disabled>"+l.getLibelleLQ()+"</button>");
                }
            } else {
                out.println("Aucun");
            }
        %>
        </div> 
 
      </div>
      
      <div class="nutriscore-config">
          
          <span>Nutriscore : </span>
          
          <div class="nutriscore-view">
        <% if (a.getNutriscore()!=null){
                
        switch((a.getNutriscore().getNutriscore())){
            case "A": 
                out.println("<img data-image=\"black\" src=\"img/NutriscoreA.png\" alt=\"\" height=\"31\" weight=\"51\">");
                break;
            case "B": 
                out.println("<img data-image=\"black\" src=\"img/NutriscoreB.png\" alt=\"\" height=\"31\" weight=\"51\">");              
                break;
            case "C":
                out.println("<img data-image=\"black\" src=\"img/NutriscoreC.png\" alt=\"\" height=\"31\" weight=\"51\">");              
                break;
             case "D":
                out.println("<img data-image=\"black\" src=\"img/NutriscoreD.png\" alt=\"\" height=\"31\" weight=\"51\">");              
                break;
             case "E":
                out.println("<img data-image=\"black\" src=\"img/NutriscoreE.png\" alt=\"\" height=\"31\" weight=\"51\">");              
                break;
            }
            out.println("<p> Détail nutriscore : "+a.getNutriscore().getDescription());
            } else {
                out.println("<p> Pas de nutriscore pour cet article <p>");
            } 
          %>
          </div>
        </div> 
          <div class="product-price">
        <% 
          
            out.print("<span> Prix : "+a.getPrixVente()+"€</span>");
            java.text.DecimalFormat df = new java.text.DecimalFormat("0.##");
            out.print("<span> Prix au kilo :"+df.format((float)((a.getPrixVente())/a.getContenance())*1000)+" €/"+a.getUniteL() + "</span>"); %>
        
        
        
        <%
            if(AjouterArticle.Disponible(m, a)){
                out.println("<a href=\"CtrlAjouterArt?idA="+a.getCodeA()+"&page=art\" class=\"cart-btn\">");
                out.println("Ajouter au panier</a>");
            } else {
                out.print("<h7 class='card-title'>Article bientôt disponible</h7>");
            }
            
            %>
         
          
            <p> <a href="CtrlListeArticles"> Retour </a>  </p>

    </div>
      </div>
    </div>
    
  
</main>
        
    </body>
</html>
