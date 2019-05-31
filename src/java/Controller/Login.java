/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Articoli;
import Model.User;
import Model.UserFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gznag
 */
public class Login extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("text/html;charset=UTF-8");
            
            
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            HttpSession sessione = request.getSession();
                
            User user = (User) sessione.getAttribute("user");
            
            if(user != null){
                
                sessione.invalidate();
                
                user = UserFactory.getInstance().getUser(email, password);
                ArrayList<Articoli> articoli = new ArrayList();
                articoli = user.getArticoliAll();
                articoli.sort((a,b) -> a.getData().compareTo(b.getData()));
                
                if( user.getAutore().equals("0")){
                    sessione.setAttribute("user", user);
                    sessione.setAttribute("articoli", user);
                    request.getRequestDispatcher("gestioneArticoli.jsp").forward(request, response);
                }else{
                    sessione.setAttribute("user", user);
                    sessione.setAttribute("articoli", articoli);
                    request.getRequestDispatcher("articoli.jsp").forward(request, response);
                }
            }
            user = UserFactory.getInstance().getUser(email, password);
            
            if(user != null){
                
                ArrayList<Articoli> articoli = new ArrayList();
                articoli = user.getArticoliAll();
                articoli.sort((a,b) -> a.getData().compareTo(b.getData()));
                
                sessione.setAttribute("user", user);
                sessione.setAttribute("articoli", articoli);
                
                if( user.getAutore().equals("0")){
                    response.sendRedirect("gestioneArticoli.jsp");
                }else{
                    response.sendRedirect("articoli.jsp");
                }
            }else{
                request.getRequestDispatcher("login.jsp").forward(request, response);
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
