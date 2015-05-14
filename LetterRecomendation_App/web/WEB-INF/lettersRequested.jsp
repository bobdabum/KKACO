<%-- 
    Document   : lettersRequested
    Created on : May 4, 2015, 1:50:45 PM
    Author     : My Pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:wrapperLoggedIn title="Letters Requested">
    <script  src="js/bootstrap-datepicker.js"></script>
    <script  src="js/LetterRequestedJS.js"></script>
    <h1>Letters Requested</h1>
    <c:if test="${empty letters}">
        <p>You have no letters requested.</p>
    </c:if>

    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">Letters Requested</div>

        <!-- Table -->
        <table class="table table-hover" style="color:black">
            <tr>
                <th> Requested From </th>
                <th> Status </th>
                <th> Due Date </th>
            </tr>
            <c:forEach items="${letters}" var="letter">
                <tr>
                    <td> ${letter.writer_fName} ${letter.writer_lName}</td>
                    <td> ${letter.status} </td>
                    <td> <fmt:formatDate type="both" dateStyle="full" value="${letter.deadline.itsGregorian.time}"></fmt:formatDate></td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <h3>Request new letter:</h3>
    <div class ="container-fluid">
        <form action="letters_requested" method ="post" name="Request Letter Form" class="form-inline">
            <div class="form-group">

            </div>
            <div class="form-group">
                <input class="datepicker" id="lrDate" data-date-format="mm/dd/yyyy" name="deadline">
            </div>
        </form>
    </div>
</t:wrapperLoggedIn>
