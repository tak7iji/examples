<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html>
<body>
    <logic:iterate name="result" id="data">
        <bean:write name="data" property="key"/> : <bean:write name="data" property="value[0]"/><p>
    </logic:iterate>

    <c:forEach items="${result}" var="data">
        ${data.key} : ${data.value[0]}<p>
    </c:forEach>
</body>
</html>