/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "DeleteHeroServlet", urlPatterns = {"/heroDelete"})
public class DeleteHeroServlet extends HttpServlet {
    @Inject
    UserService uService;
    @Inject
    UserRepository uRepository;
    @Inject
    SpeciesRepository sRepository;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String toDeleteName = request.getParameter("id");
        
        if(request.getSession().getAttribute("user") != null)
        {
            User user = (User)request.getSession().getAttribute("user");
            
            Hero heroToDel = new Hero();
            for (Hero hero : user.getHeroes()) {
                if (hero.getName().equals(toDeleteName))
                {
                    heroToDel = hero;
                    break;
                }
            }
            
            user.getHeroes().remove(heroToDel);
          
        }
           request.getSession().setAttribute("species",sRepository.getAll());
        getServletContext().getRequestDispatcher("/mainPage.jsp").include(request, response);
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
