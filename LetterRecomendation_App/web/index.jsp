<%-- 
    Document   : index
    Created on : Mar 6, 2015, 9:27:59 AM
    Author     : My Pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN PAGE</title>
    </head>
    <body>
        <p>LOGIN THROUGH ID</p>
        <form name="Login Input Form" action="LoginController" method ="post">
            Enter your email:
            <input type="text" name="email" />
            Enter your password:
            <input type="text" name="pw" /><br/>
            <input type="submit" value="OK" />
        </form>
    </body>
</html>
