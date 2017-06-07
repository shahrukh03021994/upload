 <%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
            <jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
<div class="container" >

    <div class="page-header">
        </br>
    </div>
    <div class="container">
    
    <div class="row" >
        <div class="col-md-6" >
            <div class="panel with-nav-tabs panel-primary">
                <div class="panel-heading">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#tab1primary" data-toggle="tab">Product</a></li>
                            <li><a href="#tab2primary" data-toggle="tab">Category</a></li>
                            <li><a href="#tab3primary" data-toggle="tab">Supplier</a></li>
                           
                        </ul>
                </div>
                <div class="panel-body">
                    <div class="tab-content">
                        <div class="tab-pane fade in active" id="tab1primary">
                        
                         <f:form modelAttribute="category" method="post"  action="save" class="form-signin">
                <span id="reauth-email" class="reauth-email"></span>
                <h4 class="input_title">Category Id</h4>
                <f:input path="cid" />
                 <h4 class="input_title">Category Name</h4>
                              <f:input path="name" />
                <button class="btn btn-lg btn-primary" type="submit">Login</button>
               </f:form>
                        </div>
                        <div class="tab-pane fade" id="tab2primary">
                        <f:form modelAttribute="supplier" method="post"  action="saveSupplier" class="form-signin">
                <span id="reauth-email" class="reauth-email"></span>
                <h4 class="input_title">Supplier Id</h4>
                <f:input path="sid" />
                 <h4 class="input_title">Supplier Name</h4>
                              <f:input path="supplierName" />
                <button class="btn btn-lg btn-primary" type="submit">Login</button>
               </f:form> 
                        </div>
                        <div class="tab-pane fade" id="tab3primary">
              <f:form action="saveProduct" modelAttribute="product" enctype="multipart/form-data" method="get">
		<table align="center">
			
			<tr>
				<td>Product ID</td>
				<td><f:input path="id"/></td>
			</tr>
			<tr>
				<td>Product Name</td>
				<td><f:input path="name" /></td>
			</tr>
			<tr>
			<td>Select Category</td>
		
				<td><f:select path="category">
						<f:option value="0" label="------Select----" />
						
					    <f:options items="${clist}" itemLabel="name"  itemValue="cid"/> 
					
					
					</f:select>
				</td>
			</tr>
			<tr>
				
			</tr>
			<tr>
				<td>Price</td>
				<td><f:input path="price" /></td>
			</tr>
			
			<tr>
				<td>Product Desc</td>
				<td><f:textarea path="description" /></td>
			</tr>
			<tr>
				<td>Product Image</td>
				
				
				<td><f:input type="file" path="pimage" /></td>
			</tr>
			<tr>
				<td colspan="2"><center>
						<input type="submit" />
					</center></td>
			</tr>

		</table>
	</f:form>

	<%-- <table align="center">
		<tr bgcolor="pink">
			<td>Product ID</td>
			<td>Product Name</td>
			<td>Category ID</td>
			<td>Supplier ID</td>
			<td>Price</td>
			<td>Stock</td>
			<td>Operation</td>
		</tr>

		<c:forEach items="${proddet}" var="prod">
			<tr bgcolor="cyan">
				<td>${prod.prodid}</td>
				<td>${prod.prodname}</td>
				<td>${prod.catid}</td>
				<td>${prod.suppid}</td>
				<td>${prod.price}</td>
				<td>${prod.stock}</td>
				<td><a href="<c:url value="deleteProduct/${prod.prodid}"/>">Delete</a>
					<a href="<c:url value="updateProduct/${prod.prodid}"/>">Update</a>
				</td>
			</tr>
		</c:forEach>

	</table> --%>
               
               
                        </div>
                        <div class="tab-pane fade" id="tab4primary">Primary 4</div>
                        <div class="tab-pane fade" id="tab5primary">Primary 5</div>
                    </div>
                </div>
            </div>
        </div>
	</div>
</div>

</div>

<br/>
            <jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>

</body>
</html>