<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %> --%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category List</title>


</head>
<body>
            <jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
<br>
<br>
<table id="category" class="display" border="1" width="80%" align="center">
                        <tr>
                            <th>SR</th>
                            <th>CID</th>
                            <th>NAME</th>
                             <th>ACTION</th>
                        </tr>
                        <c:if test="${empty contactList}">
                            <tr>
                                <td colspan="7" align="center">No Record Exists</td>
                            </tr>
                        </c:if>
                        <c:forEach var="c" varStatus="st" items="${contactList}">
                            <tr>
                                <td><c:out value="${st.count}"></c:out></td>
                                <td><c:out value="${c.cid}"></c:out></td>
                                <td><c:out value="${c.name}"></c:out></td>
                                
                                
                            <td>
                           <%--  <s:url value="${c.cid}" var="id"></s:url>
                            <form action="delete/${id}" method="get">
                            <input type="submit" value="Delete">
                            </form> --%>
                            <a href="<c:url value="deleteCategory/${c.cid}"/>">Delete</a>
			<a href="<c:url value="updateCategory/${c.cid}"/>">Update</a>
                                </td> 
                            </tr>
                        </c:forEach>
                    </table>
                    
    <br>
    <br>                
                                <jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
                    
</body>
<script src="./resources/js/jquery.dataTables.min.js"></script>
	<script src="./resources/js/datatable.js"></script>

</html>