<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<body>
<form:form modelAttribute="multiBoxTest" action="${appUrl}/result14">
<spring:message code='global.check1' var="message1"/>
<spring:message code='global.check2' var="message2"/>
<form:checkbox path="checkedList" label="${message1}" value="on"/><br>
<form:checkbox path="checkedList" label="${message2}" value="on"/><br>
<input type="submit">
</form:form>
</body>
</html>