<%-- 
    Document   : requestsReceived
    Created on : May 7, 2015, 4:57:42 PM
    Author     : My Pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:wrapperLoggedIn title="Requests Received">
    <h1>Requests Received</h1>
    <c:if test="${empty letters}">
        <p>You have no requests received.</p>
    </c:if>
    <c:if test="${not empty letters}">
        <c:forEach items="${letters}" var="letter" varStatus="loop">
            <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="heading${loop.index}}">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                                ${letter.rec_fName} ${letter.rec.lName}
                            </a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="heading${loop.index}">
                        <div class="panel-body">
                            
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </c:if>
</t:wrapperLoggedIn>
