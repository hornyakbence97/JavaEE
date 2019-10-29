
package hu.oenik7.web.servlets;


import hu.oenik7.web.bl.*;
import hu.oenik7.web.empire.*;
import hu.oenik7.web.services.*;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "newEmpireServlet", urlPatterns = {"/newEmpire"})
public class CreateNewEpireServlet extends HttpServlet {

    @Inject
    SpeciesRepository speciesRepository;
    
    @Inject
    PeopleRepository peopleRepository;
    
    @Inject
    NaturalAssetRepository naturalAssetRepository; 
    
    @Inject
    EmpireRepository empireRepository;
    
    @Inject 
    EmpireService empireService;
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        User user = ((User)request.getSession().getAttribute("user"));
        
        
        String name = request.getParameter("name");
        
        
        String description = request.getParameter("desc");
        

        
        
        empireService.addEmpire(name, description,user);
        
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
