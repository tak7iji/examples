<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>
<html>
<body>
    <logic:iterate name="result" id="data">
        <bean:write name="data" property="key"/> : <bean:write name="data" property="value"/><p>
    </logic:iterate>
    
    <!-- FormBeanのプロパティがCollectionである場合、FormBean名とプロパティ名を指定して値を表示する事ができる -->
    <nested:iterate name="mapbacked" property="values">
        <nested:write/><p>
    </nested:iterate>

    <c:forEach items="${result}" var="data">
        ${data.key} : ${data.value}<p>
    </c:forEach>
</body>
</html>