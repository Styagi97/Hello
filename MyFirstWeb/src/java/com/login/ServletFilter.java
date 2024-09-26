/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.login;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;  
/**
 *
 * @author admin
 */
public class ServletFilter implements Filter  {

   

    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        PrintWriter out = sr1.getWriter();
 
        String password = sr.getParameter("password");

        if (password.equals("mypassword")) {

            // Sending request to next
            fc.doFilter(sr, sr1);
        } // Password incorrect
        else {
            out.print("username or password is wrong");
            RequestDispatcher rd
                    = sr.getRequestDispatcher("heloo.html");
            rd.include(sr, sr1);
        }
    }

}
