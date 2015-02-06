<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html>
<body>
  HTTP Headers:<p>
  Bean Tag:<br>
  <bean:header id="hdata" name="User-Agent"/>
  <bean:write name="hdata"/>
  <p>
  
  EL:<br>
  ${header["User-Agent"]}<p>
  
  JSTL:<br>
  <c:set var="userAgent" value="${header['User-Agent']}"/>
  <c:out value="${userAgent}"/>
  
  Cookies:<p>
  Bean Tag:<br>
  <bean:cookie id="cookie" name="JSESSIONID"/>
  <bean:write name="cookie"/>
  <p>
  
  EL:<br>
  ${cookie["JSESSIONID"]}<p>
  <p>
  
  JSTL:<br>
  <c:set var="jsessionid" value="${cookie['JSESSIONID']}"/>
  <c:out value="${jsessionid}"/>
  
</body>
</html>