<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html>
<body>
  <h1>For Struts1</h1>
  <!-- P1 -->
  <bean:define id="sMsg" value="Hello Struts1"/>
  <bean:write name="sMsg"/><p>
  
  <!-- P2 -->
  <bean:define id="testBean" name="tbean" type="org.sample.struts1.extra.TestBean"/>
  <bean:write name="testBean" property="username"/><p>

  <!-- P3 -->
  <bean:define id="testBeanSession" name="tbean_session" type="org.sample.struts1.extra.TestBean"/>
  <bean:write name="testBeanSession" property="username"/><p>

  <!-- P4 -->
  <bean:define id="uid" name="tbean" type="java.lang.String" property="username"/>
  <bean:write name="uid"/><p>

  <!-- P5 -->
  <bean:define id="data_s1" value="Hello Struts1" toScope="session"/>
  <bean:write name="data_s1"/><p>

  <!-- P6 -->  
  <logic:present parameter="foo">foo is exists.</logic:present><p>

  <h1>For JSTL</h1>
  <!-- P1 -->
  <c:set var="sMsg" value="Hello JSTL"/>
  <c:out value="${sMsg}"/><p>

  <!-- P2 -->
  <c:set var="username" value="${tbean}"/>
  <c:out value="${username.username}"/><p>

  <!-- P3 -->
  <c:set var="username_s" value="${tbean_session}"/>
  <c:out value="${username_s.username}"/><p>
  
  <!-- P4 -->
  <c:set var="uid" value="${tbean.username}"/>
  <c:out value="${uid}"/><p>

  <!-- P5 -->
  <c:set var="data_jstl" value="Hello JSTL" scope="session"/>
  <c:out value="${sessionScope.data_jstl}"/>

  <!-- P6 -->
  <c:if test="${param.foo != null}">foo is exists.</c:if><p>
  
  <h1>For EL</h1>
  <!-- P1 -->
  
  <!-- P2 -->
  ${tbean.username}<p>
  
  <!-- P3 -->
  ${tbean_session.username}<p>
  
  <!-- P4 -->
  ${tbean.username}<p>
  
  <!-- P5 -->
  
  <!-- P6 -->

  <h1>For JSP</h1>
  <!-- P1 -->
  <jsp:useBean id="sMsg2" class="java.lang.String" scope="request"/>
  <% sMsg2="Hello JSP"; %>
  <%= sMsg2 %><p>
  
  <!-- P2 -->
  <jsp:useBean id="tbean" type="org.sample.struts1.extra.TestBean" scope="request"/>
  <jsp:getProperty name="tbean" property="username"/><p>

  <!-- P3 -->
  <jsp:useBean id="tbean_session" type="org.sample.struts1.extra.TestBean" scope="session"/>
  <jsp:getProperty name="tbean_session" property="username"/><p>

  <!-- P4 -->

  <!-- P5 -->
  <jsp:useBean id="data_s2" class="java.lang.String" scope="session"/>
  <% data_s2="Hello JSP"; %>
  <%= data_s2 %><p>

  <!-- P6 -->
  
  <!-- P7 -->
  <jsp:useBean id="tb2" class="org.sample.struts1.extra.TestBean" scope="request"/>
  <jsp:setProperty name="tb2" property="username" value="JSP"/>
  <jsp:getProperty name="tb2" property="username"/>

</body>
</html>