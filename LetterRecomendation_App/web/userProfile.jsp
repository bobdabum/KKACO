<%-- 
    Document   : userProfile
    Created on : Apr 5, 2015, 12:05:41 PM
    Author     : My Pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
    </head>
    <body>
        <header>USER PROFILE</header>
        <p>WELCOME: ${user.fName} ${user.lName}</p>
        <p>EMAIL: ${user.email}</p>
    </body>
</html>
