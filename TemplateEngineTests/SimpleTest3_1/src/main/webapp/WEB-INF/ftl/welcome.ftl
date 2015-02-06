<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign spring=JspTaglibs["http://www.springframework.org/tags"]>
<html>

<body>
<h1>SpringMVC localization example</h1>
${appUrl}<br>
${messageBean.message}<br>
${mb.message}<br>
<@spring.url value="foo"/><br>
<@spring.message code="global.username"/>
</body>
</html>