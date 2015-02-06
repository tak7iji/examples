<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<body>
    request:<s:property value="#request"/><p>
    session:<s:property value="#session"/><p>
    parameters:<s:property value="#parameters"/><p>
    visited:<s:property value="visited"/><p>
    JSESSIONID:<s:property value="JSESSIONID"/><p>
    cookies:<!-- s:property value="cookies[0]['value']"/--><p>
    request:<!-- s:property value="request"/--><p>
    valuestack[0]:<s:property value="[0].visited"/><p>
    valuestack[1]:<s:property value="[1]"/><p>
</body>
</html>