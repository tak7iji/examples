<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<body>
<h1>Spring + MyBatis example 1</h1>

<c:forEach var="col" items="${data}">
id: ${col.c_id}<br>
name: ${col.c_name}<br>
address: ${col.c_address}<br>
</c:forEach>

</body>
</html>