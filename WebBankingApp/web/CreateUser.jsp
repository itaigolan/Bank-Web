<%-- 
    Document   : CreateUser
    Created on : Jun 13, 2019, 9:56:02 PM
    Author     : itaig
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create User</title>
    </head>
    <%Object user = session.getAttribute("UserSession");
    session.setAttribute("UserSession",user);%>
    <body>
        <form id="form1" runat="server" action="CreateUserServlet" method="post">
            <h1>Create User</h1>
            <p>
                First Name&nbsp;<input id="fName" type="text" name="fName"/>
                &nbsp;&nbsp;&nbsp;&nbsp; 
                Last Name&nbsp;<input id="lName" type="text" name="lName"/>
                &nbsp;&nbsp;&nbsp;&nbsp; 
                Email<input id="email" type="text" name="email"/>
            </p>
            <p>
                <input id="EmployeeBox" name="employeeBox" type="checkbox" value="V1" />Employee&nbsp;&nbsp;&nbsp;&nbsp;
                <input id="CustomerBox" name="customerBox" type="checkbox" value="V1" />Customer
            </p>
            <p>
                <input id="SubmitButton" type="submit" value="Submit"/>
            </p>
        </form>
    </body>
</html>
