<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<body>
<c:forEach var="data" items="${multiBoxTest.data}">
  String[]: ${data}<br>
</c:forEach>

Boolean: ${multiBoxTest.checked}<br>

<c:forEach var="data" items="${multiBoxTest.checkedArray}">
  Boolean[]: ${data}<br>
</c:forEach>

<c:forEach var="data" items="${multiBoxTest.checkedList}">
  List&lt;String&gt;: ${data}<br>
</c:forEach>

</body>
</html>