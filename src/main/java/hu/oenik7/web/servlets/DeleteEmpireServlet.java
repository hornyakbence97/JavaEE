
package hu.oenik7.web.servlets;

import hu.oenik7.web.bl.*;
import hu.oenik7.web.services.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "DeleteEmpireServlet", urlPatterns = {"/deleteEmpire"})
public class DeleteEmpireServlet extends HttpServlet {

    @Inject
    SpeciesRepository sepeciesRepository;

    @Inject
    EmpireService empireService;
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        Long empireID  = Long.parseLong(request.getParameter("empireid"));
        
        
        User user = ((User) request.getSession().getAttribute("user"));
        
        
        try {
            user.removeEmpire(empireID);
            empireService.removeEmpire(empireID);
        } catch (Exception ex) {
         response.getWriter().print(ex);
        }        
        
        request.setAttribute("heroes", user.getHeroes());
        
        
        request.setAttribute("empires", user.getEmpires());
        
        
        request.setAttribute("species", sepeciesRepository.getSpecies());
        
        
        getServletContext().getRequestDispatcher("/MainPage.jsp").include(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
