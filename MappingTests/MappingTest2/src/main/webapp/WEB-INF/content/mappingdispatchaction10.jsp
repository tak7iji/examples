<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <body>
        <s:form action="/forward1">
            <s:textfield name="message.message"/>
            <s:submit/>
        </s:form>
    </body>
</html>