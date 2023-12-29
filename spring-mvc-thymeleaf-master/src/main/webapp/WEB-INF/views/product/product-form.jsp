<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Form</title>
</head>
<body>
<h2>Product Form</h2>
<form action="<c:url value='/products/saveProduct'/>" method="post">
    <input type="hidden" name="id" value="${product.id}"/>
    Name: <input type="text" name="name" value="${product.name}"/><br>
    Price: <input type="text" name="price" value="${product.price}"/><br>
    Description: <input type="text" name="description" value="${product.description}"/><br>
    <input type="submit" value="Save Product"/>
</form>
<br>
<a href="<c:url value='/products/list'/>">Back to Product List</a>
</body>
</html>
