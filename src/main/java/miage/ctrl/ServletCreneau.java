/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.ctrl;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import miage.bd.Bd;
import miage.metier.Creneau;

/**
 *
 * @author 21606937
 */
public class ServletCreneau extends HttpServlet {

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
        String id = request.getParameter("idM"); // A récupérer comment? 
        
//        try ( PrintWriter out = response.getWriter()) {
//            /*----- Ecriture de la page XML -----*/
//			out.println("<?xml version=\"1.0\"?>");
//			out.println("<liste_creneaux>");
//
//			/*----- Récupération des paramètres -----*/
//			String id = request.getParameter("idM");
//                       
//			try {
//                            ArrayList<String> creneaux = Bd.afficherCreneau(Integer.parseInt(id));
//                            
//                            for (String m: creneaux){
//                                out.println("<creneau><![CDATA[" + m + "]]></creneau>");
//                            }
//                        }
//			catch (ClassNotFoundException | SQLException ex)
//				{
//                                    out.println("<creneau>Erreur - " + ex.getMessage() + "</creneau>");
//				}
//
//			out.println("</liste_creneaux>");
//        }
        try
            {
                
//                List<Creneau> l = Bd.afficherCreneau(Integer.parseInt(id));
//                 for(Creneau c: l){
//                                System.out.println(c.getHeureCreneau());
//                            }
                // affichage
                //request.setAttribute("liste",Bd.afficherCreneau(1));
//                System.out.println("Je suis ici !");
//                for(Creneau c : Bd.afficherCreneau(1))
//                    System.out.println("--> " + c.getHeureCreneau()+" le "+c.getJourSemaine());
//                request.setAttribute("liste", "Ceci est un test !");
               // Il faudrait déclarer une array list de msg d'or et faire un bd.lire mais la on va directement le mettre dans la variable

                RequestDispatcher rd = request.getRequestDispatcher("creneau");
                rd.forward(request, response);
            }
            catch(Exception e)
            {
                request.setAttribute("msg_erreur", e.getMessage());
                RequestDispatcher rd = request.getRequestDispatcher("creneau");
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
