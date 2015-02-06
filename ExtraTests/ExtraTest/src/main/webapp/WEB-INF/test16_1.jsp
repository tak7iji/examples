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
<html:options name="StaticArray" property="idData" labelName="StaticArray" labelProperty="nameData"/>
<html:options collection="listData" property="id" labelProperty="name"/>
<html:options name="idArray" labelName="nameArray"/>
<html:options collection="mapData" property="key" labelProperty="value"/>
<html:options collection="iterator" property="id" labelProperty="name"/>
<html:options collection="enum" property="id" labelProperty="name"/>
<html:options name="userData2" property="idArray" labelName="userData2" labelProperty="nameList"/>
<html:options collection="labelValueBean" property="value" labelProperty="label"/>
<bean:define id="userDataList" name="userData3" property="userDataList"/>
<html:options collection="userDataList" property="id" labelProperty="name"/>
</html:select>
<html:submit/>
</html:form>

</body>
</html:html> 