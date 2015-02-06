<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
  <h1>For Struts2</h1>
  <s:set var="data_s2" scope="session">Hello Struts2</s:set>
  <s:set var="s2_session" value="#session"/>
  
  <s:property value="#s2_session.data_s2"/><p>
  
</body>
</html>