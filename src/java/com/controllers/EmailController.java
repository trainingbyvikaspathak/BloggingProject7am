/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.util.EmailUtility;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DELL
 */
public class EmailController extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String host="smtp.gmail.com";
        String user = "vikas.gist8056@gmail.com";
        String port ="587";
        String password="gistbhopal";
        String subject = request.getParameter("subject");
        String message= request.getParameter("message");
        String to  = request.getParameter("recipients");
        String recipeints[] = to.split(",");
        try{
        EmailUtility.sendEmail(host, port, user, password, recipeints, subject, message);
        response.sendRedirect("test/sendMail.jsp?result=Message Sent Sucessfully !!");
        }catch(Exception e){
            System.out.println("Error :"+ e.getMessage());    
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
