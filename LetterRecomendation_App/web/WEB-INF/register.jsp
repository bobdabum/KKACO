<%-- 
    Document   : register
    Created on : Apr 17, 2015, 6:55:27 PM
    Author     : myself
--%>
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:wrapperNotLoggedIn title="Registration">    
    <div class="jumbotron">
        <div class='container'>
            <h2>Register New Account</h2>
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
    </div>
</t:wrapperNotLoggedIn>