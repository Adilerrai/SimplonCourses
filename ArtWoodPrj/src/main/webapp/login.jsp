<%--
  Created by IntelliJ IDEA.
  User: sap
  Date: 19/12/2023
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div align="centre">
    <h1>User Login</h1>
    <form action=LoginServlet method=post>
        <table>
            <tr><td>Enter name:</td><td><input type="text" name="txtName"></td></tr>
            <tr><td>Enter password:</td><td><input type="password" name="txtPwd"></td></tr>
            <tr><td><input type="submit" value="Login"></td><td> <input type="reset"></td></tr>
        </table>
    </form>
</div>

</body>
</html>
