<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>

<jsp:include page="header.jsp"></jsp:include>
   <div class="container">
   <div><br></div>

<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true"  id="onload">

    <div class="modal-dialog modal-sm">

      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">X</button>
        </div>
        <div class="modal-body">
         <span>Please Login Before Purchase</span>
        </div>
        <div class="modal-footer">
          <a href="login" class="btn btn-info" role="button">Click here for Login</a>
        </div>
      </div>

    </div>
</div>

<script>
$( document ).ready(function() {
    $('#onload').modal('show');
});  
</script>

</body>
</html>