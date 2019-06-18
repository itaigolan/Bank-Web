<%-- 
    Document   : LoginPage
    Created on : Jun 9, 2019, 6:32:21 PM
    Author     : itaig
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <script type="text/javascript">
        function callServlet() {
            document.forms[0].action = "LoginServlet";
            document.forms[0].submit();
        }
    </script>
    <body>
        <form id="loginForm" name="loginForm" method="post">
            <h1>Welcome to the banking application, please login.</h1>
            <p>User Id&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="text" name="id"/>
            </p>
            <p>
            Password
            <input type="password" name="password" />
            </p>
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input id="LoginButton" type="submit" value="Login" onclick="callServlet();"/>
            </p>
        </form>
    </body>
</html>
