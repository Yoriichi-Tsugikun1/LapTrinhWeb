/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UpFile", urlPatterns = {"/upfile"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class UpFile extends HttpServlet {

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
            out.println("<title>Servlet UpFile</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpFile at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
//        Part filePart = request.getPart("file1");

//        String fileName = filePart.getSubmittedFileName();
//        String fileName = "aa.jpg";
//        filePart.delete();
//        String filePath = "C:\\upload\\" + fileName;
//        try {
//            // Create a Path object representing the file
//            Path fileToDelete = Paths.get(filePath);
//
//            // Use Files.delete() to delete the file
//
//            System.out.println("File deleted successfully.");
//
//        } catch (IOException e) {
//            // Handle the exception, e.g., log it or print a message
//            System.err.println("Error deleting the file: " + e.getMessage());
//        }
//        for (Part part : request.getParts()) {
//            part.write("D:\\JAVA\\BaiTapLon\\build\\web\\image\\" + fileName);
//            filePart.write("C:\\upload\\"+fileName);
//        }
//        filePart.write("D:\\JAVA\\BaiTapLon\\build\\web\\image\\" + fileName);
        Part filePart = request.getPart("file1");
        String fileName = "aa.jpg"; // Replace this with the actual file name or get it from the Part object if needed

// Specify the directory where the file is stored
        String uploadDir = "C:\\upload\\"; // Replace with your actual upload directory

        try {
           
            File fileToDelete = new File(uploadDir + fileName);

           
            if (fileToDelete.exists()) {
                // Attempt to delete the file
                if (fileToDelete.delete()) {
                    System.out.println("File deleted successfully.");
                } else {
                    System.out.println("Failed to delete the file.");
                }
            } else {
                System.out.println("File does not exist.");
            }
        } catch (Exception e) {
            // Handle exceptions, such as IOException
            e.printStackTrace();
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
