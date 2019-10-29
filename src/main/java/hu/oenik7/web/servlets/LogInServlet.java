
package hu.oenik7.web.servlets;



import hu.oenik7.web.bl.*;
import hu.oenik7.web.services.*;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LogInServlet extends HttpServlet {

    @Inject
    UserService userService;

    @Inject
    SpeciesRepository speciesRepository;



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String password = request.getParameter("pass");
        
        
        String username = request.getParameter("name");

        try {
            User user = userService.login(username, password);
            
         
            request.getSession().setAttribute("user", user);
            
            
            request.setAttribute("heroes", user.getHeroes());
            
            
            request.setAttribute("empires", user.getEmpires());
            
            
            request.setAttribute("species", speciesRepository.getSpecies());


            getServletContext().getRequestDispatcher("/MainPage.jsp").include(request, response);


            
        } catch (LoginException ex) {
      
            response.getWriter().print("Invalid username or password");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
