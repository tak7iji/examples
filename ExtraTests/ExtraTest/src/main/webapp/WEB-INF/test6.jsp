<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html>
<body>
  <h1>For Struts1</h1>
  <bean:include id="s1_child" page="/include/s1_child.jsp"/>
  <bean:write name="s1_child"/>
  <hr>
  
  <bean:include id="s1_child_f" forward="s1_child"/>
  <bean:write name="s1_child_f"/>
  <hr>
  
  <h1>For JSTL</h1>
  <c:import var="jstl_child" url="/WEB-INF/include/jstl_child.jsp"/>
  <c:out value="${jstl_child}" escapeXml="false"/>
  <hr>
  
  <c:import url="/WEB-INF/include/jstl_child.jsp"/>
  <hr>

  <h1>For JSP</h1>
  <jsp:include page="/WEB-INF/include/jstl_child.jsp"/>
</body>
</html>