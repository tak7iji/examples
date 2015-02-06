<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
    <s:iterator value="result">
        <s:property value="key"/> : <s:property value="value"/><p>
    </s:iterator>
</body>
</html>