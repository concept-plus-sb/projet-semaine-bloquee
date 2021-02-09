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
 * @author 21606937
 */
public class NewServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //create new session
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */ 
            HttpSession session=request.getSession(true);
            HashMap<Article,Integer> panier= new HashMap<Article,Integer>();
            MarqueA marquea = new MarqueA(10, "mark 1");
            MarqueA marqueb = new MarqueA(11, "mark 2");
            SousFamille sf1=new SousFamille("sous famille 1");
            SousFamille sf2=new SousFamille("sous famille 2");
            PrixVente prix1 = new PrixVente(1.2f);
            PrixVente prix2 = new PrixVente(1.63f);
            Nutriscore nu1= new Nutriscore(14, "nutriscore 1", "description 1");
            Nutriscore nu2= new Nutriscore(15, "nutriscore 2", "description 2");
            Article a1 = new Article(2, "Biscuits bio aux céréales", 0, "g", "kg", EnumStockage.normal, 0, 
                    "france", "composition", "Carrefour", sf1, marquea, prix1, nu1);
            Article a2 = new Article(3, "Sauce Pesto Rosso", 200, "g", "kg", EnumStockage.normal, 0, 
                    "france", "composition", "Barilla", sf2, marqueb, prix2, nu2);
            panier.put(a1,2);
            panier.put(a2,1);
            session.setAttribute("panier",panier);
            RequestDispatcher rd = request.getRequestDispatcher("gotopaniertemp");
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
