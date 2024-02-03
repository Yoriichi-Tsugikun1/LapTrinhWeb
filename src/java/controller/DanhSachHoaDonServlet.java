/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Order;

/**
 *
 * @author Admin
 */
public class DanhSachHoaDonServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DanhSachHoaDonServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DanhSachHoaDonServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String tinhtrang_raw = request.getParameter("tinhtrang");
        String sotrang_raw = request.getParameter("sotrang");
        int tinhtrang,sotrang;
        if(tinhtrang_raw==null){
            tinhtrang = 0;
        }
        else {
            tinhtrang = Integer.parseInt(tinhtrang_raw);
        }
        if(sotrang_raw==null){
            sotrang = 1;
        }
        else {
            sotrang = Integer.parseInt(sotrang_raw);
        }
        List<Order> list = new ArrayList<>();
        OrderDAO d = new OrderDAO();
        list = d.getALLDonHang2(tinhtrang);
        int st , end;
        int size = list.size();
        st = (sotrang-1)*12;
        end = Math.min(size,sotrang*12);
        List<Order> list1 = new ArrayList<>();
        list1 = d.getSoLuong((ArrayList<Order>) list, st, end);
        request.setAttribute("sotrang", (size/12)+1);
        request.setAttribute("tinhtrang", tinhtrang);
        request.setAttribute("data", list1);
        request.getRequestDispatcher("DanhSachHoaDon.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
