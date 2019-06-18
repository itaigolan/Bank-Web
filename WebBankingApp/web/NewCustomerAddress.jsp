<%-- 
    Document   : CustomerCreationPage
    Created on : Jun 17, 2019, 4:40:33 PM
    Author     : itaig
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Customer Address</title>
    </head>
    <script type="text/javascript">
        function create() {
            document.forms[0].action = "CreateCustomerServlet";
            document.forms[0].submit();
        }
    </script>
    <%Object user = session.getAttribute("UserSession");
    session.setAttribute("UserSession",user);
    Object c = session.getAttribute("Customer");
    session.setAttribute("Customer",c);%>
    <body>
        <h1>Input Customer's Address</h1>
        <p>
            Address&nbsp;<input id="address" type="text" name="address"/>
            &nbsp;&nbsp;&nbsp;&nbsp; 
            City&nbsp;<input id="city" type="text" name="city"/>
            &nbsp;&nbsp;&nbsp;&nbsp; 
            State&nbsp;<input id="state" type="text" name="state"/>
            &nbsp;&nbsp;&nbsp;&nbsp; 
            Zip Code&nbsp;<input id="zipCode" type="text" name="zipCode"/>
        </p>
        <p>
            <input id="SyncBox" checked="false" name="SyncBox" type="checkbox" value="V1" />Sync with existing customer
        </p>
        <p>
            <input id="SubmitButton" type="button" value="Submit" OnClick="create()"/>
        </p>
    </body>
</html>
