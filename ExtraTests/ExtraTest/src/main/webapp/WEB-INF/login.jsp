<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html>
<head>
<!--html:javascript formName="/validateUser"/-->
</head>

<body>
<h1>Struts 1 localization example</h1>

<!--html:form action="/validateUser.do" onsubmit="return validateUi(this)"-->
<html:form action="/validateUser.do">

    <logic:messagesPresent message="false" name="username">
      Error!
    </logic:messagesPresent>
    <logic:messagesPresent>
      Error!!
    </logic:messagesPresent>
    <!--
    <html:messages id="msg1" property="username" bundle="validate">
        <bean:write name="msg1"/><p>
    </html:messages>
    <html:errors property="username" bundle="validate"/><p>
    -->
    <bean:message key="${messageBean.userNameKey}"/>
    <html:errors property="username" bundle="validate"/><p>
    <bean:message name="messageBean" property="userNameKey"/>
    <html:text property="username"/><p>
    <!--
    <html:messages id="msg2" property="password" bundle="validate">
        <bean:write name="msg2"/><p>
    </html:messages>
    <html:errors property="password" bundle="validate"/><p>
    -->
    <html:errors property="password" bundle="validate"/><p>
    <bean:message key="global.password"/>
    <html:password property="password" redisplay="true"/><p>
    <html:submit>
    <bean:message key="global.submit"/>
    </html:submit>
    <html:cancel/>
</html:form>

<html:link action="/English" >English</html:link>
<html:link action="/German" >German</html:link>
<html:link action="/France" >France</html:link>
<html:link action="/Japanese" >Japanese</html:link>

 
</body>
</html>