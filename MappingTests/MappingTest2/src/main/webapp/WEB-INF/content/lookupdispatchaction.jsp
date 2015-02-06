<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
	<body>
		<s:form action="/test4-dispatch">
			<s:textfield name="message.message"/>
			<s:i18n name="org.sample.struts2.mapping.MappingTest4">
				<s:text name="submit.dispatch1" var="dispatch1"/>
				<s:text name="submit.dispatch2" var="dispatch2"/>
			</s:i18n>

			<s:submit name="execute" value="%{dispatch1}"/>
			<s:submit name="execute" value="%{dispatch2}"/>

<!--
			<s:submit name="execute" key="global.submit.dispatch1"/>
			<s:submit name="execute" key="global.submit.dispatch2"/>
-->
		</s:form>
	</body>
</html>