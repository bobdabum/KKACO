<%-- 
    Document   : register
    Created on : Apr 17, 2015, 6:55:27 PM
    Author     : myself
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>USER REGISTRATION PAGE</title>
    </head>
    <body>
        <p>CREATE NEW ACCOUNT</p>
        <form name="Registration Form" action="RegistrationController" method ="post">
            Enter your email:
            <input type="text" name="email" /><br/>
            Enter your first name:
            <input type="text" name="fName" /><br/>
            Enter your last name:
            <input type="text" name="lName" /><br/>
            Enter your password:
            <input type="text" name="pw" /><br/>
            <input type="submit" value="OK" />
        </form>
    </body>
</html>
