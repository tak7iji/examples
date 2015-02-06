<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>

<body>
<h1>SpringMVC localization example</h1>
<spring:message code="global.username"/>
<spring:url value='/welcome' var="url"/>
<form:form modelAttribute="mb" action="${url}">
<form:errors path="message"/><p>
<form:input path="message"/>
<input type="submit">
</form:form>
${requestScope.mb}<br>

${fn:escapeXml('<a href="http://www.google.com">Google</a>')}<br>
</body>
</html>