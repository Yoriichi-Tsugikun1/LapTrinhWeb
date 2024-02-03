/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.SanPhamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.File;

/**
 *
 * @author Admin
 */
public class DeleteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DeleteServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DeleteServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        String idimg = id.substring(id.length() - 3);
        String img1 = String.valueOf(Integer.parseInt(idimg)) + ".jpg";
        String img2 = String.valueOf(Integer.parseInt(idimg)) + "n.jpg";
        String img3 = String.valueOf(Integer.parseInt(idimg)) + "d.jpg";

        String dir = "D:\\JAVA\\BaiTapLon\\build\\web\\image\\";
        String dir1 = "D:\\JAVA\\BaiTapLon\\web\\image\\";
        File file1 = new File(dir + img1);
        File file11 = new File(dir1 + img1);
        file1.delete();
        file11.delete();
        File file2 = new File(dir + img2);
        File file22 = new File(dir1 + img2);
        file2.delete();
        file22.delete();
        File file3 = new File(dir + img3);
        File file33 = new File(dir1 + img3);
        file3.delete();
        file33.delete();
        SanPhamDAO d = new SanPhamDAO();

        int s = d.Delete(id);
        HttpSession session = request.getSession();
        if (s == 0) {
            session.setAttribute("tbx", "Xóa không thành công! Hãy xem lại các bản ghi!");
        } else {
            session.setAttribute("tbx", "Xóa thành công!");
        }
        response.sendRedirect("index");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
