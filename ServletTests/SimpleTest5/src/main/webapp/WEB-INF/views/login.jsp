<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
</head>
<body>
<h1>SpringMVC localization example</h1>
<spring:message code="global.username"/>
<form:form modelAttribute="viewordownload" action="${appUrl}/login" method="POST">
<form:radiobutton path="checked" value="view" label="View"/><br>
<form:radiobutton path="checked" value="view" label="View2"/><br>
<form:radiobutton path="checked" value="download1" label="Download1"/><br>
<form:radiobutton path="checked" value="download2" label="Download2"/><br>
<form:radiobutton path="checked" value="download2" label="Download3"/><br>
<input type="submit">
</form:form>
</body>
</html>