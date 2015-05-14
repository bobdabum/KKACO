<%-- 
    Document   : userProfile
    Created on : Apr 5, 2015, 12:05:41 PM
    Author     : My Pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:wrapperLoggedIn title="Edit Profile">
    <div class="jumbotron">
        <div class='container'>
            <h2>Update your account</h2>
            <form name="Registration Form" action="user_profile" method ="post">
                <div class="form-group">
                    <input type="hidden" name="action" value="register" />
                    <input type="email" class="form-control" placeholder="Email" name="email" />
                    <input type="text" class="form-control" placeholder="First Name" name="fName" />
                    <input type="text" class="form-control" placeholder="Last Name" name="lName" />
                    <input type="password" class="form-control" placeholder="Password" name="pw" />
                    <input type="submit" value="OK" class="btn btn-primary btn-lg"/>
                </div>
            </form>
        </div>
</t:wrapperLoggedIn>
