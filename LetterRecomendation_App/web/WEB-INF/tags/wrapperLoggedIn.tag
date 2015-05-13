<%-- 
    Document   : wrapperLoggedIn
    Created on : Apr 20, 2015, 2:58:08 AM
    Author     : My Pc
--%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@tag description="Wrapper for logged in pages" pageEncoding="UTF-8"%>
<%@attribute name="title"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/cover.css" rel="stylesheet">
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
       
            <c:set var="url">${pageContext.request.requestURL}</c:set>
        <base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />
    </head>
        
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Recommend.us</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class='nav navbar-nav'>
                        <li <c:if test="${title == 'User Profile'}">class ='active'</c:if>>
                                <a href="user_profile"> User Profile 
                                <c:if test="${title == 'User Profile'}"><span class="sr-only">(current)</span></c:if>
                                </a>
                            </li>
                            <li <c:if test="${title == 'Letters Requested'}">class ='active'</c:if>>
                                <a href="letters_requested">View Letters Requested 
                            <c:if test="${title == 'Letters Requested'}"><span class="sr-only">(current)</span></c:if>
                                </a>
                            </li>
                            <li <c:if test="${title == 'Requests Received'}">class ='active'</c:if>>
                                <a href="requests_received"> View Requests Received 
                                <c:if test="${title == 'Requests Received'}"><span class="sr-only">(current)</span></c:if>
                                </a>
                            </li>
                        </ul>
                        <a class="btn btn-success navbar-btn navbar-right" href="index.jsp">Logout</a>
                    </div><!--/.navbar-collapse -->
                </div>
            </nav>
            <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
            <!-- Include all compiled plugins (below), or include individual files as needed -->
            <script src="js/bootstrap.min.js"></script>
                
            <div class ='jumbotron' style="padding-top: 0; padding-bottom: 0">
                <div class="container" style="background-color:rgba(0,0,0,.6); height: 100%">
                <jsp:doBody/>
            </div>
        </div>
    </body>
</html>