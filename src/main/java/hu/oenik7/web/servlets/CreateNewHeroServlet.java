
package hu.oenik7.web.servlets;


import hu.oenik7.web.bl.HeroRepository;
import hu.oenik7.web.bl.SpeciesRepository;
import hu.oenik7.web.bl.*;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "HeroServlet", urlPatterns = {"/newHero"})
public class CreateNewHeroServlet extends HttpServlet {


    @Inject
    HeroRepository heroesRepository;

    @Inject
    SpeciesRepository speciesRepository;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        User user = ((User) request.getSession().getAttribute("user"));
        
        
        Hero hero = new Hero(request.getParameter("name"), request.getParameter("desc"),user);
        
        
        for (Species specie : speciesRepository.getSpecies()) {

            try {
                Byte b = Byte.parseByte(request.getParameter("specie_"+specie.getName()));
                Hybrid newHybrid = new Hybrid(specie, b);
                hero.getHybrids().add(newHybrid);

            } catch (Exception ex) {
            }

        }

        user.getHeroes().add(hero);
        
        
        heroesRepository.add(hero);
        
        
        request.setAttribute("heroes", user.getHeroes());
        
        
        request.setAttribute("empires", user.getEmpires());
        
        
        request.setAttribute("species", speciesRepository.getSpecies());

                  
        getServletContext().getRequestDispatcher("/MainPage.jsp").include(request, response);
        
    }
}
