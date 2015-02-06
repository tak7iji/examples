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
<logic:iterate id="item" name="mbt" property="indexedData">
<html:checkbox name="item" property="data" indexed="true" value="foo"/>foo<br>
</logic:iterate>
<html:submit/>
</html:form>
</body>
</html:html>