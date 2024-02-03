/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.SanPhamDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.SanPham;

/**
 *
 * @author Admin
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class ThemSanPhamServlet extends HttpServlet {

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
            out.println("<title>Servlet ThemSanPhamServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ThemSanPhamServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SanPhamDAO d = new SanPhamDAO();
        int sl = d.getSoLuongSanPham();
        String masp = "SP" + String.format("%03d", sl + 1);
        request.setAttribute("masp", masp);
        request.getRequestDispatcher("ThemSanPham.jsp").forward(request, response);
    }

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
        String id = request.getParameter("id");
        String tensp = request.getParameter("tensp");
        String giaban_raw = request.getParameter("giaban");
        String soluong_raw = request.getParameter("soluong");
        String theloai = request.getParameter("theloai");
        String hang = request.getParameter("hang");
        Part filePart = request.getPart("file");
        Part filePart1 = request.getPart("file1");
        Part filePart2 = request.getPart("file2");
        String mh = request.getParameter("mh");
        String cpu = request.getParameter("cpu");
        String ram = request.getParameter("ram");
        String ocung = request.getParameter("ocung");
        String dohoa = request.getParameter("dohoa");
        String hdh = request.getParameter("hdh");
        String trongluong = request.getParameter("trongluong");
        String kichthuoc = request.getParameter("kichthuoc");
        String xuatsu = request.getParameter("xuatsu");
        String namramat_raw = request.getParameter("namramat");
        Double giaban;
        int soluong, namramat;
        try {
            giaban = Double.parseDouble(giaban_raw);
            soluong = Integer.parseInt(soluong_raw);
            namramat = Integer.parseInt(namramat_raw);
            String idimg = id.substring(id.length() - 3);
            String img1 = String.valueOf(Integer.parseInt(idimg)) + ".jpg";
            String img2 = String.valueOf(Integer.parseInt(idimg)) + "n.jpg";
            String img3 = String.valueOf(Integer.parseInt(idimg)) + "d.jpg";
            SanPham sp = new SanPham(id, tensp, mh, cpu, ram, ocung, dohoa, hdh, trongluong, kichthuoc, xuatsu, namramat, giaban, soluong, theloai, hang, img1, img2, img3);
            SanPhamDAO d = new SanPhamDAO();
            d.insertSanPham(sp);
            filePart.write("D:\\JAVA\\BaiTapLon\\build\\web\\image\\" + img1);
            filePart1.write("D:\\JAVA\\BaiTapLon\\build\\web\\image\\" + img2);
            filePart2.write("D:\\JAVA\\BaiTapLon\\build\\web\\image\\" + img3);
            filePart.write("D:\\JAVA\\BaiTapLon\\web\\image\\" + img1);
            filePart1.write("D:\\JAVA\\BaiTapLon\\web\\image\\" + img2);
            filePart2.write("D:\\JAVA\\BaiTapLon\\web\\image\\" + img3);
            response.sendRedirect("index");
        } catch (NumberFormatException e) {
            HttpSession session = request.getSession();
            session.setAttribute("er", "Lỗi định dạng !!!");
            response.sendRedirect("ThemSanPhamServlet");
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
