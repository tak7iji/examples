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
<html:select property="stringData" value="12">
<!-- P1 -->
<html:options name="DynaArray" property="idData" labelName="DynaArray" labelProperty="nameData"/>
<!-- P2 -->
<html:options collection="listData" property="id" labelProperty="name"/>
<!-- P3 -->
<html:options name="idArray" labelName="nameArray"/>
<!-- P4 -->
<html:options collection="mapData" property="key" labelProperty="value"/>
<!-- P5 -->
<html:options collection="iterator" property="id" labelProperty="name"/>
<!-- P6 -->
<html:options collection="enum" property="id" labelProperty="name"/>
<!-- P7 -->
<html:options name="userData2" property="idArray" labelName="userData2" labelProperty="nameList"/>
<!-- P8 -->
<html:options collection="labelValueBean" property="value" labelProperty="label"/>
<!-- P9 -->
<html:options collection="arrayUserData" property="id" labelProperty="name"/>
<!-- P10 -->
<bean:define id="userDataList" name="userData3" property="userDataList"/>
<html:options collection="userDataList" property="id" labelProperty="name"/>
</html:select>
<html:submit/>
</html:form>

</body>
</html:html> 