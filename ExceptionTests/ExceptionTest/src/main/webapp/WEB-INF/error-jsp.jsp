<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ page import="java.io.IOException" %>
<%@ page errorPage="/WEB-INF/error1.jsp"%>

<html:html>
	<body>
		<% 
		  int i = 0;
		  if ( i == 0 ) {
            throw new IOException("Wow!"); 
		  }
		%>
	</body>
</html:html>