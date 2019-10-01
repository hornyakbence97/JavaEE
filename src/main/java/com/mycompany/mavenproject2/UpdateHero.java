/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hornyák Bence
 */
@WebServlet(name = "UpdateHero", urlPatterns = {"/heroUpdate"})
public class UpdateHero extends HttpServlet {

    @Inject
    UserService userService;
    @Inject
    HeroService heroService;
    @Inject
    SpeciesRepository speciesRepository;
        @Inject
    UserRepository uRepository;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String toUpdateName = request.getParameter("id");
        User user = new User();
        if(request.getSession().getAttribute("user") != null)
        {
            user = (User)request.getSession().getAttribute("user");
            
            Hero heroToUpd = new Hero();
            for (Hero hero : user.getHeroes()) {
                if (hero.getName().equals(toUpdateName))
                {
                    heroToUpd = hero;
                    break;
                }
            }
            
            request.getSession().setAttribute("currentHero", heroToUpd);
        }
        request.getSession().setAttribute("species",speciesRepository.getAll());
        request.getSession().setAttribute("user", uRepository.getByName(user.getName()) );
        getServletContext().getRequestDispatcher("/updateHero.jsp").include(request, response);
    }
    
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
        //response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
                if (heroService.isValid(hero)) {
                    List<Hero> heroes = new ArrayList<Hero>();
                    User user = ((User) request.getSession().getAttribute("user"));
                    for (Hero cHero : user.getHeroes()) {
                        if (cHero.getName().equals(hero.getName()))
                        {
                        }
                        else
                        {
                            heroes.add(cHero);
                        }
                    }
                    
            heroes.add(hero);
            user.setHeroes(heroes);
            request.setAttribute("species", speciesRepository.getAll());
            request.getSession().setAttribute("user", user);
            getServletContext().getRequestDispatcher("/mainPage.jsp").include(request, response);
        } else {
            out.print("nem valid a config");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
