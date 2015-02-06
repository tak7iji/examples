<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html:xhtml />
<html:html>
<head>
<html:base ref="site"/>
</head>
<body>
<!-- html:link -->
<html:link action="/test19-action"> action </html:link><br>
<html:link forward="success19"> forward </html:link><br>
<html:link href="http://www.google.com"> href(#1) </html:link><br>
<html:link href="/ExtraTest/forward/success19_f.jsp"> href(#2) </html:link><br>
<html:link href="../forward/success19_f.jsp"> href(#3) </html:link><br>
<html:link href="/manager/html"> href(#4) </html:link><br>
<html:link href="success19_g.jsp"> href(#5) </html:link><br>
<html:link page="/forward/success19_f.jsp"> page(#1) </html:link><br>
<html:link page="/../manager/html"> page(#2) </html:link><br>

<!-- Query P1 -->
<html:link action="/test19-action" paramId="singleValue1" paramName="singleValue1"> Query String(#1) </html:link><br>
<!-- Query P2 -->
<html:link action="/test19-action" transaction="true" paramId="singleValue2" paramName="singleValue2" paramProperty="singleParameter"> Query String(#2) </html:link><br>
<!-- Query P3 -->
<html:link action="/test19-action" name="mapValue1"> Query String(#3) </html:link><br>
<!-- Query P4 -->
<html:link action="/test19-action" name="mapValue2" property="mappedValue"> Query String(#4) </html:link><br>

<!-- html:rewrite -->
<html:rewrite action="/test19-action"></html:rewrite><br>
<html:rewrite forward="success19"></html:rewrite><br>
<html:rewrite href="http://www.google.com"></html:rewrite><br>
<html:rewrite href="/ExtraTest/forward/success19_f.jsp"></html:rewrite><br>
<html:rewrite href="../forward/success19_f.jsp"></html:rewrite><br>
<html:rewrite href="/manager/html"></html:rewrite><br>
<html:rewrite href="success19_g.jsp"></html:rewrite><br>
<html:rewrite page="/forward/success19_f.jsp"></html:rewrite><br>
<html:rewrite page="/../manager/html"></html:rewrite><br>
<!-- Query P1 -->
<html:rewrite action="/test19-action" paramId="singleValue1" paramName="singleValue1"> Query String(#1) </html:rewrite><br>
<!-- Query P2 -->
<html:rewrite action="/test19-action" transaction="true" paramId="singleValue2" paramName="singleValue2" paramProperty="singleParameter"> Query String(#2) </html:rewrite><br>
<!-- Query P3 -->
<html:rewrite action="/test19-action" name="mapValue1"> Query String(#3) </html:rewrite><br>
<!-- Query P4 -->
<html:rewrite action="/test19-action" name="mapValue2" property="mappedValue"> Query String(#4) </html:rewrite><br>

<!-- html:image -->
<html:image src="images/execute.gif"/>

<!-- html:img -->
<html:img src="images/execute.gif" paramId="singleValue1" paramName="singleValue1"/>
<html:img srcKey="global.page.key"/>
<html:img page="/images/execute.gif"/>
<html:img pageKey="global.page.key"/>
<br>
<!-- html:param -->
<html:rewrite action="/test19-action" module="/user">
<html:param name="aaa" value="bbb"/>
<html:param name="ccc"/>
<html:param name="ddd">eee</html:param>
</html:rewrite><br>

</body>
</html:html> 