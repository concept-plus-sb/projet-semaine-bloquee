/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import miage.bd.AjouterArticle;
import miage.metier.Article;

/**
 *
 * @author estel
 */
public class CtrlAjouterArt extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            Article a=null;
            int idA = Integer.parseInt(request.getParameter("idA"));
            String page = request.getParameter("page");
            HashMap<Article, Integer> paniertemp = new HashMap<>();
            
            a=AjouterArticle.recupArt(idA);
            
            //Ouverture de la session. 
            HttpSession session = request.getSession(true);
            
            //Test si la session panier est vide.
            if(session.getAttribute("panier")!=null){
                //On récupère la session dans paniertemp.
               paniertemp = (HashMap<Article, Integer>)session.getAttribute("panier"); 
            }
            
            //Ajout de l'article.
            paniertemp.put(a, 1);
            
            //Renvoie du HashMap à la session.
            session.setAttribute("panier", paniertemp);
            
            if (page.equals("art")){
                RequestDispatcher rd = request.getRequestDispatcher("CtrlPageArticle?article="+idA);
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("CtrlListeArticles");
                rd.forward(request, response);
            }
              
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
