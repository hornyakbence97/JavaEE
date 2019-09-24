package com.mycompany.mavenproject2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegServlet", urlPatterns = {"/reg"})
public class RegServlet extends HttpServlet {
        UserRepository uRepo = new UserRepository();
        UserService uService = new UserService();

   

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


        PrintWriter out = response.getWriter();
        if (uService.isExists(request.getParameter("name"))) {
            out.print("User name exists!");
        } else {
            User reg = new User(request.getParameter("name"), request.getParameter("password"));
            uRepo.add(reg);
        }

        response.setContentType("text/html;charset=UTF-8");
        for (User user : uRepo.getAll()) {
            out.print(user.getName().concat("<br>"));
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
