   <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page isELIgnored="false"%>

<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
	<meta charset="utf-8" />
	<title>Category List</title>
	<link rel="stylesheet" href="./resources/css/bootstrap.min.css">
	<script src="./resources/js/jquery.min.js"></script>
	<script src="./resources/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="./resources/css/jquery.dataTables.min.css">
	
</head>

<body>


<form:form action="" method="get">
	<h1>Category Table</h1>
	<table id="category" class="display">
      
       <!-- Header Table -->
       <thead>
            <tr>
                <th>Id</th>
				<th>Name</th>
              
            </tr>
        </thead>
        <!-- Footer Table -->
        <tfoot>
            <tr>
                <th>Id</th>
				<th>Name</th>
				 <a href="<c:url value="deleteCategory/id"/>">Delete</a>
			<a href="<c:url value="updateCategory/id"/>">Update</a>
               
            </tr>
        </tfoot>
    </table>
  </form:form>  
</body>
.
<script src="./resources/js/jquery.dataTables.min.js"></script>
	<script src="./resources/js/datatable.js"></script>
</html>
