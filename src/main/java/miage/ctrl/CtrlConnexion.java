/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import miage.bd.SeConnecter;
import miage.metier.Client;


/**
 *
 * @author estel
 */




public class CtrlConnexion extends HttpServlet {

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
            String p_s_email = (String)request.getParameter("txtEmail");
            String p_s_mdp = (String)request.getParameter("txtMdp");
        
        //si email et mdp vide.
        if (p_s_email=="" && p_s_mdp==""){
            request.setAttribute("erreursaisie", "Le mail et le mot de passe doivent être remplis");
            RequestDispatcher rd = request.getRequestDispatcher("Connexion");
            rd.forward(request, response);
        
        //si email vide et pas mdp.
        } else if (p_s_email=="" && p_s_mdp!=""){
            request.setAttribute("erreursaisie", "Le mail doit être rempli");
            RequestDispatcher rd = request.getRequestDispatcher("Connexion");
            rd.forward(request, response);
            
        //si mdp vide et pas email.
        } else if (p_s_email!="" && p_s_mdp==""){
            request.setAttribute("erreursaisie", "Le mot de passe doit être rempli");
            RequestDispatcher rd = request.getRequestDispatcher("Connexion");
            rd.forward(request, response);
        
        //si mdp et email rempli.
        } else {
                boolean p_b_result;
                
                try {
                    
                    p_b_result = SeConnecter.verifierConnexion(p_s_email, p_s_mdp);
                    
                    //si mdp et email valide.
                    if(p_b_result==true){
                        Client p_c_client=SeConnecter.recupClient(p_s_email, p_s_mdp);
                    
                        //Création session.
                        HttpSession session = request.getSession(true);
                        session.setAttribute("client", p_c_client);
                    
                        //Rediriger vers la page articles
                        RequestDispatcher rd = request.getRequestDispatcher("CtrlListeArticles");
                        rd.forward(request, response);
                
                    //Si mpp et email non valide.
                    } else {
                        request.setAttribute("erreur",
                            "Le mot de passe et/ou le mail incorrect(s)");
                        RequestDispatcher rd = request.getRequestDispatcher("Connexion");
                        rd.forward(request, response);
                    }
                    
                } catch (Exception ex) {
                    request.setAttribute("erreur", ex.getMessage());
                RequestDispatcher rd = request.
                        getRequestDispatcher("Connexion");
                rd.forward(request, response); 
                }
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
