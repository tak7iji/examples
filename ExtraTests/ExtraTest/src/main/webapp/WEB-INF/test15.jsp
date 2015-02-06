<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:xhtml />
<html:html>
<head>
<html:base/>
</head>
<body>
<html:messages id="msg1" message="true" property="key1">
  <bean:write name="msg1"/><br>
</html:messages>

<html:messages id="msg2" name="local.key" message="false" property="key2">
  <bean:write name="msg2"/><br>
</html:messages>

<html:messages id="msg3" message="false" property="key3">
  <bean:write name="msg3"/><br>
</html:messages>
<html:errors property="key3"/><br>

<html:messages id="msg4" name="local.error.key" message="false" property="key4">
  <bean:write name="msg4"/><br>
</html:messages>
<html:errors property="key4" name="local.error.key"/><br>

<html:messages id="msg5" message="true" property="key5">
  <bean:write name="msg5"/><br>
</html:messages>

<html:messages id="msg6" message="true" header="global.header" footer="global.footer">
  <bean:write name="msg6"/><br>
</html:messages>

<html:errors header="global.header" footer="global.footer" suffix="global.suffix" prefix="global.prefix"/>

<html:messages id="msg7" message="true" property="key7">
  <bean:write name="msg7"/><br>
</html:messages>

</body>
</html:html> 