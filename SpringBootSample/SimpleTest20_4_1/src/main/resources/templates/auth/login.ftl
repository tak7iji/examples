<#import "/spring.ftl" as spring />
<html>

<body>
<h1>SpringMVC Login Page</h1>
<#if RequestParameters.fail??>
fail!<br>
</#if>
<form action="login" method="post">
Username: <input type="text" name="j_username"><br>
Password: <input type="password" name="j_password"><br>
<input name="submit" type="submit" value="Login"><br>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
</body>
</html>