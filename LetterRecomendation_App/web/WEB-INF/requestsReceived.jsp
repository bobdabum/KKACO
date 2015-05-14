<%-- 
    Document   : requestsReceived
    Created on : May 7, 2015, 4:57:42 PM
    Author     : My Pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:wrapperLoggedIn title="Requests Received">
    <script  src="js/bootstrap-datepicker.js"></script>
    <script  src="js/LetterRequestedJS.js"></script>
    <h1>Requests Received</h1>
    <c:if test="${empty letters}">
        <p>You have no requests received.</p>
    </c:if>

    <c:if test="${not empty letters}">
        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
            <c:forEach items="${letters}" var="letter" varStatus="loop">
                <div class="panel panel-default">
                    <div class="panel-heading" role="tab" id="heading${loop.index}" style="color:black">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#collapse${loop.index}" aria-expanded="false" aria-controls="collapse${loop.index}" style="color:black">
                                ${letter.rec_fName}  ${letter.rec_lName}
                            </a>
                        </h4>
                    </div>
                    <div id="collapse${loop.index}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading${loop.index}" style="color:black">
                        <div class="panel-body">
                            <div class="panel-group">
                                <form name="submitRequest" action="requests_received" method="post">
                                    <input type="hidden" name="action" value="acceptReject"/>
                                    <input type="hidden" name="letterid" value="${letter.letter_id}"/>
                                    <input type="hidden" name="recomendee_id" value="${letter.recomendee_id}"/>                                    
                                    <input type="radio" value="true" name="accepted">Accept</input>
                                    <input type="radio" value="false" name="accepted">Reject</input>
                                    <button class="btn btn-success" type="submit">Accept/Reject Recommendation</button>
                                </form>
                                <form name="submitText" action="requests_received" method="post">
                                    <input type="hidden" name="action" value="submitText"/>
                                    <div class="form-group">
                                        <textarea rows="10" cols="100" name="text" style="color:black"> Enter recommendation here
                                        </textarea>
                                    </div>
                                    <input type="hidden" name="letterid" value="${letter.letter_id}"/>
                                    <button class="btn btn-success" type="submit">Submit Letter</button>                                    
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>
</t:wrapperLoggedIn>
