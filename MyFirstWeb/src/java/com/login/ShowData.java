/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.login;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

/**
 *
 * @author admin
 */
@WebServlet(name = "ShowData", urlPatterns = {"/ShowData"})
public class ShowData extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static final String SELECT_ALL_USERS = "SELECT * FROM shivdb.login_details";

    @SuppressWarnings("CallToPrintStackTrace")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try {
            Gson gson = new Gson();
            Connection con = null;
            PreparedStatement st = null;
            PrintWriter out = response.getWriter();
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");

                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shivdb", "root", "shiv@123");

                st = con.prepareStatement(SELECT_ALL_USERS);
                // st = con.prepareStatement("SELECT * FROM shivdb.login_details");
                ResultSet rs = st.executeQuery();
                JsonArray arr = new JsonArray();
                JsonObject ob = new JsonObject();

                while (rs.next()) {

                    ob = new JsonObject();
                    ob.addProperty("Id", rs.getString("id"));
                    ob.addProperty("FirstName", rs.getString("FirstName"));
                    ob.addProperty("LastName", rs.getString("LastName"));
                    ob.addProperty("EmailID", rs.getString("EmailID"));
                    ob.addProperty("Password", rs.getString("password"));
                    ob.addProperty("MobileNumber", rs.getString("MobileNo"));
                    ob.addProperty("PanCard", rs.getString("PanCard"));
                    ob.addProperty("DOB", rs.getString("DOB"));
                    ob.addProperty("addr", rs.getString("address"));
                    ob.addProperty("PinCode", rs.getString("PinCode"));
                    arr.add(ob);

                }

                String StudentJsonString = gson.toJson(arr);
            
                response.getWriter().write(StudentJsonString);

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

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
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
