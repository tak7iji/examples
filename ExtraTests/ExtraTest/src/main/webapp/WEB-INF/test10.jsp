<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html>
<body>
  <h1>For Struts1</h1>
  <bean:define id="testBean" name="tbean" type="org.sample.struts1.extra.TestBean"/>
  <bean:size id="size" name="testBean" property="testMap"/>
  <bean:write name="size"/>
  
  <h1>For JSTL</h1>
  ${fn:length(tbean.testMap)}
  
</body>
</html>