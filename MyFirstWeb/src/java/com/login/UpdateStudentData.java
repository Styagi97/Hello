/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.login;

import com.google.gson.Gson;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
@WebServlet(name = "UpdateStudentData", urlPatterns = {"/UpdateStudentData"})
public class UpdateStudentData extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    ResultSet rs = null;
    Connection con = null;
    PreparedStatement st = null;
    Gson gson = new Gson();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        //   PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        System.out.println(id);

        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "shiv@123");
//      
//            String inputLine;
//            StringBuilder resp = new StringBuilder();
//            while ((inputLine = br.readLine()) != null) {
//                resp.append(inputLine);
//            } 
        String query = " UPDATE " + "mydb.speaker" + " SET ";
        StringBuilder strbuilder = new StringBuilder();
        Map<String, String> params = new HashMap<>();
        Enumeration<String> parameters = request.getParameterNames();
        while (parameters.hasMoreElements()) {
            String key = parameters.nextElement();
            String value = request.getParameter(key);
            value = value == null ? "" : value;
            params.put(key, value);
        }
        for (Map.Entry<String, String> e : params.entrySet()) {
            strbuilder.append(e.getKey()).append("='").append(e.getValue()).append("',");
          }
        if (strbuilder.length() > 0) {
            query = query + strbuilder.substring(0, strbuilder.length() - 1);
        }
        query = query + " where id =" + id + ";";        // inputList.add(recordId);
        System.out.println(query);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shivdb", "root", "shiv@123");

            st = con.prepareStatement(query);

            int count = st.executeUpdate();
            if (count == 1) {
                out.println("Record Updated Successfully");

            } else {
                out.println("Record not Updated");
            }
            System.out.println("insert" + count);
            RequestDispatcher dispatcher =request.getRequestDispatcher("EditStudent.html");
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateStudentData.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UpdateStudentData.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UpdateStudentData.class.getName()).log(Level.SEVERE, null, ex);
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
