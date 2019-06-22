/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DataObject.Customer;
import Model.DBInteractionModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author itaig
 */
@WebServlet(name = "CreateCustomerServlet", urlPatterns = {"/CreateCustomerServlet"})
public class CreateCustomerServlet extends HttpServlet {

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
            //Gets Address pieces
            String address = request.getParameter("address") + ","
                    + request.getParameter("city") + ","
                    + request.getParameter("state") + ","
                    + request.getParameter("zipCode");
            
            //Keeps information on current user
            HttpSession session = request.getSession();
            Object user = session.getAttribute("UserSession");
            session.setAttribute("UserSession",user);
            
            //Retrieves new customer
            Customer c = (Customer)session.getAttribute("Customer");
            //Sets the address of the customer
            c.setAddress(address);
            
            //Gets if SyncBox is checked
            boolean syncCustomer = false;
            String radio = request.getParameter("SyncBox");
            if (radio != null){
                syncCustomer = true;
            }
            
            DBInteractionModel model = new DBInteractionModel();
            if(syncCustomer){
                
            }
            else{
                try {
                    model.sendToDB(c,"jdbc:mysql://localhost:3306/quintrixbankdb", "root", "mysql");
                } catch (SQLException ex) {
                    Logger.getLogger(CreateCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddressServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddressServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
