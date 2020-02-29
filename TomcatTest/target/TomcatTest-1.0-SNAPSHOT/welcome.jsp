<%-- 
    Document   : welcome
    Created on : Jan 22, 2020, 3:25:15 AM
    Author     : Lenovo
--%>

<%
  HttpSession LoginSession = request.getSession(false);
  String username = (String)request.getAttribute("username");
  //int sessions = (Integer)request.getAttribute("sessions");
  if(LoginSession==null||username==null)
  {
      response.sendRedirect("index.jsp");
  }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>           
        <h1>Welcome <%out.println(username);%></h1>
        <br>
        <form method="POST">
            <input type="submit" value="Log out" formaction="Logout">
        </form>
    </body>
</html>
