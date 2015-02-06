<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<body>
		<s:form action="/test5-dispatch">
			<s:textfield name="message.message"/>
			<s:submit name="dispatch1"/>
			<s:submit name="dispatch2"/>
		</s:form>
	</body>
</html>