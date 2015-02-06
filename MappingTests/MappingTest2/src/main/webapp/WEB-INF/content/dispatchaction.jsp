<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <body>
        <s:form action="/test2-dispatch">
            <s:textfield name="message.message"/>
            <s:submit name="execute" value="dispatch1"/>
            <s:submit name="execute" value="dispatch2"/>
        </s:form>
    </body>
</html>