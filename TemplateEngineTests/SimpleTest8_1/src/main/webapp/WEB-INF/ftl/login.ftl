<#assign fn=JspTaglibs["http://java.sun.com/jsp/jstl/functions"]>
<#assign spring=JspTaglibs["http://www.springframework.org/tags"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<html>

<@spring.url value="/welcome" var="url" />
<body>
<h1>SpringMVC localization example</h1>
<@spring.message code="global.username"/>
<@form.form modelAttribute="mb" action="${url}">
<@form.errors path="message"/><p>
<@form.input path="message"/>
<input type="submit">
</@form.form>

</body>
</html>