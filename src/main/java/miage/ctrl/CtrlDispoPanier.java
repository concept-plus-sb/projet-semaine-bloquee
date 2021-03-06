/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import miage.bd.AfficherCommande;
import miage.bd.ConfirmerCommande;
import miage.bd.DispoPanier;
import miage.bd.HibernateUtil;
import miage.metier.Article;
import miage.metier.Client;
import miage.metier.Creneau;
import org.hibernate.Session;

/**
 *
 * @author 21606937
 */
public class CtrlDispoPanier extends HttpServlet {

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
                HttpSession session = request.getSession(true);
                Client c = (Client)session.getAttribute("client");
                
                try{
                    HashMap<Article,Integer> p = (HashMap<Article,Integer>)session.getAttribute("panier");
                    
                    int id = (int)session.getAttribute("idmagasin");
                    System.out.println(id);
                    ArrayList<Article> dispo = DispoPanier.afficherIndispo(id, p);
                    System.out.println(dispo);
                    
                    if(dispo.isEmpty()){
                        Creneau idcre = (Creneau)session.getAttribute("creneau");

                        ConfirmerCommande.ajoutPlaceOccupee(idcre.getIdCreneau());

                        ConfirmerCommande.creerCommande(p, c, idcre);

                        session.removeAttribute("panier");
                        response.sendRedirect("CtrlListeArticles");
                    }else{
                        
                        request.setAttribute("dispo",dispo);
                        RequestDispatcher rd = request.getRequestDispatcher("DispoPanier");
                        rd.forward(request, response);
                    }
                    
                }catch(Exception e){
                    System.out.println(e.getMessage());
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
