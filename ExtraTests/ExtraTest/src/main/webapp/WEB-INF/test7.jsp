<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html>
<body>
  <h1>For Struts1</h1>
  <bean:message key="global.test7" arg0="struts1"/>
  
  <h1>For JSTL</h1>
  <fmt:bundle basename="global">
    <fmt:message key="global.test7">
      <fmt:param value="jstl"/>
    </fmt:message>
  </fmt:bundle>
</body>
</html>