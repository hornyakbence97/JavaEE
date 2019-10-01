package com.mycompany.mavenproject2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @Inject
    UserService uService;
    @Inject
    UserRepository uRepository;
    @Inject
    SpeciesRepository sRepository;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        User login = new User(request.getParameter("name"), request.getParameter("password"));
        PrintWriter out = response.getWriter();
        if(uService.isExists(login)) {
            request.setAttribute("species",sRepository.getAll());
            request.getSession().setAttribute("user", uRepository.getByName(login.getName()) );
            getServletContext().getRequestDispatcher("/mainPage.jsp").include(request, response);
        }
        else     out.print("Regisztráció szükséges");
        
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
