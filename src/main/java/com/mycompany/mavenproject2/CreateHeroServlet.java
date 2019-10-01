package com.mycompany.mavenproject2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HeroServlet", urlPatterns = {"/heroCreate"})
public class CreateHeroServlet extends HttpServlet {

    @Inject
    UserService userService;
    @Inject
    HeroService heroService;
    @Inject
    SpeciesRepository speciesRepository;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Hero hero = new Hero();
        hero.setName(request.getParameter("name"));
        hero.setDescription(request.getParameter("description"));
        
        for (Species specie : speciesRepository.getAll()) {
            String tmpName = request.getParameter("specie_" + specie.getId());
            Integer tmpPercentage = Integer.parseInt(request.getParameter("specie_" + specie.getId()));
            
            if (tmpPercentage > 0)
            {
                hero.getHibryds().add(new Hibryd(specie, tmpPercentage));
            }
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
                if (heroService.isValid(hero)) {
            ((User) request.getSession().getAttribute("user")).getHeroes().add(hero);
            request.setAttribute("species", speciesRepository.getAll());
            getServletContext().getRequestDispatcher("/mainPage.jsp").include(request, response);
        } else {
            out.print("nem valid a config");
        }

        //Enumeration<String> params = request.getParameterNames();

        /*        while (params.hasMoreElements()) {
        String nextElement = params.nextElement();
        if (nextElement.startsWith("pspec_") && Integer.parseInt(request.getParameter(nextElement)) > 0) {
        int speciesID = Integer.parseInt(nextElement.substring(6));
        Hibryd hibryd = new Hibryd(sRepository.getById(speciesID), Byte.parseByte(request.getParameter(nextElement)));
        hero.getHibryds().add(hibryd);
        }
        }*/

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
