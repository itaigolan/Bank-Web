/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DataObject.Customer;
import DataObject.Employee;
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
@WebServlet(name = "CreateUserServlet", urlPatterns = {"/CreateUserServlet"})
public class CreateUserServlet extends HttpServlet {

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
            //Gets the first name, last name, and email from the request
            String firstName = request.getParameter("fName");
            String lastName = request.getParameter("lName");
            String email = request.getParameter("email");   
            
            //Gets which radio buttons were checked
            boolean customer = false;
            boolean employee = false;
            
            String radio = request.getParameter("employeeBox");
            if (radio != null){
                employee = true;
            }
            radio = request.getParameter("customerBox");
            if (radio != null){
                customer = true;
            }
            //Keeps information on current user
            HttpSession session = request.getSession();
            Object user = session.getAttribute("UserSession");
            session.setAttribute("UserSession",user);
            
            //Occurs if both buttons were check or neither button was checked
            if(customer == employee){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                //Refreshes the page after 5 seconds and redirects it to EmployeePage.jsp
                out.println("<meta http-equiv=\"Refresh\" content=\"5;url=EmployeePage.jsp\">");
                out.println("<head>");
                out.println("<title>CreateUserServlet</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>You must check either the Customer button or the Employee button</h1>");
                out.println("</body>");
                out.println("</html>");
            }
            else if(customer == true){
                Customer c;
                c = new Customer(firstName,lastName,email);
                session.setAttribute("Customer",c);
                
                //Prints out the Servlet page
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                //Refreshes the page after 5 seconds and redirects it to LoginPage.jsp
                out.println("<meta http-equiv=\"Refresh\" content=\"5;url=NewCustomerAddress.jsp\">");
                out.println("<head>");
                out.println("<title>CreateUserServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Enter the new customer's address</h1>");
                out.println("</body>");
                out.println("</html>");
            }
            else if(employee == true){
                Employee e;
                e = new Employee(firstName,lastName,email);
                DBInteractionModel model = new DBInteractionModel();
                model.sendToDB(e,"", "", "");
                
                //Prints out the Servlet page
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                //Refreshes the page after 5 seconds and redirects it to LoginPage.jsp
                out.println("<meta http-equiv=\"Refresh\" content=\"5;url=EmployeePage.jsp\">");
                out.println("<head>");
                out.println("<title>CreateUser</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Information for " + firstName + " " + lastName + " was successfully entered into the database</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateUserServlet.class.getName()).log(Level.SEVERE, null, ex);
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
