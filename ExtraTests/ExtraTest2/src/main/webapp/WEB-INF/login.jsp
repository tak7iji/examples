<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
</head>

<body>
<h1>Struts 2 localization example</h1>
<p>
Error:<s:property value="fieldErrors"/><p>
<s:if test="fieldErrors.containsKey('userinfo.username')">
Error!<p>
</s:if>
<s:if test="!fieldErrors.isEmpty()">
Error!!<p>
</s:if>

<!--s:form validate="true" action="validateUser" namespace="/user"-->
<s:form action="validateUser" namespace="/user">

    <s:textfield key="global.username" name="userinfo.username" />
    <s:password key="global.password" name="userinfo.password"/>    
    <s:submit key="global.submit" name="submit" />
    
</s:form>

<s:url id="localeEN" namespace="/user" action="locale" >
   <s:param name="request_locale" >en</s:param>
</s:url>
<s:url id="localeDE" namespace="/user" action="locale" >
   <s:param name="request_locale" >de</s:param>
</s:url>
<s:url id="localeFR" namespace="/user" action="locale" >
   <s:param name="request_locale" >fr</s:param>
</s:url>
<s:url id="localeJA" namespace="/user" action="locale" >
   <s:param name="request_locale" >ja</s:param>
</s:url>

<s:a href="%{localeEN}" >English</s:a>
<s:a href="%{localeDE}" >German</s:a>
<s:a href="%{localeFR}" >France</s:a>
<s:a href="%{localeJA}" >Japanese</s:a>
</body>
</html>