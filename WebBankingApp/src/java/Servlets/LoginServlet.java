package Servlets;

import DataObject.Customer;
import DataObject.Employee;
import Model.LoginModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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
            
            //Gets the login id and password from the request
            int id = Integer.parseInt(request.getParameter("id"));  
            String password=request.getParameter("password");  
            
            LoginModel model = new LoginModel();
            String loginResponse;
            
            try {
                loginResponse = model.login(id, password);
            } catch (SQLException ex) {
                loginResponse = "Was unable to connect to the database.";
            }
            
            //Session will be put in reponse when page is redirected
            HttpSession session = request.getSession();
            
            switch(loginResponse){
                case "customer":
                    Customer customer = new Customer(id);
                    //Creates UserSession with user object
                    session.setAttribute("UserSession", customer);
                    //Redirects customers to the customer page
                    response.sendRedirect("CustomerPage.jsp");
                    break;
                case "employee":
                    Employee employee = new Employee(id);
                    //Creates UserSession with user object
                    session.setAttribute("UserSession", employee);
                    //Redirects employees to the employee page
                    response.sendRedirect("EmployeePage.jsp");
                    break;
                //Prints the loginResponse if an error occured
                default:
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    //Refreshes the page after 5 seconds and redirects it to LoginPage.jsp
                    out.println("<meta http-equiv=\"Refresh\" content=\"5;url=LoginPage.jsp\">");
                    out.println("<head>");
                    out.println("<title>LoginServlet</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>" + loginResponse + "</h1>");
                    out.println("</body>");
                    out.println("</html>");
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
