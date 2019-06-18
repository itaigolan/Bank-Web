<%-- 
    Document   : CustomerPage
    Created on : Jun 9, 2019, 11:47:54 PM
    Author     : itaig
--%>

<%@page import="DataObject.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Customer Page</h1>
        <% User user = request.getSession().getAttribute("UserSession"); %>
    </body>
</html>
