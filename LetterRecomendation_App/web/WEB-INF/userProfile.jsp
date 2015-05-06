<%-- 
    Document   : userProfile
    Created on : Apr 5, 2015, 12:05:41 PM
    Author     : My Pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:wrapperLoggedIn title="User Profile">
    <script  src="jquery-editInPlace-v2.2.1/spec/support/jquery-1.4.2.js"></script>
    <script  src="jquery-editInPlace-v2.2.1/spec/support/jquery-ui.js"></script>
    <script  src="jquery-editInPlace-v2.2.1/lib/jquery.editinplace.js"></script>
    <script  src="jquery-editInPlace-v2.2.1/EditInPlace.js"></script>
    <h1>User Profile:</h1>
    <p>To change your info, click on the field you wish to change.</p>
    Name:
    <p style="color:black">
        <span id="fNameEdit">${user.fName}</span> <span id="lNameEdit">${user.lName}</span>
    </p>
    Email:
    <p id="emailEdit" style="color:black">
        ${user.email}
    </p>
</t:wrapperLoggedIn>
