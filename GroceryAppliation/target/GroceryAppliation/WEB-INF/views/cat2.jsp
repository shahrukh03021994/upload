<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page isELIgnored="false" %>
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
                            <li class="active"><a href="#tab1primary" data-toggle="tab">Category</a></li>
                            <li><a href="#tab2primary" data-toggle="tab">Supplier</a></li>
                            <li><a href="#tab3primary" data-toggle="tab">Product</a></li>
                           
                        </ul>
                </div>
                <div class="panel-body">
                    <div class="tab-content">
                        <div class="tab-pane fade in active" id="tab1primary">
                        
                         <form  method="post"  action="<c:url value="/admin/save" />" class="form-signin">
                <span id="reauth-email" class="reauth-email"></span>
                <h4 class="input_title">Category Id</h4>
                <input type="text" name="cid"/></td>
                 <h4 class="input_title">Category Name</h4>
                            <input type="text" name="name"/></td>
                <button class="btn btn-lg btn-primary" type="submit">Save</button>
                 <button class="btn btn-lg btn-primary" type="reset">Cancel</button>
                
               </form>
                        </div>
                        <div class="tab-pane fade" id="tab2primary">
                        <form  method="post" action="<c:url value="/admin/saveSupplier" />" class="form-signin">
                <span id="reauth-email" class="reauth-email"></span>
                <h4 class="input_title">Supplier Id</h4>
                <input type="text" name="sid"/></td>
                 <h4 class="input_title">Supplier Name</h4>
                 <input type="text" name="supplierName"/></td>
                  
                <button class="btn btn-lg btn-primary" type="submit">Login</button>
               </form> 
                        </div>
                        <div class="tab-pane fade" id="tab3primary">
                        
                        
                        
              <form action="<c:url value="/admin/saveProduct"/>"   method="post" enctype="multipart/form-data">
		
		<table align="center">
			<tr>
				<td colspan="2"><center>Product Details</center></td>
			</tr>
			
			<tr>
				<td>Product Name</td>
				<td><input type="text" name="pName"/></td>
			</tr>
			<tr>
			<td>Select Category</td>
		
				<td><select name="pCategory">
												<option value="0">----Category---</option>
				
						<c:forEach items="${cat}" var="cate">
						<option value="${cate.cid}">${cate.name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Select Supplier</td>
		
				<td><select name="pSupplier">
					<option value="0">----Supplier---</option>
						
						<c:forEach items="${sat}" var="sate">
						<option value="${sate.sid}">${sate.supplierName}</option>
									                
						
						</c:forEach>
					</select>
				</td>
			</tr>
			
			<tr>
				<td>Price</td>
				<td><input  type="number" name="pPrice" /></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input  type="text" name="pDescription" /></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><input  type="text" name="pQuantity" /></td>
			</tr>
			
			
				<tr>
				<td>Image</td>
				<td><input type="file" name="file" /></td>
			</tr>
			<tr>
				<td colspan="2"><center>
						<input type="submit" />
					</center></td>
			</tr>
 
		</table>
	</form>
               
               
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