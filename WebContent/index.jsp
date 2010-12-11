
<%@page contentType="text/html"%>
<jsp:useBean id="userbean" scope="session" type="beans.UserBean" />
<html>
<head><title>Loggin</title></head>
<body>
<br><br>
<form action="image" method="post">
Username: <input type="text" name="username"
                 value=<jsp:getProperty name="userbean" property="username"/>>
<br>
Password: <input type="text" name="password"><br>
<input type="submit" value="Log In">
</form>
</body>
</html>
