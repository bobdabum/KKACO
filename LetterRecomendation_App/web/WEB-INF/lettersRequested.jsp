<%-- 
    Document   : lettersRequested
    Created on : May 4, 2015, 1:50:45 PM
    Author     : My Pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<t:wrapperLoggedIn title="Letters Requested">
    <script  src="js/bootstrap-datepicker.js"></script>
    <script  src="js/LetterRequestedJS.js"></script>
    <h1>Letters Requested</h1>
    <c:if test="${empty letters}">
        <p>You have no letters requested.</p>
    </c:if>

    <c:if test="${not empty letters}">
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
                        <td> <fmt:formatDate value="${letter.deadline.time}" type="date" dateStyle="SHORT"/> </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </c:if>

    <h3>Request new letter:</h3>
    <div class ="container-fluid panel-group">
        <form action="letters_requested" method ="post" name="Request Letter Form" class="form-inline">            
            <div class="form-group">
                <label for="email">Writer's Email:</label>
                <input class="text" id="email" name="email" style="color: black">
            </div>
            <div class="form-group">
                <label for="deadline">Deadline:</label>
                <input class="datepicker" id="deadline" data-date-format="mm/dd/yyyy" name="deadline" style="color: black">
            </div>
            <div class="form-group">
                <label for="validTo">Valid To:</label>
                <input class="datepicker" id="validTo" data-date-format="mm/dd/yyyy" name="validto" style="color: black">
            </div>
            <div class="form-group">
                Confidential?
                <label class="radio-inline"> 
                    <input type="radio" name="isPrivate" id="inlineRadio2" value="1"> Yes 
                </label>
                <label class="radio-inline"> 
                    <input type="radio" name="isPrivate" id="inlineRadio2" value="0"> No
                </label>    
            </div>
            <button type="submit" class="btn btn-success">Request Letter</button>
        </form>
    </div>
</t:wrapperLoggedIn>
