/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

//import java.io.IOException;
//import java.io.PrintStream;
//import java.io.PrintWriter;
//import java.io.StringWriter;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author Lenovo
 */
public class SessionListenerFilter implements /*Filter,*/HttpSessionListener{
    //private FilterConfig fc;
    private static int activeSession;
    
    /*@Override
    public void init(FilterConfig config) throws ServletException
    {
        this.fc = config;
    }
    
    @Override
    public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain)
            throws ServletException,IOException
    {
        request.setAttribute("ActiveSessions",SessionListenerFilter.getActiveSession());
        chain.doFilter(request, response);
    }
    
    @Override
    public void destroy()
    {
    }*/
    
    //Overriding all HttpSessionListener Methods

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSession++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSession--;
    }
    
    public static int getActiveSession()
    {
        return activeSession;
    }
}
