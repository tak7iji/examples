<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
  <h1>For Struts2</h1>
  <s:set var="sMsg">Hello Struts2</s:set>
  <s:property value="#sMsg"/><p>
  
  <s:property value="tbean.username"/><p>

  <s:property value="#session.tbean_session.username"/><p>

  <s:set var="uid" value="tbean.username"/>
  <s:property value="#uid"/><p>

  <s:set var="data_s2" scope="session">Hello Struts2</s:set>
  <s:property value="#session.data_s2"/><p>
  
</body>
</html>