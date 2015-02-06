<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
  <h1>For Struts2</h1>
  <s:set var="foo_s2" value="#paramters.foo"/>
  <s:property value="#foo_s2"/><p>
  
</body>
</html>