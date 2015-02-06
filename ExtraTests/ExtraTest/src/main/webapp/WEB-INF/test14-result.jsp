<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:html>
<body>
<logic:notEmpty name="mbt" property="data">
<logic:iterate id="dat" name="mbt" property="data">
  String[]: <bean:write name="dat"/><br>
</logic:iterate>
</logic:notEmpty>

Boolean: <bean:write name="mbt" property="checked" ignore="true"/><br>

<logic:notEmpty name="mbt" property="checkedArray">
<logic:iterate id="dat" name="mbt" property="checkedArray">
  Boolean[]: <bean:write name="dat"/><br>
</logic:iterate>
</logic:notEmpty>

<logic:notEmpty name="mbt" property="intData">
<logic:iterate id="dat" name="mbt" property="intData">
  Integer[]: <bean:write name="dat"/><br>
</logic:iterate>
</logic:notEmpty>

<logic:notEmpty name="mbt" property="dataList">
<c:forEach var="i" begin="0" end="1" step="1">
  List&lt;String&gt;: <bean:write name="mbt" property="listData[${i}]"/><br>
</c:forEach>
</logic:notEmpty>

<logic:notEmpty name="mbt" property="indexedData">
<logic:iterate id="item" name="mbt" property="indexedData">
  Indexed: <bean:write name="item" property="data"/><br>
</logic:iterate>
</logic:notEmpty>

</body>
</html:html> 