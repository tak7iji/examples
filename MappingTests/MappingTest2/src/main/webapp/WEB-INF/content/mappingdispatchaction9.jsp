<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <body>
        <s:form action="/test9/test9_dispatch1">
            <s:textfield name="message.message"/>
            <s:submit/>
        </s:form>
        <s:form action="/Nest/test9_dispatch2">
            <s:textfield name="message.message"/>
            <s:submit/>
        </s:form>
    </body>
</html>