<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<body>
    ${key1}<br>
    ${key2}<br>
    <spring:message text="${key1}"/><br>
    <spring:message text="${key3}"/><br>
    ${key3 != null ? key3 : "no message"}<br>
    <spring:message code="${key4}"/><br>
    Not escaped: ${key5}<br>
    Escaped: ${fn:escapeXml(key5)}<br>
    <spring:message code="${key6}" arguments="${args}"/><br>
    
    <c:if test="${key1 != null}">
      <div>${key1}</div>
    </c:if>
</body>
</html>