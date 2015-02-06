<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html><body>

<h1>For Struts1</h1>
<logic:empty name="foo1">Empty!</logic:empty>

<h1>For JSTL</h1>
<c:if test="${empty foo1}">Empty!</c:if>

<h1>For EL</h1>
${empty foo1 ? "Empty!" : ""}

</body></html> 