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
import java.io.File;
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
public class UpdateServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        SanPhamDAO d = new SanPhamDAO();
        SanPham sp = d.getSanPhamByID(id);
        request.setAttribute("sp", sp);
        request.getRequestDispatcher("Update.jsp").forward(request, response);
    }

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
        giaban_raw = giaban_raw.replace(".", "");
        
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
            
            String dir = "D:\\JAVA\\BaiTapLon\\build\\web\\image\\";
            String dir1 = "D:\\JAVA\\BaiTapLon\\web\\image\\";
            SanPham sp = new SanPham(id, tensp, mh, cpu, ram, ocung, dohoa, hdh, trongluong, kichthuoc, xuatsu, namramat, giaban, soluong, theloai, hang, img1, img2, img3);
            SanPhamDAO d = new SanPhamDAO();
            
            d.updateSanPham(sp);
            
            if(filePart.getSize()>0){
                File file1 = new File(dir+img1);
                File file11 = new File(dir1+img1);
                file1.delete();
                file11.delete();
                filePart.write("D:\\JAVA\\BaiTapLon\\build\\web\\image\\" + img1);
                filePart.write(dir1 + img1);
            }
            
            if(filePart1.getSize()>0){
                File file2 = new File(dir+img2);
                File file22 = new File(dir1+img2);
                file2.delete();
                file22.delete();
                filePart1.write("D:\\JAVA\\BaiTapLon\\build\\web\\image\\" + img2);
                filePart1.write(dir1+img2);
            }
            
            if(filePart2.getSize()>0){
                File file3 = new File(dir+img3);
                File file33 = new File(dir1+img3);
                file3.delete();
                file33.delete();
                filePart2.write("D:\\JAVA\\BaiTapLon\\build\\web\\image\\" + img3);
                filePart2.write(dir1+img3);
            }
            
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.sendRedirect("index");
        } catch (NumberFormatException e) {
            System.out.println(e);
            HttpSession session = request.getSession();
            session.setAttribute("er", "Lỗi định dạng !!!");
            response.sendRedirect("UpdateServlet?id="+id);
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
