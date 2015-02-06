<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
  <h1>For Struts2</h1>
  <s:set var="age" value="25"/>
  <s:if test="#age >= 30">Over 30</s:if>
  <s:else>Less than 30</s:else>
</body>
</html>