
package hu.oenik7.web.servlets;


import hu.oenik7.web.services.*;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "RegistrationServlet", urlPatterns = {"/reg"})
public class RegisterServlet extends HttpServlet {
    
    
    
   @Inject
    UserService userService;
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        String password = request.getParameter("pass");
        
        
        String username = request.getParameter("username");
        
        

         try {
             userService.registration(username, password);
         } catch (Exception ex) {
             response.getWriter().print("Registration not successful");
         }         
         response.sendRedirect("/mavenproject2");
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
