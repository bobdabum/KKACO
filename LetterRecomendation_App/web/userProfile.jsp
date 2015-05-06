<%-- 
    Document   : userProfile
    Created on : Apr 5, 2015, 12:05:41 PM
    Author     : My Pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:wrapperLoggedIn title="User Profile">
    <div class ='jumbotron' style="padding-top: 0; padding-bottom: 0">
        <script  src="jquery-editInPlace-v2.2.1/spec/support/jquery-1.4.2.js"></script>
        <script  src="jquery-editInPlace-v2.2.1/spec/support/jquery-ui.js"></script>
        <script  src="jquery-editInPlace-v2.2.1/lib/jquery.editinplace.js"></script>
        <script  src="EditInPlace.js"></script>
        <div class="container" style="background-color:rgba(0,0,0,.6); height: 100%">
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
        </div>
    </div>
</t:wrapperLoggedIn>
