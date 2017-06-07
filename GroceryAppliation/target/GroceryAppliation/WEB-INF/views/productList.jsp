<%@ taglib prefix="j" uri="http://java.sun.com/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.success{
color: blue;

}

</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List</title>


</head>
<body>
            <jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
<br>
<br>


<c:if test="${param.save!=null}">

                    <center class="success">SUCCESS: Product Saved.</center>
                    </c:if>
                    <c:if test="${param.del!=null}">
                        SUCCESS: Product Deleted.
                    </c:if>
                    <c:if test="${param.update!=null}">
                        SUCCESS: Product Updated.
                    </c:if>


<table id="category" class="display" border="1" width="80%" align="center">
                        <tr>
                            <th>SR</th>
                            <th>PID</th>
                            <th>NAME</th>
                           
                           
                             <th>Supplier</th>
                             <th>Category</th>
                             <th>price</th>
                             <th>quantity</th>
                             <th>Description</th>
                              <th>Image</th>
                              <th>Action</th>
                        </tr>
                        <c:if test="${empty productList}">
                            <tr>
                                <td colspan="7" align="center">No Record Exists</td>
                            </tr>
                        </c:if>
                        <c:forEach var="c" varStatus="st" items="${productList}">
                            <tr>
                                <td><c:out value="${st.count}"></c:out></td>
                                <td><c:out value="${c.id}"></c:out></td>
                                <td><c:out value="${c.name}"></c:out></td>
                                <td><c:out value="${c.supplier.supplierName}"></c:out></td>
                                <td><c:out value="${c.category.name}"></c:out></td>
                                <td><c:out value="${c.price}"></c:out></td>
                                <td><c:out value="${c.stock}"></c:out></td>
                                <td><c:out value="${c.description}"></c:out></td>
                                
                                <td><img src="./resources/images/<c:out value='${c.imgName}'></c:out>" height="50px" width="50px"/></td>
                                <td>
                           <%--  <s:url value="${c.cid}" var="id"></s:url>
                            <form action="delete/${id}" method="get">
                            <input type="submit" value="Delete">
                            </form> --%>
                            <c:set var="contextRoot" value="${pageContext.request.contextPath}"></c:set>
                            <a href="<c:url value="/admin/deleteProduct/${c.id}"/>">Delete</a>
			<a href="${contextRoot}/admin/updateProduct?id=<c:out value="${c.id}"> </c:out>">Update</a>
<%-- 			<a href="<c:url value="/admin/updateProduct1/<c:out value=''></c:out>"/>">Update</a>
 --%>                                </td> 
                                
                            
                            </tr>
                        </c:forEach>
                    </table>
                    
    <br>
    <br>                
                                <jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
                    
</body>

</html>