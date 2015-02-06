<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:html>
<head>
</head>
<body>

<html:form action="/result">
<html:select property="stringData" >
<html:optionsCollection name="userData4" property="userData" value="id" label="name"/>
<html:optionsCollection name="listData" value="id" label="name"/>
<html:optionsCollection name="mapData" value="key" label="value"/>
<html:optionsCollection name="iterator" value="id" label="name"/>
<html:optionsCollection name="enum" value="id" label="name"/>
<html:optionsCollection name="labelValueBean"/>
<html:optionsCollection name="arrayUserData" value="id" label="name"/>
<html:optionsCollection name="userData3" property="userDataList" value="id" label="name"/>
</html:select>
<html:submit/>
</html:form>

</body>
</html:html> 