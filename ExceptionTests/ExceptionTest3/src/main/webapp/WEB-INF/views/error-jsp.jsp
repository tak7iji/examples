<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page import="java.io.IOException" %>
<%@ page errorPage="error1.jsp"%>
<%@ page session="false" %>

<html>
	<body>
		<% 
		  int i = 0;
		  if ( i == 0 ) {
            throw new IOException("Wow!"); 
		  }
		%>
	</body>
</html>