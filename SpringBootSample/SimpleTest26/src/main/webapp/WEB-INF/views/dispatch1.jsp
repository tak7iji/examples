<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>

<html>
	<body>
		<h1>Hello Dispatch1!</h1>
		${message.message}<br>
		<a href='<spring:url value="test2"/>'>back</a>
	</body>
</html>