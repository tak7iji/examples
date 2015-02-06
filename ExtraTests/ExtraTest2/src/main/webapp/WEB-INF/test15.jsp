<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
<s:select label="My Selection"
           name="mySelection"
           value="%{'POPEYE'}"
           list="%{#{'SUPERMAN':'Superman', 'SPIDERMAN':'spiderman'}}">
</s:select> 
</body>
</html>