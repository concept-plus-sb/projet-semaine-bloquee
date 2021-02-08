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
import miage.metier.Article;
import miage.metier.EnumStockage;
import miage.metier.MarqueA;
import miage.metier.Nutriscore;
import miage.metier.PrixVente;
import miage.metier.SousFamille;

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
            /* TODO output your page here. You may use following sample code. */
            Article a=null;
            int idA = Integer.parseInt(request.getParameter("idA"));
            //a=AjouterArticle.recupArt(idA);
            
            
            MarqueA marquea = new MarqueA(10, "m_test");
            SousFamille sf=new SousFamille("sf_test");
            PrixVente prix = new PrixVente(1.2f);
            Nutriscore nu= new Nutriscore(14, "nutriscore", "description");
            if (idA==1){
            a = new Article(2, "art2", 0, "g", "kg", EnumStockage.frais, 0, "france", "composition", "mm", sf, marquea, prix, nu);
            } else {
            a = new Article(3, "art3", 0, "g", "kg", EnumStockage.frais, 0, "france", "composition", "mm", sf, marquea, prix, nu);
            }
             
            HashMap<Article, Integer> paniertemp = new HashMap<Article, Integer>();
            //System.out.println("taille : "+paniertemp.size());
            
            HttpSession session = request.getSession(true);
            
           if(session.getAttribute("panier")!=null){
               paniertemp = (HashMap<Article, Integer>)session.getAttribute("panier"); 
               //System.out.println("IF");
               System.out.println("taille : "+paniertemp.size());
           }

            paniertemp.put(a, 1);
            System.out.println("taille : "+paniertemp.size());
            
            session.setAttribute("panier", paniertemp);
         
            RequestDispatcher rd = request.getRequestDispatcher("test");
            rd.forward(request, response);
            

            
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
