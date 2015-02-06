<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<body>
<h1>SpringMVC localization example</h1>
${appUrl}<br>
${mb}<br>
${mb.message}<br>
<a href="${appUrl}/logon">login</a>
</body>
</html>