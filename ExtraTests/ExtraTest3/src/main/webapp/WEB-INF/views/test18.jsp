<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
</head>
<body>

<form:form modelAttribute="selectedValue" action="${appUrl}/result18">
<spring:message code='global.check1' var="altMessage"/>
<form:radiobutton path="stringData" value="aaa" alt="${altMessage}"/>Check1<br>
<form:radiobutton path="stringData" value="bbb"/>Check2<br>
<c:forEach var="radioValue" items="${RadioValue}">
<form:radiobutton path="stringData" value="${radioValue.idValue}"/>CheckX<br>
</c:forEach>
<form:radiobuttons path="stringData" items="${RadioValue}" itemValue="idValue" delimiter="<br>"/>CheckY<br>
<form:radiobuttons path="stringData" items="${MapValue}" delimiter="<br>"/><br>
<c:forEach var="entry" items="${MapValue}">
<form:radiobutton path="stringData" value="${key}" label="${value}"/><br>
</c:forEach>
<input type="submit">
</form:form>

</body>
</html> 