<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<body>
<s:form action="/test3-input">
    <s:iterator var="c" begin="1" end="2">
        <s:textfield name="value.value['value_%{c}']"/><p>
    </s:iterator>
    <s:submit/>
</s:form>

</body>
</html>