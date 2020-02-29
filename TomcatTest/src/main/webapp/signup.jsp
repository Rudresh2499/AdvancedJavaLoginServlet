<%-- 
    Document   : signup
    Created on : Jan 22, 2020, 12:54:04 AM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS-FOLDER/formStyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up</title>
    </head>
    <body>
        <form method="POST">
            <div class="formInput">
                <div class="centerElements">
                    <input type="text" name="username" placeholder="Enter Username" height="15px"><br/>
                    <br style="line-height: 0.3em">
                    <input type="password" name="password" placeholder="Enter Password" height="15px"><br/>
                    <br style="line-height: 0.3em">
                    <input type="password" name="check_password" placeholder="Re-Enter Password" height="15px"><br/>
                    <br style="line-height: 0.3em">
                    <input type="submit" value="Sign Up" formaction="SignUp">
                    <br style="line-height: 0.3em">
                </div>
            </div>
        </form>
    </body>
</html>
