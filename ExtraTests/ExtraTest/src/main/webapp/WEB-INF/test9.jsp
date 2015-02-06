<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html>
<body>
  <h1>For Struts1</h1>
  <bean:parameter id="foo_s1" name="foo"/>
  <bean:write name="foo_s1"/>
  
  <h1>For JSTL</h1>
  <c:set var="foo_jstl" value="${param.foo}"/>
  <c:out value="${foo_jstl}"/>

  <h1>For EL</h1>
  ${param.foo}
  
</body>
</html>