<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page isELIgnored="false"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<form action="saveProduct" method="post">
		<table align="center">
			<tr>
				<td colspan="2"><center>Product Details</center></td>
			</tr>

			<tr>
				<td>Product Name</td>
				<td><input type="text" name="pName" /></td>
			</tr>
			<tr>
				<td>Select Category</td>

				<td><select name="pCategory">
						<option value="0">----Category---</option>

						<c:forEach items="${cat}" var="cate">
							<option value="${cate.cid}">${cate.name}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Select Supplier</td>

				<td><select name="pSupplier">
						<option value="0">--Supplier---</option>

						<c:forEach items="${sat}" var="sate">
							<option value="${sate.sid}">${sate.supplierName}</option>


						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td>Price</td>
				<td><input type="text" name="pPrice" /></td>
			</tr>

            <tr>
				<td>Quantity</td>
				<td><input type="text" name="pQuantity" /></td>
			</tr>

			<tr>
				<td>Description</td>
				<td><input type="text" name="pDescription" /></td>
			</tr>


			<tr>
				<td colspan="2"><center>
						<input type="submit" />
					</center></td>
			</tr>

		</table>
	</form>

</body>
</html>