<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
  
  
</head>
<body>




<nav class="navbar navbar-inverse">


  <div class="container-fluid">
    <div class="navbar-header">
    
    </div>
     <!-- Creating Menu Bar -->
    <ul class="nav navbar-nav">
    <c:set value="${pageContext.request.contextPath}" var="imgC"></c:set>
    
                <li class="active"><a href="home"><img src="./resources/sw.png" height="50px"  width="50px"/> </a></li>
                
                <c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>
                     <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="">Category<span class="caret"></span></a>  
                              <ul class="dropdown-menu">
                     <c:forEach var="catVal" items="${catList}">
                          <li><a href="${contextRoot}/productCustList?cid=${catVal.cid}">${catVal.name}</a></li>
                     </c:forEach>
                     
        </ul>
      </li> 

    <li><a href="<c:url value='/admin/Product'/>">ADD</a></li>
    </ul>
    <!-- <ul class="nav navbar-nav navbar-right">
      <li><a href="register" style="font-family: tahoma;"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="login" style="font-family: tahoma;"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul> -->
    
    <c:if test="${pageContext.request.userPrincipal.name  == 'admin'}">
                                <li><a href="<c:url value="/admin" />">Admin</a></li>
                            </c:if>
			<ul class="nav navbar-nav navbar-right">
<%-- 			<li><a href="<c:url value="./login"/>">Login !</a></li>

 --%>
 <li><a href="${contextRoot}/login">Login</a></li>
 			<li><a href="${contextRoot}/register">Register</a></li>
			 <li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
                            <li><a href="<c:url value="/logout" />">Logout</a></li>
    
    
  </div>
</nav>
</body>
</html>