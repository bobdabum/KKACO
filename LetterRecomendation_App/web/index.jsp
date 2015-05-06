<%-- 
    Document   : index
    Created on : Mar 6, 2015, 9:27:59 AM
    Author     : My Pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String redirectURL = request.getContextPath()+"/home";
    response.sendRedirect(redirectURL);
%>