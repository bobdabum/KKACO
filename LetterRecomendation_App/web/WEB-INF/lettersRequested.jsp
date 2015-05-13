<%-- 
    Document   : lettersRequested
    Created on : May 4, 2015, 1:50:45 PM
    Author     : My Pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:wrapperLoggedIn title="Letters Requested">
    <script  src="js/bootstrap-datepicker.min.js"></script>
    <script  src="js/LetterRequestedJS.js"></script>
    <h1>Letters Requested</h1>
    <c:if test="${empty letters}">
        <p>You have no letters requested.</p>
    </c:if>
    <h2>Request new letter</h2>
    <div class ="container-fluid">
        <form action="letters_requested" method ="post" name="Request Letter Form" class="form-inline">
            <div class="form-group">
                
            </div>
            <div class="form-group">
                <input class="datepicker" id="lrDate" data-date-format="mm/dd/yyyy" name="deadline">
            </div>
        </form>
    </div>
    <c:if test="${not empty letters}">
        <c:forEach items="${letters}" var="letter">

        </c:forEach>
    </c:if>
</t:wrapperLoggedIn>
