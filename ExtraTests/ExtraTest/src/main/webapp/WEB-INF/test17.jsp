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
<!-- P1 -->
<html:optionsCollection property="userDataList"/>
<!-- P2 -->
<html:optionsCollection name="listData" value="id" label="name"/>
<!-- P3 -->
<!-- -->
<!-- P4 -->
<html:optionsCollection name="mapData" value="key" label="value"/>
<!-- P5 -->
<html:optionsCollection name="iterator" value="id" label="name"/>
<!-- P6 -->
<html:optionsCollection name="enum" value="id" label="name"/>
<!-- P7 -->
<!-- -->
<!-- P8 -->
<html:optionsCollection name="labelValueBean"/>
<!-- P9 -->
<html:optionsCollection name="arrayUserData" value="id" label="name"/>
<!-- P10 -->
<html:optionsCollection name="userData3" property="userDataList" value="id" label="name"/>
</html:select>
<html:submit/>
</html:form>

</body>
</html:html> 