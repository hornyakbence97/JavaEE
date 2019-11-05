
package hu.oenik7.web.servlets;


import hu.oenik7.web.bl.*;
import hu.oenik7.web.empire.Empire;
import hu.oenik7.web.services.*;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
;


@WebServlet(name = "newBuildingServlet", urlPatterns = {"/newBuilding"})
public class CreateNewBuildingServlet extends HttpServlet {

    
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
        String buildType = request.getParameter("buildinglist");
        Long e = Long.parseLong(request.getParameter("empireid"));

        empireService.addBuilding(e, buildType);
        Empire emp = empireService.getEmpire(e);
        request.setAttribute("selectedEmpire", emp);
        getServletContext().getRequestDispatcher("/empireEdit.jsp").include(request, response);  
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
