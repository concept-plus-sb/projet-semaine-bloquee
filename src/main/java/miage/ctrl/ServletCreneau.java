/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miage.ctrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import miage.bd.AfficherCreneau;
import miage.bd.ConfirmerCommande;
import miage.bd.HibernateUtil;
import miage.metier.Article;
import miage.metier.Client;
import miage.metier.Creneau;
import miage.metier.Magasin;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Afaf
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
        
        String action = request.getParameter("action");
        HttpSession session = request.getSession(true);
        
        System.out.println("----> Coucou "+ action);
        
//        Client c = (Client)session.getAttribute("client");
//        Magasin m = c.getMagasin();
//        String id = request.getParameter(Integer.toString(m.getIdMagasin()));
        
       
        switch (action)
                {
            
            //Je viens de la page Panier et je vais vers la page Créneau
            // Je fais appel à la méthode qui m'affiche la liste des créneaux disponibles et indisponibles.
            case "afficher":

                try
                {
                    //Integer.parseInt(id)
                    request.setAttribute("liste",AfficherCreneau.afficherCreneau(1));
                    request.setAttribute("listeIndispo",AfficherCreneau.afficherCreneauINDISPO(1));

                    RequestDispatcher rd = request.getRequestDispatcher("creneau");
                    rd.forward(request, response);
                }
                catch(Exception e)
                {
                    request.setAttribute("msg_erreur", e.getMessage());
                    RequestDispatcher rd = request.getRequestDispatcher("creneau");
                    rd.forward(request, response);
                }
            break; 
            
            
            // Lorsqu'on valide le choix du créneau, on récupère le creneau et on passe 
            // dans la page confirmation
            case "valider": 
                String idradio = request.getParameter("btnradio");
                System.out.println(idradio);
                try (Session session1 = HibernateUtil.getSessionFactory().getCurrentSession())
                {
                session1.beginTransaction();
                
                Creneau cr= session1.get(Creneau.class, Integer.parseInt(idradio));
                System.out.println(cr.getIdCreneau());
                
                session.setAttribute("radio", cr.getJourSemaine()+" à "+cr.getHeureCreneau());
                RequestDispatcher rd1 = request.getRequestDispatcher("Conf");
                rd1.forward(request, response);
                }
                catch(Exception e){
                    
                    request.setAttribute("msg_erreur", e.getMessage());
                    RequestDispatcher rd = request.getRequestDispatcher("creneau");
                    rd.forward(request, response);
                }
                
            break;
            
//            Lorsqu'on annule le choix du créneau dans la page confirmation
//             On retourne dans la page créneau pour faire un autre choix.
            case "annuler":
                request.setAttribute("liste",AfficherCreneau.afficherCreneau(1));
                    request.setAttribute("listeIndispo",AfficherCreneau.afficherCreneauINDISPO(1));

                RequestDispatcher rd2 = request.getRequestDispatcher("creneau");
                rd2.forward(request, response);
            break;
            
//            Lorsqu'on confirme le créneau, on incrémente son nb de place occuppée
//             On crée la commande en BD
//             On va dans la page d'accueil (articles)
            case "confirmer": 
                 try
                {
                    int idcre = (int)session.getAttribute("radio");
                    ConfirmerCommande.ajoutPlaceOccupee(idcre);
                    
                    HashMap<Article,Integer> p = (HashMap<Article,Integer>)session.getAttribute("panier");
                    
                   // ConfirmerCommande.creerCommande(p, c);
                    
                    response.sendRedirect("articles");
                }
                catch(Exception e)
                {
                    request.setAttribute("msg_erreur", e.getMessage());
                    RequestDispatcher rd = request.getRequestDispatcher("Conf");
                    rd.forward(request, response);
                }
                
            break;
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
