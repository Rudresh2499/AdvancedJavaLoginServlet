/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import filters.SessionListenerFilter;
import serviceclasses.*;
import modelclasses.LoginDetails;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lenovo
 */
public class LoginServlet extends HttpServlet {

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
        boolean loginFlag = false;
        
        PrintWriter out = response.getWriter();
        
        try
        {
            LoginDetails formDetails = new LoginDetails(request.getParameter("username"),request.getParameter("password"));
            
            Connection dbConnection = new ConnectionService().getDbConnection(getServletContext().getInitParameter("db_driver"),getServletContext().getInitParameter("db_url"),getServletContext().getInitParameter("db_username"),getServletContext().getInitParameter("db_password"));
            ResultSet dbData = new DataFetchService().getLoginData(dbConnection);
            
            String rememberMe = (String)request.getParameter("remember_me");
            while(dbData.next())
            {
                LoginDetails dbDetails = new LoginDetails(dbData.getString(1),dbData.getString(2));
                loginFlag = new LoginService().loginCheck(formDetails, dbDetails);
                if(loginFlag==true)
                {
                    if((rememberMe)!=null)
                    {
                        response.addCookie(new CookieService().makeCookie("usernameCookie",formDetails.getUsername(),60));
                        response.addCookie(new CookieService().makeCookie("passwordCookie",formDetails.getPassword(),60));
                    }
                    request.setAttribute("username",formDetails.getUsername());
                    RequestDispatcher success = request.getRequestDispatcher(getInitParameter("success_url"));
                    HttpSession LoginSession = request.getSession();
                    request.setAttribute("sessions",SessionListenerFilter.getActiveSession());
                    success.forward(request, response);
                    return;
                }
            }
            if(loginFlag==false)
            {
                response.sendRedirect(getInitParameter("failure_url"));
            }
            dbConnection.close();
        }
        catch(SQLException SE)
        {
            SE.printStackTrace();
        }
        catch(ClassNotFoundException CNFE)
        {
            CNFE.printStackTrace();
        }
        out.close();
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
