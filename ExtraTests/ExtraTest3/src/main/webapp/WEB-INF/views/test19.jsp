<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<base href='http://www.bar.com'>
</head>
<body>

<spring:url var="var1" value="http://www.foo.com"/><br>
<spring:url var="var2" value="http://www.foo.com" context="bar"/><br>
<spring:url var="var3" value="foo"/><br>
<spring:url var="var4" value="foo" context="bar"/><br>
<spring:url var="var5" value="/foo"/><br>
<spring:url var="var6" value="/foo" context="bar"/><br>

<a href='${var1}'>var1</a><br>
<a href='${var2}'>var2</a><br>
<a href='${var3}'>var3</a><br>
<a href='${var4}'>var4</a><br>
<a href='${var5}'>var5</a><br>
<a href='${var6}'>var6</a><p>

<a href="${spring:mvcUrl('ET#test19').arg(0, '1').buildAndExpand('foo')}">link</a><br>
<a href="${spring:mvcUrl('ET#test19_1').arg(0, '2').build()}">link1</a><br>
<a href="${spring:mvcUrl('ET#test19_2').buildAndExpand('foo2')}">link2</a><br>

${id}

</body>
</html> 