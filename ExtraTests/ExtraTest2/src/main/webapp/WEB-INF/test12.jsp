<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
  <h1>For Struts2</h1>
  <% session.setAttribute("foo1",""); %>
  Value: <s:property value="#session.foo1"/><p>
  <s:if test="#session.foo1==''">Empty!</s:if><p>
  <s:if test="#session.foo1 != null">Present</s:if><p>
</body>
</html>