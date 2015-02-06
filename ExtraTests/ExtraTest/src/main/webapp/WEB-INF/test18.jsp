<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>
<html:html>
<head>
</head>
<body>

<html:form action="/result">
<html:radio property="stringData" value="aaa"/>Check1<br>
<html:radio property="stringData" value="bbb"/>Check2<br>
<logic:iterate id="radioValue" name="RadioValue">
<html:radio idName="radioValue" value="idValue" property="stringData"/>CheckX<br>
</logic:iterate>

<logic:iterate id="mapValue" name="MapValue">
<html:radio idName="mapValue" value="key" property="stringData"/><bean:write name="mapValue" property="value"/><br>
</logic:iterate>

<html:hidden property="stringData" value="foo" write="true"/>

<html:submit/>
</html:form>

</body>
</html:html> 