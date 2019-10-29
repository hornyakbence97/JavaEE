
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



@WebServlet(name = "manageEmpireServlet", urlPatterns = {"/manageEmpire"})
public class EmpireServlet extends HttpServlet {

    @Inject
    EmpireService empireService;
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        Long empireID  = Long.parseLong(request.getParameter("empireid"));
        User user = ((User) request.getSession().getAttribute("user"));

        Empire emp = empireService.getEmpire(empireID);
        
        request.setAttribute("selectedEmpire", emp);

        getServletContext().getRequestDispatcher("/empireEdit.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
