//﻿/*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mycompany.mavenproject2;
//
//import com.mycompany.mavenproject2.UserRepository;
//import com.mycompany.mavenproject2.UserService;
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.inject.Inject;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet(name = "DeleteEmpireServlet", urlPatterns = {"/empireDelete"})
//public class DeleteEmpireServlet extends HttpServlet {
//    @Inject
//    UserService uService;
//    @Inject
//    UserRepository uRepository;
//    //@Inject
//    //StockRepository stockRepository;
//    
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        
//        
//        String toDeleteName = request.getParameter("id");
//        
//        if(request.getSession().getAttribute("user") != null)
//        {
//            User user = (User)request.getSession().getAttribute("user");
//            
//            Empire empireToDel = new Empire();
//            for (Empire empire : user.getEmpires()) {
//                if (empire.getName().equals(toDeleteName))
//                {
//                    empireToDel = empire;
//                    break;
//                }
//            }
//            
//            user.getEmpires().remove(empireToDel);
//          
//        }
//           request.getSession().setAttribute("stocks",stockRepository.getAll());
//        getServletContext().getRequestDispatcher("/mainPage.jsp").include(request, response);
//    }
//
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
