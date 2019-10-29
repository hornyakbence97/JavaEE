
package hu.oenik7.web.servlets;


import hu.oenik7.web.bl.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "modHeroServlet", urlPatterns = {"/modHero"})
public class ModifyHeroServlet extends HttpServlet {

    @Inject
    SpeciesRepository speciesRepository;
    @Inject
    HeroRepository heroRepository;
    @Inject
    UserRepository userRepository;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User user = ((User) request.getSession().getAttribute("user"));

        Long heroId  =Long.parseLong(request.getParameter("heroid"));
        
        
        Hero selectedHero =heroRepository.getHero(heroId);
        
        
        request.setAttribute("selectedHero", selectedHero);
        

        List<Hybrid> selectionHybrids = new ArrayList<>();
        

        for (Species specie : speciesRepository.getSpecies()) {
            selectionHybrids.add(new Hybrid(specie, (byte) 0));
        }

        for (Hybrid selection : selectionHybrids) {
            
            for (Hybrid hero : selectedHero.getHybrids()) {
                
                if (selection.getSpecies().getName().equals(hero.getSpecies().getName())) {
                    
                    selection.setPercent(hero.getPercent());
                    
                }
            }
        }
        request.setAttribute("hybrids", selectionHybrids);
        
        getServletContext().getRequestDispatcher("/heroEdit.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        
        Long heroID = Long.parseLong(request.getParameter("heroid"));
        
        
        String heroName = request.getParameter("heroname");
        
        
        String desc = request.getParameter("desc");
        
        
        User sessUser = ((User) request.getSession().getAttribute("user"));
        

        List<Hybrid> heroHybrids = new ArrayList<>();
        

        for (Species specie : speciesRepository.getSpecies()) {
            try {
                
                Byte percent = Byte.parseByte(request.getParameter(specie.getName()));
                
                if (percent > 0) {
                    heroHybrids.add(new Hybrid(specie, percent));
                }

            } catch (Exception ex) {
              
            }

        }
        Hero moddedHero = heroRepository.getHero(heroID);
        
        
        moddedHero.setDescription(desc);
        
        
        moddedHero.setHybrids(heroHybrids);
        
        
        heroRepository.update(moddedHero);
        
        
      
        
        request.setAttribute("heroes",sessUser.getHeroes() );
        
        
        request.setAttribute("empires",sessUser.getEmpires() );
        
        
        request.setAttribute("species",speciesRepository.getSpecies());   

        
        getServletContext().getRequestDispatcher("/MainPage.jsp").include(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
