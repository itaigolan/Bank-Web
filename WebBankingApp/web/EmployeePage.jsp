<%-- 
    Document   : EmployeePage
    Created on : Jun 9, 2019, 11:48:09 PM
    Author     : itaig
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EmployeePage</title>
    </head>
    <script type="text/javascript">
        function logout() {
            document.forms[0].action = "LoginPage.jsp";
            document.forms[0].submit();
        }
        function createUser() {
            document.forms[0].action = "CreateUser.jsp";
            document.forms[0].submit();
        }
        
    </script>
    <%Object user = session.getAttribute("UserSession");
    session.setAttribute("UserSession",user);%>
    <body>
        <form id="form1" runat="server">
            <h1>Employee Page</h1>
            <div class="auto-style1">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input id="LogoutButton" type="button" value="Logout" OnClick="logout()"/>
        </div>
        <p>
&nbsp;<input id="CreateUserButton" type="button" value="Create User" OnClick="createUser()"/>
        </p>
        <p>
            <input id="OpenAccountButton" type="button" value="Open New Account" />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
        <p>
            &nbsp;<input id="DeleteAccountButton" type="button" value="Delete Existing Account" />
        </p>
        <p>
&nbsp;<input id="UpdateButton" type="button" value="Update Your User Information" />
        </p>
        <p>
            <input id="ViewCustomerButton" type="button" value="View Customer Information" />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
        <p>
            &nbsp;
            <input id="ViewAccountButton" type="button" value="View Account Information" />
            </p>
        </form>
    </body>
</html>
