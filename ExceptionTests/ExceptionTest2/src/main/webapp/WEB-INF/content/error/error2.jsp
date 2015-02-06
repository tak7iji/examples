<%@ page language="java" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <body>
        <h1>Error!!</h1>
        <h2>Error Messages</h2>
        <s:actionerror/>
        <s:property value="%{exception.message}"/>
    </body>
</html>