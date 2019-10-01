package com.mycompany.mavenproject2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegServlet", urlPatterns = {"/reg"})
public class RegServlet extends HttpServlet {
    @Inject    
    UserRepository uRepo;
    @Inject
    UserService uService;
    @Inject
    SpeciesRepository speciesRepo;

   

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        User reg;
        PrintWriter out = response.getWriter();
        if (uService.isExists(request.getParameter("name"))) {
            out.print("User name exists!");
        } else {
            reg = new User(request.getParameter("name"), request.getParameter("password"));
            uRepo.add(reg);
            
            response.setContentType("text/html;charset=UTF-8");
             request.setAttribute("species",speciesRepo.getAll());
            request.getSession().setAttribute("user", uRepo.getByName(reg.getName()) );
            getServletContext().getRequestDispatcher("/mainPage.jsp").include(request, response);
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
