<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Medical App Login</title>
</head>
<body>

<div align="center" style="margin-top: 15%;">
  <form action="/login" method="post">
    <table>
      <tr>
        <td>
          <label for="username">Username:</label>
        </td>
        <td>
          <input type="text" id="username" name="username"/>
        </td>
      </tr>

      <tr>
        <td>
          <label for="password">Password:</label>
        </td>
        <td>
          <input type="password" id="password" name="password"/>
        </td>
      </tr>
    </table>

    <button type="submit" class="button">Log in</button>

  </form>

  <c:if test="${loginError}">
    <p style="color: red;">Wrong credentials</p>
  </c:if>
</div>

</body>
</html>

