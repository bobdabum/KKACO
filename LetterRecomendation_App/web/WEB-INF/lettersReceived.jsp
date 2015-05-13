<%-- 
    Document   : lettersRequested
    Created on : May 4, 2015, 1:50:45 PM
    Author     : My Pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:wrapperLoggedIn title="Letters Received">
    <h1>Letters Received</h1>
    <c:if test="${empty letters}">
        <p>You have no letters received.</p>
    </c:if>
    
    
</t:wrapperLoggedIn>
