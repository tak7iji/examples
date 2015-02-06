<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html>

<body>
<h1>Struts 1 localization example</h1>

<h4>
<bean:write name="ui" property="username"/><br>
${ui.username}<br>
<jsp:useBean id="ui" scope="session" class="org.sample.struts1.extra.UserInfo"/>
<jsp:getProperty name="ui" property="username"/>
</h4>

</body>
</html>