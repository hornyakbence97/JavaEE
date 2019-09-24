package com.mycompany.mavenproject2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HeroServlet", urlPatterns = {"/hero"})
public class HeroServlet extends HttpServlet {

    UserService uService = new UserService();
    HeroService hService = new HeroService();
    SpeciesRepository sRepository = new SpeciesRepository();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Hero hero = new Hero();
        hero.setName(request.getParameter("name"));
        hero.setDescription(request.getParameter("description"));

        Enumeration<String> params = request.getParameterNames();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        while (params.hasMoreElements()) {
            String nextElement = params.nextElement();
            if (nextElement.startsWith("pspec_") && Integer.parseInt(request.getParameter(nextElement)) > 0) {
                int speciesID = Integer.parseInt(nextElement.substring(6));
                Hibryd hibryd = new Hibryd(sRepository.getById(speciesID), Byte.parseByte(request.getParameter(nextElement)));
                hero.getHibryds().add(hibryd);
            }
        }
        if (hService.isValid(hero)) {
            ((User) request.getSession().getAttribute("user")).getHeroes().add(hero);
            request.setAttribute("species", sRepository.getAll());
            getServletContext().getRequestDispatcher("/newhero.jsp").include(request, response);
        } else {
            out.print("nem valid a config");
        }

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
