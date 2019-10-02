//package com.mycompany.mavenproject2;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Enumeration;
//import javax.inject.Inject;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@WebServlet(name = "EmpireServlet", urlPatterns = {"/empireCreate"})
//public class CreateEmpireServlet extends HttpServlet {
//
//    @Inject
//    EmpireService empireService;
//    @Inject
//    EmpireService empireService;
//    @Inject
//    StockRepository stockRepository;
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        Empire empire = new Empire();
//        empire.setName(request.getParameter("name"));
//        empire.setDescription(request.getParameter("description"));
//        
//        for (Stock stock : stockRepository.getAll()) {
//            String tmpName = request.getParameter("stock_" + stock.getId());
//            Integer tmpQuantity = Integer.parseInt(request.getParameter("stock_" + stock.getId()));
//            
//            //if (tmpStock > 0)
//            //{
//                empire.getWarehause().add(new NaturalAsset(stock, (long)tmpQuantity));
//            //}
//        }
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        
//                if (empireService.isValide(empire)) {
//            ((User) request.getSession().getAttribute("user")).getEmpire().add(empire);
//            request.setAttribute("stock", stockRepository.getAll());
//            getServletContext().getRequestDispatcher("/mainPage.jsp").include(request, response);
//        } else {
//            out.print("nem valid a config");
//        }
//
//    }
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
