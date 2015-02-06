<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<style>
.errors { color : red ; font-style : italic }
</style>
</head>

<body>
<h1>SpringMVC localization example</h1>

<spring:url var="url" value="bar">
  <spring:param name="arg0">foo</spring:param>
</spring:url>
${url}<p>

<spring:url value="http://www.foo.com"/><br>
<spring:url value="http://www.foo.com" context="bar"/><br>
<spring:url value="foo"/><br>
<spring:url value="foo" context="bar"/><br>
<spring:url value="/foo"/><br>
<spring:url value="/foo" context="bar"/><br>

${spring:mvcUrl("ET#login").arg(0, "lang").buildAndExpand("en")}

<form:form modelAttribute="userinfo" action="${appUrl}/user/validateUser">
    <spring:bind path="username">
        ${status.error ? "Error!" : ""}<p>
    </spring:bind>
    <spring:bind path="*">
        ${status.error ? "Error!!" : ""}<p>
    </spring:bind>
    Error: <form:errors path="*"/><p>
    <form:errors path="username" cssClass="errors"/><p>
    <form:label path="username"><spring:message code="global.username"/></form:label>
    <form:input path="username" cssErrorClass="input_error"/><p>
    <form:errors path="password" cssClass="errors"/><p>
    <form:label path="password"><spring:message code="global.password"/></form:label>
    <form:password path="password" cssErrorClass="input_error"/><p>
    <input type="submit" name="submit" value="<spring:message code="global.submit"/>"/>

</form:form>

<a href="${appUrl}/user/locale?lang=en" >English<a>
<a href="${appUrl}/user/locale?lang=de" >German<a>
<a href="${appUrl}/user/locale?lang=fr" >France<a>
<a href="${appUrl}/user/locale?lang=ja" >Japanese<a>


</body>
</html>