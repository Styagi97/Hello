/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.login;

import com.google.gson.Gson;
import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
@WebServlet(name = "EditStudent", urlPatterns = {"/EditStudent"})
public class EditStudent extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String SELECT_ALL_USERS = "SELECT * FROM shivdb.login_details where id =?";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String id = request.getParameter("id");
        PrintWriter out = response.getWriter();
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement st = null;
        Gson gson = new Gson();
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shivdb", "root", "shiv@123");

            st = con.prepareStatement(SELECT_ALL_USERS);

            st.setString(1, id);
            rs = st.executeQuery();

            List<Map<String, String>> list = resolveResultSet(rs);
            System.out.println("list :: " + list.toString());
            out.write(gson.toJson(list));
 
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.append(e.getMessage());
        } finally {
            out.close();
            try {
                if (st != null) {
                    st.close();
                    st = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Map<String, String>> resolveResultSet(ResultSet resultSet) throws ClassNotFoundException, SQLException {
        ArrayList<Map<String, String>> data = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Map<String, String> hashmap = new HashMap();
                for (int count = 0; count < resultSet.getMetaData().getColumnCount(); count++) {
                    if (resultSet.getString(count + 1) == null) {
                        hashmap.put(resultSet.getMetaData().getColumnLabel(count + 1), "");
                    } else {
                        hashmap.put(resultSet.getMetaData().getColumnLabel(count + 1), resultSet.getString(count + 1));
                    }
                }
                data.add(hashmap);
            }
        } catch (SQLException e) {
        }
        return data;

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
        processRequest(request, response);
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
