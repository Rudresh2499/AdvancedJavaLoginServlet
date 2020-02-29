/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import modelclasses.SignUpDetails;
import modelclasses.LoginDetails;
import serviceclasses.*;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lenovo
 */
public class SignUpServlet extends HttpServlet {

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
        boolean passwordFlag = false,usernameFlag = true;
        PrintWriter out = response.getWriter();
        try
        {
            SignUpDetails formDetails = new SignUpDetails(request.getParameter("username"),request.getParameter("password"),request.getParameter("check_password"));
            
            Connection dbConnection = new ConnectionService().getDbConnection(getServletContext().getInitParameter("db_driver"),getServletContext().getInitParameter("db_url"),getServletContext().getInitParameter("db_username"),getServletContext().getInitParameter("db_password"));
            ResultSet dbData = new DataFetchService().getLoginData(dbConnection);
            
            passwordFlag = new SignUpService().passwordCheck(formDetails);
            if(passwordFlag)
            {
                while(dbData.next())
                {
                    String dbUsername = dbData.getString(1);
                    usernameFlag = (usernameFlag)&&(new SignUpService().usernameCheck(formDetails, dbUsername));
                }
                if(usernameFlag)
                {
                    new DataInsertService().insertCredentials(dbConnection, formDetails);
                    response.sendRedirect(getInitParameter("success_url"));
                }
                else
                {
                    response.sendRedirect(getInitParameter("failure_url"));
                }
            }
            else
            {
                response.sendRedirect(getInitParameter("failure_url"));
            }
        }
        catch(SQLException SE)
        {
            SE.printStackTrace();
        }
        catch(ClassNotFoundException CNFE)
        {
            CNFE.printStackTrace();
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
