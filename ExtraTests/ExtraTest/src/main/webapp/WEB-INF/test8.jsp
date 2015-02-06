<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html>
<body>
  <h1>For Struts1</h1>
  <bean:define id="data_s1" value="Hello Struts1" toScope="session"/>
  <bean:page id="s1_session" property="session"/>
  <!-- bean:write name="s1_session" property="data_s1" scope="page" /-->
  ${s1_session.getAttribute("data_s1")}
  
  <h1>For JSTL</h1>
  <c:set var="data_jstl" value="Hello JSTL" scope="session"/>
  <c:set var="jstl_session" value="${sessionScope}"/>
  <c:out value="${jstl_session.data_jstl}"/>
  ${jstl_session.data_jstl}
  
</body>
</html>