<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" isErrorPage="true" %>

<html>
	<body>
		<h1>Error!!</h1>
		<h2>Error Messages</h2>
		${message}
	</body>
</html>