<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h2>Product List</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td>
                <a href="<c:url value="/products/showFormForUpdate?productId='${product.id}"/>">Edit</a>
                <a href="<c:url value="/products/deleteProduct?productId='${product.id}"/>">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<br>

<a href="<c:url value='/products/showFormForAdd'/>">Add Product</a>
</body>
</html>
