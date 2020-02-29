<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS-FOLDER/formStyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <%
            String username = null;
            String password = null;
            Cookie[] cookies = request.getCookies();
            if(!(cookies==null))
            {
                for(Cookie tempCookie:cookies)
                {
                    switch(tempCookie.getName())
                    {
                        case "usernameCookie" : username = tempCookie.getValue();
                        break;
                        
                        case "passwordCookie" : password = tempCookie.getValue();
                        break;
                    }
                }
            }
            if((username==null)&&(password==null))
            {
                username = "";
                password = "";
            }
        %>
        <p>
            <form method="POST">
                <div class="formInput">
                    <div class="centerElements">
                        <input type="text" name="username" placeholder="Username" value="<%=username%>"><br/>
                        <br style="line-height: 0.4em">
                        <input type="password" name="password" placeholder="Password" value="<%=password%>">
                        <br style="line-height: 0.4em">
                        <br style="line-height: 0.4em">
                        <input type="submit" value="Login" formaction="Login">&nbsp<input type="submit" value="Sign Up" formaction="signup.jsp"><br>
                        <br style="line-height: 0.4em">
                        <div class="rememberMe">
                            <input type="checkbox" name="remember_me" value="Remember Me">Remember Me
                        </div>
                    </div>
                </div>
            </form>
        </p>
    </body>
</html>