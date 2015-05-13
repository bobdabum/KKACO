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
    
    <!--Put wrapper/div around form, using bootstrap -->
    <div class="panel-group">
        <label class="writer-id">
            Your ID: <input type="text" name="writer_id" style="color:black"> 
        </label>
        <label class="recomendee-id">
            Recomendee ID: <input type="text" name="recomendee_id" style="color:black">
        </label>
        <br />
        <br />
        <form class="navbar-form navbar-center" role="submitRequest">
            <div class="form-group">
                <textarea rows="10" cols="100" style="color:black"> Enter recommendation here
                </textarea>
            </div>
            
            <br />
            <br />
            <div class="form-group">
                <!--<label for="inputFile">File input</label>-->
                <input type="file" id="inputFile">
            </div>
            
            <br />
            <br />
            <div class="form-group">
                Confidential?
                <label class="radio-inline"> 
                    <input type="radio" name="visibilityOptions" id="inlineRadio2" value="1"> Yes 
                </label>
                <label class="radio-inline"> 
                    <input type="radio" name="visibilityOptions" id="inlineRadio2" value="0"> No
                </label>    
            </div>
            
            <br />
            <br />
            <div class="form-group">
                Valid until: 
                <div class="input-group date">
                    <input type="text" class="form-control"><span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
                </div>
            </div>
            
            
            <br />
            <br />
            <input class="btn btn-default" type="submit" value="Submit">
        </form> 
    </div>
    
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
                            <!-- Paste form here -->
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </c:if>
</t:wrapperLoggedIn>
