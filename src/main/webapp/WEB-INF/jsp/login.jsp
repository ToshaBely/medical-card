<%--
  Created by IntelliJ IDEA.
  User: anton
  Date: 8.4.16
  Time: 14.43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
</head>
<body>

<form action="/login" method="post">
  <label for="username">Username</label>
  <input type="text" id="username" name="username"/>

  <label for="password">Password</label>
  <input type="password" id="password" name="password"/>

  <button type="submit" class="button">Log in</button>

</form>

</body>
</html>

