<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Add Product Form</title>
	</head>
	
	<body>
		<c:if test="${ requestScope.errors != null }">
			<div id = "errors">
				Error(s)!
				<ul>
					<c:forEach var="error" items="${ requestScope.errors }">
						<li>${error}</li>
					</c:forEach>
				</ul>
			</div>
		</c:if>
		<form action="product_save.action">
			<fieldset>
				<legend>Add a product</legend>
				<P>
					<label for="name">Product　Name:</label>
					<input type="text" id="name" name="name" tabindex="1">
				</P>
				<P>
					<label for="name">Description:</label>
					<input type="text" id="description" name="description" tabindex="2">
				</P>
				<P>
					<label for="name">Price:</label>
					<input type="text" id="price" name="price" tabindex="3">
				</P>
				<p id="bottons">
					<input id="reset" type="reset" tabindex="4">
					<input id="submit" type="submit" tabindex="5" value="Add Product">
				</p>
			</fieldset>
		</form>
	</body>
</html>