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
		 <script  src="jquery-editInPlace-v2.2.1/spec/support/jquery-1.4.2.js"></script>
        <script  src="jquery-editInPlace-v2.2.1/spec/support/jquery-ui.js"></script>
        <script  src="jquery-editInPlace-v2.2.1/lib/jquery.editinplace.js"></script>
        <script  src="EditInPlace.js"></script>
    </head>
    <body>
        
        
		 <h1>User Profile</h1>
			<p>You may edit your information at any time.</p>
			User Name: 
            <p id="editme1">
              User Name: ${user.fName} ${user.lName}
            </p>
			
			Email:
			<p id="editme2">
               Email: ${user.email}
            </p>
        
    </body>
</html>
