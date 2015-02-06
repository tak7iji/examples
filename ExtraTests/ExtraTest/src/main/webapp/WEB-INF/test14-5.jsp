<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:xhtml />
<html:html>
<head>
<html:base/>
</head>
<body>
<html:form action="/test14-action">
<c:forEach var="i" begin="0" end="1" step="1">
  <html:checkbox property="listData[${i}]" indexed="true" value="${i+1}"/><bean:message key="global.check${i+1}"/><br>
</c:forEach>
<html:submit/>
</html:form>
</body>
</html:html>