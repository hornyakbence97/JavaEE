
package hu.oenik7.web.servlets;

import hu.oenik7.web.bl.*;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "deleteHeroServlet", urlPatterns = {"/deleteHero"})
public class DeleteHeroServlet extends HttpServlet {
   
    @Inject
    SpeciesRepository speciesRepository;

    @Inject
    HeroRepository heroRepository;
    
    @Inject
    UserRepository userRepository;
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        
        Long heroId = Long.parseLong( request.getParameter("heroid"));
        
        
        User user = ((User) request.getSession().getAttribute("user"));
        
        
        try {
            user.removeHero(heroId);
        } catch (Exception ex) {
          
        }
        heroRepository.remove(heroId);
        
        
        request.setAttribute("heroes", user.getHeroes());
        
        
        request.setAttribute("empires", user.getEmpires());
        
        
        request.setAttribute("species", speciesRepository.getSpecies());
        
        
        getServletContext().getRequestDispatcher("/MainPage.jsp").include(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
