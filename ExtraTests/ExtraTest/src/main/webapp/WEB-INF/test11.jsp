<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html><body>

<%
session.setAttribute("age","25");
%>
<h1>For Struts1</h1>
<logic:greaterEqual name="age" value="30">>Over 30</logic:greaterEqual>
<logic:lessThan name="age" value="30">Less than 30</logic:lessThan>

<h1>For JSTL</h1>
<c:choose>
  <c:when test="${age >= 30}">Over 30</c:when>
  <c:otherwise>Less than 30</c:otherwise>
</c:choose>

<h1>For EL</h1>
${age >= 30 ? "Over 30" : "Less than 30"}
</body></html> 