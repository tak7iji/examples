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
<html:checkbox property="data" value="a"/><bean:message key="global.check1"/><br>
<html:checkbox property="data"/><bean:message key="global.check2"/><br>
<html:submit/>
</html:form>
</body>
</html:html>