package com.login;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
@WebServlet(name = "AnuragSinghal", urlPatterns = {"/AnuragSinghal"})
public class AnuragSinghal extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    // private final static String INSERT_QUERY = "INSERT INTO `shivdb`.`login_details(`FirstName`,`LastName`,`EmailID`,`password`,`MobileNo`,`PanCard`,`DOB`,`address`,`PinCode`) VALUES(?,?,?,?,?,?,?,?,?)";
    @SuppressWarnings("CallToPrintStackTrace")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        Map<String, String[]> m = request.getParameterMap();

        insertcmdata(m);
           RequestDispatcher rd=request.getRequestDispatcher("index.html");
          rd.forward(request, response);
    }

    private void insertcmdata(Map<String, String[]> orignaldata) throws SQLException, ClassNotFoundException {
 
        String query = "  INSERT INTO " + "shivdb.login_details";
        String query1 = "VALUES";

        StringBuilder strbuilder = new StringBuilder();
        StringBuilder strbuilder1 = new StringBuilder();
        String keyStr = null;
        for (Object key : orignaldata.keySet()) {
            keyStr = (String) key;

            String[] value = (String[]) orignaldata.get(keyStr);
            System.out.println((String) key + "   :   " + value[0]);

            strbuilder.append("`" + (String) key + "`" + ",");
            strbuilder1.append("'" + value[0] + "',");

        }
        if (keyStr == "btn") {

        } else if (strbuilder.length() > 0) {
            query = query + "(" + strbuilder.substring(0, strbuilder.length() - 1) + ")";
        }
  if (strbuilder1.length() > 0) {
            query1 = query1 + "(" + strbuilder1.substring(0, strbuilder1.length() - 1) + ")";

        }
        query = query + query1 + ";";        // inputList.add(recordId);

        System.out.println(query);
        //   System.out.println(query1);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shivdb", "root", "shiv@123");

            PreparedStatement st = con.prepareStatement(query);

            st.executeUpdate(query);

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
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AnuragSinghal.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AnuragSinghal.class.getName()).log(Level.SEVERE, null, ex);
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
