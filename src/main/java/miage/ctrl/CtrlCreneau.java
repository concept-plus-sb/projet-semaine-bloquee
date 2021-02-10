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
public class CtrlCreneau extends HttpServlet {

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
        
        Client c = (Client)session.getAttribute("client");
        Magasin m = c.getMagasin();
        int id = c.getMagasin().getIdMagasin();
       
        
        switch (action)
                {
            
            //Je viens de la page Panier et je vais vers la page Créneau
            // Je fais appel à la méthode qui m'affiche la liste des créneaux disponibles et indisponibles.
            case "afficher":

                try
                {
                    
                    request.setAttribute("liste",AfficherCreneau.afficherCreneau(id));
                    request.setAttribute("listeIndispo",AfficherCreneau.afficherCreneauINDISPO(id));

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
                
                
                    if(idradio == null){
                        request.setAttribute("liste",AfficherCreneau.afficherCreneau(1));
                        request.setAttribute("listeIndispo",AfficherCreneau.afficherCreneauINDISPO(1));
                        RequestDispatcher rd1 = request.getRequestDispatcher("creneau");
                        rd1.forward(request, response);  
                    }else{
                        session1.beginTransaction();
                        Creneau cr= session1.get(Creneau.class, Integer.parseInt(idradio));
                        session.setAttribute("radio", cr.getJourSemaine()+" à "+cr.getHeureCreneau());
                        RequestDispatcher rd1 = request.getRequestDispatcher("conf");//PB
                        rd1.forward(request, response);  
                    }
                }
                catch(Exception e){
                    
                    request.setAttribute("msg_erreur", e.getMessage());
                    request.setAttribute("liste",AfficherCreneau.afficherCreneau(1));
                    request.setAttribute("listeIndispo",AfficherCreneau.afficherCreneauINDISPO(1));
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
                    System.out.println("TEST");
                    int idcre = (int)session.getAttribute("radio");
                    System.out.println(idcre);
                    ConfirmerCommande.ajoutPlaceOccupee(idcre);
                    System.out.println("TEST2");
                    
                    HashMap<Article,Integer> p = (HashMap<Article,Integer>)session.getAttribute("panier");
                    System.out.println(p);
                    ConfirmerCommande.creerCommande(p, c);
                    System.out.println("TEST3");
                    response.sendRedirect("newArticles");
                }
                catch(Exception e)
                {
                    request.setAttribute("msg_erreur", e.getMessage());
                    RequestDispatcher rd = request.getRequestDispatcher("conf");
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
