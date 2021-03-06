<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<body>
<form:form modelAttribute="selectedValue" action="${appUrl}/result">
<form:select path="stringData">
<!-- P1 -->
<!-- DynaActionForm相当のBeanを作成 -->
<!-- P2 -->
<form:options items="${listData}" itemValue="id" itemLabel="name"/>
<!-- P3 -->
<c:forEach var="idx" begin="0" end="${fn:length(idArray) - 1}" step="1">
<form:option value="${idArray[idx]}" label="${nameArray[idx]}"/>
</c:forEach>
<!-- P4 -->
<form:options items="${mapData}"/>
<!-- P5 -->
<c:forEach var="iter" items="${iterator}">
<form:option value="${iter.id}" label="${iter.name}"/>
</c:forEach>
<!-- P6 -->
<c:forEach var="elem" items="${vector}">
<form:option value="${elem.id}" label="${elem.name}"/>
</c:forEach>
<!-- P7 -->
<c:forEach var="idx" begin="0" end="${fn:length(userData2.idArray) - 1}" step="1">
<form:option value="${userData2.idArray[idx]}" label="${userData2.nameList[idx]}"/>
</c:forEach>
<!-- P8 -->
<!-- LabelValueBean相当のBeanを作成 -->
<!-- P9 -->
<form:options items="${arrayUserData}" itemValue="id" itemLabel="name"/>
<!-- P10 -->
<form:options items="${userData3.userDataList}" itemValue="id" itemLabel="name"/>
</form:select>
<input type="submit">
</form:form>
</body>
</html>